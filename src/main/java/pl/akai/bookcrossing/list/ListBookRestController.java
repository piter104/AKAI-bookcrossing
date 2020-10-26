package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListBookRestController {

    private final BookDao bookDao;

    @Autowired
    ListBookRestController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/")
    public String list(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("name", currentPrincipalName);
        model.addAttribute("books", bookDao.findAllBooks());
        return "index";
    }
}
