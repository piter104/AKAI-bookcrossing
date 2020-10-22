package pl.akai.bookcrossing.opinion;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.akai.bookcrossing.model.Opinion;

@Mapper
public interface OpinionDaoMapper {

    Opinion getOpinionsById(@Param("id") int id);

    void insertOpinion(@Param("opinion") Opinion opinion);

    void updateOpinion(@Param("opinion") Opinion opinion);
}
