package pl.akai.bookcrossing.opinion;

import org.springframework.beans.factory.annotation.Autowired;
import pl.akai.bookcrossing.model.Opinion;

import java.util.List;

public class OpinionDaoImpl implements OpinionDao {

    private final OpinionDaoMapper opinionMapper;

    @Autowired
    public OpinionDaoImpl(OpinionDaoMapper opinionMapper) {
        this.opinionMapper = opinionMapper;
    }

    @Override
    public List<Opinion> getOpinionsByBookId(int bookId) {
        return opinionMapper.getOpinionsByBookId(bookId);
    }

    @Override
    public void insertOpinion(Opinion opinion, int bookId) {
        opinionMapper.insertOpinion(opinion, bookId);
    }

    @Override
    public void updateOpinion(Opinion opinion) {
        opinionMapper.updateOpinion(opinion);
    }
}
