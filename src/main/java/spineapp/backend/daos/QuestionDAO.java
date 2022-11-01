package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionDAO {

    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionDAO(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

}
