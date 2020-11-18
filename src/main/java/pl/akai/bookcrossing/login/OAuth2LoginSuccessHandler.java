package pl.akai.bookcrossing.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.akai.bookcrossing.model.User;
<<<<<<< HEAD
import pl.akai.bookcrossing.user.UserDao;
=======
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    private final UserDao userDao;

    @Autowired
    public OAuth2LoginSuccessHandler(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        User user = userDao.getUserByEmail(oAuth2User.getEmail());

        if (user == null) {
            user = User.builder().fullName(oAuth2User.getName()).email(oAuth2User.getEmail()).build();
            userDao.insertNewUser(user);
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
