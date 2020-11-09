package pl.akai.bookcrossing.list;

import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;

import java.util.List;
import java.util.Set;

public interface BookDao {

    Book getBookById(int bookId);

    List<Book> getAllBooks();

    void insertBook(Book book);

    Set<Tag> getTagsByBookId(int id);

    List<Book> getBooksByTagId(int id);

    void insertTag(Tag tag);

    Set<Tag> getAllTags();

    Tag getTagByName(String tagName);

    void insertBookTag(int bookId, int tagId);
}
