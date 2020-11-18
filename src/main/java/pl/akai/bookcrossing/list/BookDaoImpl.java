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
    public Book findBookById(int bookId) {
        return bookMapper.getBookById(bookId);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public void insertBook(Book book) {

        bookMapper.insertBook(book);
    }
}
