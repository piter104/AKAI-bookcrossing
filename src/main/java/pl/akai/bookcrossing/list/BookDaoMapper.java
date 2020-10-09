package pl.akai.bookcrossing.list;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.akai.bookcrossing.model.Book;


@Mapper
public interface BookDaoMapper {
    Book findFirstBookWithId(@Param("id") int id);
}
