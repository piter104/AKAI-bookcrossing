<<<<<<< HEAD
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
=======
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
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
