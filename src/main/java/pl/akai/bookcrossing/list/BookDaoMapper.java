package pl.akai.bookcrossing.list;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;

import java.util.List;


@Mapper
public interface BookDaoMapper {

    List<Book> getAllBooks();

    Book getBookById(@Param("id") int id);

    int getInsertedBookIdByUserId(@Param("user_id") int id);

    void insertBook(@Param("book") Book book);

    List<Tag> getTagsByBookId(@Param("id") int id);

    List<Book> getBooksByTagId(@Param("id") int id);
}
