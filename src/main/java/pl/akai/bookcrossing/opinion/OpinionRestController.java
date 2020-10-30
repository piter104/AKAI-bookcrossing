package pl.akai.bookcrossing.opinion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akai.bookcrossing.list.BookDao;
import pl.akai.bookcrossing.list.OpinionInsertBean;
import pl.akai.bookcrossing.model.Opinion;
import pl.akai.bookcrossing.user.UserDao;

@Controller
public class OpinionRestController {
    private final BookDao bookDao;
    private final OpinionDao opinionDao;
    private final UserDao userDao;
    private final OpinionInsertBean opinionInsertBean;

    @Autowired
    public OpinionRestController(BookDao bookDao, OpinionDao opinionDao, UserDao userDao, OpinionInsertBean opinionInsertBean) {
        this.bookDao = bookDao;
        this.opinionDao = opinionDao;
        this.userDao = userDao;
        this.opinionInsertBean = opinionInsertBean;
    }

    @GetMapping("/opinion/{id}")
    public String addOpinion(@PathVariable Integer id, Model model) {
        model.addAttribute("opinion", new Opinion());
        return "add-opinion";
    }

    @PostMapping("/opinion/{id}")
    public String addOpinion(@PathVariable Integer id, Model model, @ModelAttribute Opinion opinion) {
        model.addAttribute("opinion", opinion);
        opinionInsertBean.opinionInsertion(opinion, id);
        return "add-opinion-result";
    }
}
