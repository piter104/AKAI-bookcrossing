package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.akai.bookcrossing.login.CustomOAuth2User;
import pl.akai.bookcrossing.model.Opinion;
import pl.akai.bookcrossing.model.User;
import pl.akai.bookcrossing.opinion.OpinionDao;
import pl.akai.bookcrossing.user.UserDao;

@Component
public class OpinionInsertBean {
    private final OpinionDao opinionDao;
    private final UserDao userDao;

    @Autowired
    public OpinionInsertBean(OpinionDao opinionDao, UserDao userDao) {
        this.opinionDao = opinionDao;
        this.userDao = userDao;
    }

    public void opinionInsertion(Opinion opinion, Integer bookId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getEmail();
        User user = userDao.getUserByEmail(email);
        opinion.setAuthor(user);
        opinionDao.insertOpinion(opinion, bookId);
    }
}
