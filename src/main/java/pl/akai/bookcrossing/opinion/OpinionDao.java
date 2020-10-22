package pl.akai.bookcrossing.opinion;

import org.springframework.stereotype.Repository;
import pl.akai.bookcrossing.model.Opinion;

@Repository
public interface OpinionDao {

    Opinion getOpinionsByBookId(int bookId);

    void insertOpinion(Opinion opinion);

    void updateOpinion(Opinion opinion);
}
