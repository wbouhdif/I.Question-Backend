package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spineapp.backend.models.AnsweredQuestionnaire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<AnsweredQuestionnaire> getAnsweredQuestionnaireById(UUID id) {
        return answeredQuestionnaireRepository.findById(id);
    }

    @Transactional
    public UUID createAnsweredQuestionnaire(AnsweredQuestionnaire answeredQuestionnaire) {
        answeredQuestionnaireRepository.save(answeredQuestionnaire);
        return answeredQuestionnaire.getId();
    }

}
