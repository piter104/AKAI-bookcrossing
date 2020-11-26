package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.BookFormResponse;
import pl.akai.bookcrossing.model.BookRentRequest;
import pl.akai.bookcrossing.model.Opinion;

import java.util.List;

@Controller
public class BookController {

    private final BookBean bookBean;
    private final OpinionBean opinionBean;
    private final TagBean tagBean;

    @Autowired
    public BookController(BookBean bookBean, OpinionBean opinionBean, TagBean tagBean) {
        this.bookBean = bookBean;
        this.opinionBean = opinionBean;
        this.tagBean = tagBean;
    }

    @GetMapping("/")
    public String booksList(Model model) {
        model.addAttribute("books", bookBean.getAllBooks());
        return "index";
    }

    @GetMapping("/book/{id}/rent")
    public String bookRental(@PathVariable(name = "id") Integer bookId) {
        bookBean.insertBookUserRequest(bookId);
        // bookBean.updateReader(bookId);
        return "redirect:/my-books";
    }

    @GetMapping("/my-books")
    public String myBooksList(Model model) {
        List<BookRentRequest> users = bookBean.getBookRentRequestsByOwnerId();
        model.addAttribute("books_owner", bookBean.getBooksOwnedByCurrentUser());
        model.addAttribute("books_reader", bookBean.getBooksReadByCurrentUser());
        return "my_books";
    }

    @GetMapping("/book/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new BookFormResponse());
        model.addAttribute("tags", bookBean.getAllTags());
        return "form";
    }

    @PostMapping("/book/add")
    public String addBookSubmit(@ModelAttribute BookFormResponse bookFormResponse, Model model) {
        bookBean.insertBook(bookFormResponse);
        tagBean.insertExistingTags(bookFormResponse);
        tagBean.insertNewTags(bookFormResponse);
        model.addAttribute("book", bookFormResponse);
        return "redirect:/book/" + bookFormResponse.getId();
    }

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(name = "id") Integer id, Model model) {
        bookDetailsInitialization(model, id, false);
        return "book-details";
    }

    @PostMapping("/book/{id}")
    public String opinionSubmit(@PathVariable(name = "id") Integer id, @ModelAttribute Opinion opinion, Model model) {
        opinionBean.insertOpinion(opinion, id);
        return "redirect:/book/" + id;
    }

    private void bookDetailsInitialization(Model model, Integer id, boolean isSendSuccess) {
        Book book = bookBean.getBookById(id);
        model.addAttribute("tags", bookBean.getTagsByBookId(id));
        List<Opinion> opinions = opinionBean.getOpinionsByBookId(id);
        model.addAttribute("isSendSuccess", isSendSuccess);
        model.addAttribute("book", book);
        model.addAttribute("opinions", opinions);
        model.addAttribute("opinion", new Opinion());
    }
}
