package pl.akai.bookcrossing.list;

import pl.akai.bookcrossing.model.Book;

import java.util.List;

public interface BookDao {

    Book getBookById(int bookId);

    List<Book> getAllBooks();

    void insertBook(Book book);

    int getInsertedBookIdByUserId(int id);
}
