package pl.akai.bookcrossing.list;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.akai.bookcrossing.model.Book;
<<<<<<< HEAD
=======
import pl.akai.bookcrossing.model.Tag;
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1

import java.util.List;


@Mapper
public interface BookDaoMapper {

    List<Book> getAllBooks();

    Book getBookById(@Param("id") int id);

<<<<<<< HEAD
    void insertBook(@Param("book") Book book);
=======
    int getInsertedBookIdByUserId(@Param("user_id") int id);

    void insertBook(@Param("book") Book book);

    void insertTag(@Param("tag") Tag tag);

    List<Book> getBooksByOwnerId(@Param("user_id") int id);

    List<Book> getBooksByReaderId(@Param("user_id") int id);

    List<Tag> getTagsByBookId(@Param("id") int id);

    List<Book> getBooksByTagId(@Param("id") int id);

    List<Tag> getAllTags();

    Tag getTagByName(@Param("name") String tagName);

    void insertBookTag(@Param("bookId") int bookId, @Param("tagId") int tagId);
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
}
