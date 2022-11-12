package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Account;
import spineapp.backend.models.AnsweredQuestionnaire;

import java.util.List;

@Component
public class AnsweredQuestionnaireDAO {

    private final AnsweredQuestionnaireRepository answeredQuestionnaireRepository;

    @Autowired
    public AnsweredQuestionnaireDAO(AnsweredQuestionnaireRepository answeredQuestionnaireRepository) {
        this.answeredQuestionnaireRepository = answeredQuestionnaireRepository;
    }

    public List<AnsweredQuestionnaire> getAnsweredQuestionnaires() {
        return answeredQuestionnaireRepository.findAll();
    }

}
