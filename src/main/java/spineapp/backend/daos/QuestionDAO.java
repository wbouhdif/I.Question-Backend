package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionDAO {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionDAO(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

}
