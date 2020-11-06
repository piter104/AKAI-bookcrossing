package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private final BookDaoMapper bookMapper;

    @Autowired
    BookDaoImpl(BookDaoMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Book getBookById(int bookId) {
        return bookMapper.getBookById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public void insertBook(Book book) {
        bookMapper.insertBook(book);
    }

    @Override
    public int getInsertedBookIdByUserId(int id) {
        return bookMapper.getInsertedBookIdByUserId(id);
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

}
