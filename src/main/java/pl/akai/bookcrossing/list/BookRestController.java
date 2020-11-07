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
        Book book = makeEmptyTags(3);
        model.addAttribute("book", book);
        model.addAttribute("tags", bookBean.getAllTags());
        return "form";
    }

    @PostMapping("/book/add")
    public String addBookSubmit(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        int bookId = tagsInitialization(book);
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

    private int tagsInitialization(Book book) {
        bookBean.insertTag(book.getTagList());
        List<Tag> tags = tagListCheck(book);
        book.setTagList(tags);
        bookBean.insertBook(book);

        int bookId = bookBean.getLastInsertedBookId();
        bookTagsInsert(book, bookId);
        return bookId;
    }

    private List<Tag> tagListCheck(Book book) {
        Tag tempTag;
        List<Tag> tags = new ArrayList<>();
        for (Tag tagV : book.getTagList()) {
            tempTag = bookBean.getTagByName(tagV.getName());

            if (tempTag.getName() == null || tempTag.getName().length() == 0) {
                continue;
            }
            tags.add(tempTag);
        }
        return tags;
    }

    private void bookTagsInsert(Book book, int bookId) {
        Tag tempTag;
        for (Tag tagV : book.getTagList()) {
            tempTag = bookBean.getTagByName(tagV.getName());
            bookBean.insertBookTag(bookId, tempTag.getId());
        }
    }

    private Book makeEmptyTags(int tagNumber) {
        Book book = new Book();
        for (int i = 1; i <= tagNumber; i++) {
            book.addTag(new Tag());
        }
        return book;
    }
}
