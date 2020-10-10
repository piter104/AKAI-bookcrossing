package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akai.bookcrossing.model.Book;

@Controller
public class ListBookRestController {

    private final BookDao bookDao;

    @Autowired
    ListBookRestController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAllBooks());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        bookDao.insertBook(Book.builder()
                .title("Innowatorzy")
                .author("Innowatorzy")
                .description("Jakaś inna książka")
                .build());
        model.addAttribute("books", bookDao.findAllBooks());
        return "index";
    }

}