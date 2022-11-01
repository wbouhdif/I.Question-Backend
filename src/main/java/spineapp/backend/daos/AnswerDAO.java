package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerDAO {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

}
