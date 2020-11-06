package pl.akai.bookcrossing.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.akai.bookcrossing.model.User;

@Service
public class CurrentUserService {

    private final UserDao userDao;

    @Autowired
    public CurrentUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getEmail();
        return userDao.getUserByEmail(email);
    }
}
