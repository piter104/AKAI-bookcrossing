package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.akai.bookcrossing.model.Book;
<<<<<<< HEAD
=======
import pl.akai.bookcrossing.model.Tag;
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private final BookDaoMapper bookMapper;

    @Autowired
    BookDaoImpl(BookDaoMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
<<<<<<< HEAD
    public Book findBookById(int bookId) {
=======
    public Book getBookById(int bookId) {
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
        return bookMapper.getBookById(bookId);
    }

    @Override
<<<<<<< HEAD
    public List<Book> findAllBooks() {
=======
    public List<Book> getAllBooks() {
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
        return bookMapper.getAllBooks();
    }

    @Override
    public void insertBook(Book book) {
<<<<<<< HEAD

        bookMapper.insertBook(book);
    }
=======
        bookMapper.insertBook(book);
    }

    @Override
    public List<Book> getBooksByOwnerId(int id) {
        return bookMapper.getBooksByOwnerId(id);
    }

    @Override
    public List<Book> getBooksByReaderId(int id) {
        return bookMapper.getBooksByReaderId(id);
    }

    @Override
    public List<Tag> getTagsByBookId(int id) {
        return bookMapper.getTagsByBookId(id);
    }

    @Override
    public List<Book> getBooksByTagId(int id) {
        return bookMapper.getBooksByTagId(id);
    }

    @Override
    public void insertTag(Tag tag) {
        bookMapper.insertTag(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return bookMapper.getAllTags();
    }

    @Override
    public Tag getTagByName(String tagName) {
        return bookMapper.getTagByName(tagName);
    }

    @Override
    public void insertBookTag(int bookId, int tagId) {
        bookMapper.insertBookTag(bookId, tagId);
    }
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
}
