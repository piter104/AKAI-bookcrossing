package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Opinion;

import java.util.List;

@Controller
public class BookRestController {

    private final BookBean bookBean;
    private final OpinionBean opinionBean;
    private final TagBean tagBean;

    @Autowired
    public BookRestController(BookBean bookBean, OpinionBean opinionBean, TagBean tagBean) {
        this.bookBean = bookBean;
        this.opinionBean = opinionBean;
        this.tagBean = tagBean;
    }

    @GetMapping("/")
    public String booksList(Model model) {
        model.addAttribute("books", bookBean.getAllBooks());
        return "index";
    }

    @GetMapping("/book/add")
    public String addBookForm(Model model) {
        String newTags = "";
        model.addAttribute("tag", newTags);
        model.addAttribute("book", new Book());
        model.addAttribute("tags", bookBean.getAllTags());
        return "form";
    }

    @PostMapping("/book/add")
    public String addBookSubmit(@RequestParam(name = "tag", required = false, defaultValue = "") String newTags, @ModelAttribute Book book, Model model) {
        bookBean.insertBook(book);
        tagBean.insertNewTags(newTags, book);
        model.addAttribute("book", book);
        return "redirect:/book/" + book.getId();
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
/*
    private int bookProcess(Book book) {
        bookBean.insertTag(book.getTagList());
        Set<Tag> tags = tagListCheck(book);
        book.setTagList(tags);
        bookBean.insertBook(book);
        return book.getId();
    }

    private Set<Tag> tagListCheck(Book book) {
        Tag tempTag;
        Set<Tag> tags = new HashSet<>();
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
        for (Tag tagV : book.getTagList()) {
            bookBean.insertBookTag(bookId, tagV.getId());
        }
    }
*/
}
