package pl.akai.bookcrossing.opinion;

import org.springframework.beans.factory.annotation.Autowired;
import pl.akai.bookcrossing.model.Opinion;

public class OpinionDaoImpl implements OpinionDao {

    private final OpinionDaoMapper opinionMapper;

    @Autowired
    public OpinionDaoImpl(OpinionDaoMapper opinionMapper) {
        this.opinionMapper = opinionMapper;
    }

    @Override
    public Opinion getOpinionsByBookId(int bookId) {
        return opinionMapper.getOpinionsById(bookId);
    }

    @Override
    public void insertOpinion(Opinion opinion) {
        opinionMapper.insertOpinion(opinion);
    }

    @Override
    public void updateOpinion(Opinion opinion) {
        opinionMapper.updateOpinion(opinion);
    }
}
