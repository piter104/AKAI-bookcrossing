<<<<<<< HEAD
package pl.akai.bookcrossing.opinion;

import org.springframework.stereotype.Repository;
import pl.akai.bookcrossing.model.Opinion;

import java.util.List;

@Repository
public interface OpinionDao {

    List<Opinion> getOpinionsByBookId(int bookId);

    void insertOpinion(Opinion opinion, int bookId);

    void updateOpinion(Opinion opinion);
}
=======
package pl.akai.bookcrossing.opinion;

import org.springframework.stereotype.Repository;
import pl.akai.bookcrossing.model.Opinion;

import java.util.List;

@Repository
public interface OpinionDao {

    List<Opinion> getOpinionsByBookId(int bookId);

    void insertOpinion(Opinion opinion, int bookId);

    void updateOpinion(Opinion opinion);
}
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
