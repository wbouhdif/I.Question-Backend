package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnsweredQuestionnaireDAO {

    private final AnsweredQuestionnaireRepository answeredQuestionnaireRepository;

    @Autowired
    public AnsweredQuestionnaireDAO(AnsweredQuestionnaireRepository answeredQuestionnaireRepository) {
        this.answeredQuestionnaireRepository = answeredQuestionnaireRepository;
    }

}
