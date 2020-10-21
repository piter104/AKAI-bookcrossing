package pl.akai.bookcrossing.opinion;

import org.springframework.stereotype.Service;
import pl.akai.bookcrossing.model.Opinion;

@Service
public interface OpinionDao {

    Opinion getOpinionsByBookId(int bookId);

    void insertOpinion(Opinion opinion);

    void updateOpinion(Opinion opinion);
}
