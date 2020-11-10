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

    @Autowired
    public BookRestController(BookBean bookBean, OpinionBean opinionBean) {
        this.bookBean = bookBean;
        this.opinionBean = opinionBean;
    }

    @GetMapping("/")
    public String booksList(Model model,
                            @RequestParam(defaultValue = "false") boolean user) {
        model.addAttribute("books", bookBean.getAllBooks());
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/book/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }

    @PostMapping("/book/add")
    public String addBookSubmit(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        bookBean.insertBook(book);
        int bookId = bookBean.getLastInsertedBookId();
        return "redirect:/book/" + bookId;
    }

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(name = "id") Integer id, Model model) {
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
}
