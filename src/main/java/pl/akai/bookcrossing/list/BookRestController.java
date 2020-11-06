package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Opinion;
import pl.akai.bookcrossing.model.Tag;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookRestController {

    private final BookBean bookBean;
    private final OpinionBean opinionBean;

    @Autowired
    public BookRestController(BookBean bookBean, OpinionBean opinionBean) {
        this.bookBean = bookBean;
        this.opinionBean = opinionBean;
    }

    @GetMapping("/")
    public String booksList(Model model) {
        model.addAttribute("books", bookBean.getAllBooks());
        return "index";
    }

    @GetMapping("/book/add")
    public String addBookForm(Model model) {
        Book book = new Book();
        for (int i = 1; i <= 3; i++) {
            book.addTag(new Tag());
        }
        model.addAttribute("book", book);
        model.addAttribute("tags", bookBean.getAllTags());
        return "form";
    }

    @PostMapping("/book/add")
    public String addBookSubmit(@ModelAttribute Book book, Model model) {
        tagsInitialization(model, book);
        int bookId = bookBean.getLastInsertedBookId();
        return "redirect:/book/" + bookId;
    }

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("tags", bookBean.getTagsByBookId(id));
        bookDetailsInitialization(model, id, false);
        return "book-details";
    }

    @PostMapping("/book/{id}")
    public String opinionSubmit(@PathVariable(name = "id") Integer id, @ModelAttribute Opinion opinion, Model model) {
        opinionBean.insertOpinion(opinion, id);
        bookDetailsInitialization(model, id, true);
        return "book-details";
    }

    private void bookDetailsInitialization(Model model, Integer id, boolean isSendSuccess) {
        Book book = bookBean.getBookById(id);
        List<Opinion> opinions = opinionBean.getOpinionsByBookId(id);
        model.addAttribute("isSendSuccess", isSendSuccess);
        model.addAttribute("book", book);
        model.addAttribute("opinions", opinions);
        model.addAttribute("opinion", new Opinion());
    }

    private void tagsInitialization(Model model, Book book) {
        model.addAttribute("book", book);
        List<Tag> tags = new ArrayList<Tag>();
        bookBean.insertTag(book.getTagList());
        for (Tag tagV : book.getTagList()) {
            tags.add(bookBean.getTagByName(tagV.getName()));
        }
        book.setTagList(tags);
        bookBean.insertBook(book);
    }
}
