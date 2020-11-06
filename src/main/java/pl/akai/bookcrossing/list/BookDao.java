package pl.akai.bookcrossing.list;

import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;

import java.util.List;

public interface BookDao {

    Book getBookById(int bookId);

    List<Book> getAllBooks();

    void insertBook(Book book);

    int getInsertedBookIdByUserId(int id);

    List<Tag> getTagsByBookId(int id);

    List<Book> getBooksByTagId(int id);
}
