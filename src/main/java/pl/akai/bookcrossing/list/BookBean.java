package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.akai.bookcrossing.login.CurrentUserService;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;
import pl.akai.bookcrossing.model.User;

import java.util.List;

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

    public int getLastInsertedBookId() {
        User user = currentUserService.getCurrentUser();
        return bookDao.getInsertedBookIdByUserId(user.getId());
    }

    public List<Tag> getTagsByBookId(int id) {
        return bookDao.getTagsByBookId(id);
    }

    public List<Book> getBooksByTagId(int id) {
        return bookDao.getBooksByTagId(id);
    }

    void insertTag(List<Tag> tagList) {
        for (Tag tag : tagList) {
            Tag tempTag = bookDao.getTagByName(tag.getName());
            if (tempTag == null) {
                bookDao.insertTag(tag);
            }
        }
    }

    List<Tag> getAllTags() {
        return bookDao.getAllTags();
    }

    Tag getTagByName(String tagName) {
        return bookDao.getTagByName(tagName);
    }

    void insertBookTag(int bookId, int tagId) {
        bookDao.insertBookTag(bookId, tagId);
    }
}
