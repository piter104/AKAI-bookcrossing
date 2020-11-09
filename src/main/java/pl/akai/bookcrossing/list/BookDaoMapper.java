package pl.akai.bookcrossing.list;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;

import java.util.List;
import java.util.Set;


@Mapper
public interface BookDaoMapper {

    List<Book> getAllBooks();

    Book getBookById(@Param("id") int id);

    void insertBook(@Param("book") Book book);

    Set<Tag> getTagsByBookId(@Param("id") int id);

    List<Book> getBooksByTagId(@Param("id") int id);

    void insertTag(@Param("tag") Tag tag);

    Set<Tag> getAllTags();

    Tag getTagByName(@Param("name") String tagName);

    void insertBookTag(@Param("bookId") int bookId, @Param("tagId") int tagId);
}
