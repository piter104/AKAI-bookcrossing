package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.akai.bookcrossing.login.CurrentUserService;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;
import pl.akai.bookcrossing.model.User;

import java.util.List;
import java.util.Set;

@Component
public class BookBean {

    private final BookDao bookDao;
    private final CurrentUserService currentUserService;


    @Autowired
    public BookBean(BookDao bookDao, CurrentUserService currentUserService) {
        this.currentUserService = currentUserService;
        this.bookDao = bookDao;
    }

    public void insertBook(Book book) {
        User user = currentUserService.getCurrentUser();
        book.setOwner(user);
        bookDao.insertBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public Book getBookById(Integer id) {
        return bookDao.getBookById(id);
    }

    public Set<Tag> getTagsByBookId(int id) {
        return bookDao.getTagsByBookId(id);
    }

    public List<Book> getBooksByTagId(int id) {
        return bookDao.getBooksByTagId(id);
    }

    void insertTag(Tag tag) {
        Tag tempTag = bookDao.getTagByName(tag.getName());
        if (tempTag == null) {
            bookDao.insertTag(tag);
        }
    }

    Set<Tag> getAllTags() {
        return bookDao.getAllTags();
    }

    Tag getTagByName(String tagName) {
        return bookDao.getTagByName(tagName);
    }

    void insertBookTag(int bookId, int tagId) {
        bookDao.insertBookTag(bookId, tagId);
    }
}
