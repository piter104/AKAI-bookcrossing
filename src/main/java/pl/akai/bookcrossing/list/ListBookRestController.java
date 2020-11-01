package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Opinion;
import pl.akai.bookcrossing.opinion.OpinionDao;

import java.util.List;

@Controller
public class ListBookRestController {

    private final BookDao bookDao;
    private final OpinionDao opinionDao;
    private final BookInsertBean bookInsertBean;
    private final OpinionInsertBean opinionInsertBean;

    @Autowired
    public ListBookRestController(BookDao bookDao, OpinionDao opinionDao, BookInsertBean bookInsertBean, OpinionInsertBean opinionInsertBean) {
        this.bookDao = bookDao;
        this.opinionDao = opinionDao;
        this.bookInsertBean = bookInsertBean;
        this.opinionInsertBean = opinionInsertBean;
    }

    private Model modelSetUp(Model model, Integer id) {
        Book book = bookDao.findBookById(id);
        List<Opinion> opinions = opinionDao.getOpinionsByBookId(id);
        model.addAttribute("book", book);
        model.addAttribute("opinions", opinions);
        model.addAttribute("opinion", new Opinion());
        return model;
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
        bookInsertBean.bookInsertion(book);
        return "form-result";
    }

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(name = "id") Integer id, Model model) {
        model = modelSetUp(model, id);
        return "book-details";
    }

    @PostMapping("/book/{id}")
    public String opinionSubmit(@PathVariable(name = "id") Integer id, @ModelAttribute Opinion opinion, Model model) {
        opinionInsertBean.opinionInsertion(opinion, id);
        model = modelSetUp(model, id);
        return "book-details";
    }
}
