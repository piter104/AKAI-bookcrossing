package pl.akai.bookcrossing.list;

import pl.akai.bookcrossing.model.Book;
<<<<<<< HEAD
=======
import pl.akai.bookcrossing.model.Tag;
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1

import java.util.List;

public interface BookDao {

<<<<<<< HEAD
    Book findBookById(int bookId);

    List<Book> findAllBooks();

    void insertBook(Book book);


=======
    Book getBookById(int bookId);

    List<Book> getAllBooks();

    void insertBook(Book book);

    List<Book> getBooksByOwnerId(int id);

    List<Book> getBooksByReaderId(int id);

    List<Tag> getTagsByBookId(int id);

    List<Book> getBooksByTagId(int id);

    void insertTag(Tag tag);

    List<Tag> getAllTags();

    Tag getTagByName(String tagName);

    void insertBookTag(int bookId, int tagId);
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
}
