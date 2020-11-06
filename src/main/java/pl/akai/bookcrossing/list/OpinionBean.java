package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.akai.bookcrossing.login.CurrentUserService;
import pl.akai.bookcrossing.model.Opinion;
import pl.akai.bookcrossing.model.User;
import pl.akai.bookcrossing.opinion.OpinionDao;

import java.util.List;

@Component
public class OpinionBean {

    private final OpinionDao opinionDao;
    private final CurrentUserService currentUserService;

    @Autowired
    public OpinionBean(OpinionDao opinionDao, CurrentUserService currentUserService) {
        this.opinionDao = opinionDao;
        this.currentUserService = currentUserService;
    }

    public void insertOpinion(Opinion opinion, Integer bookId) {
        User user = currentUserService.getCurrentUser();
        opinion.setAuthor(user);
        opinionDao.insertOpinion(opinion, bookId);
    }

    public List<Opinion> getOpinionsByBookId(Integer id) {
        return opinionDao.getOpinionsByBookId(id);
    }
}
