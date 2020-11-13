package pl.akai.bookcrossing.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.akai.bookcrossing.model.Book;

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
    public List<Book> getBooksByOwnerId(int id) {
        return bookMapper.getBooksByOwnerId(id);
    }

    @Override
    public List<Book> getBooksByReaderId(int id) {
        return bookMapper.getBooksByReaderId(id);
    }

}
