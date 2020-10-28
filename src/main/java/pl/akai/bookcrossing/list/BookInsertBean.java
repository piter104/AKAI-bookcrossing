package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.akai.bookcrossing.login.CustomOAuth2User;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.user.UserDao;

@Component
public class BookInsertBean {

    private final UserDao userDao;
    private final BookDao bookDao;

    @Autowired
    public BookInsertBean(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    public void bookInsertion(Book book) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        book.setOwner(userDao.getUserByEmail(oAuth2User.getEmail()));
        bookDao.insertBook(book);
    }
}
