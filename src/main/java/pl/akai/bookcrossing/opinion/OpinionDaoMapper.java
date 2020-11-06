package pl.akai.bookcrossing.opinion;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.akai.bookcrossing.model.Opinion;

import java.util.List;

@Mapper
public interface OpinionDaoMapper {

    List<Opinion> getOpinionsByBookId(@Param("id") int id);

    void insertOpinion(@Param("opinion") Opinion opinion, @Param("bookId") int bookId);

    void updateOpinion(@Param("opinion") Opinion opinion);
}
