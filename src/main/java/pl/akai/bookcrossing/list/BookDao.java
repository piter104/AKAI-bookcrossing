package pl.akai.bookcrossing.list;

import pl.akai.bookcrossing.model.Book;

import java.util.List;

public interface BookDao {

    Book findBookById(int bookId);

    List<Book> findAllBooks();

    void insertBook(Book book);


}
