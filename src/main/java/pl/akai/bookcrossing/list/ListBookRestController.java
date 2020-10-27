package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akai.bookcrossing.model.Book;

@Controller
public class ListBookRestController {

    private final BookDao bookDao;
    private BookAddHandler bookAddHandler;

    @Autowired
    public ListBookRestController(BookDao bookDao, BookAddHandler bookAddHandler) {
        this.bookDao = bookDao;
        this.bookAddHandler = bookAddHandler;
    }

    @GetMapping("/")
    public String list(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("name", currentPrincipalName);
        model.addAttribute("books", bookDao.findAllBooks());
        return "index";
    }

    @GetMapping("/book/add")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }

    @PostMapping("/book/add")
    public String bookSubmit(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        bookAddHandler.bookInsertion(book, bookDao);
        return "formResult";
    }
}
