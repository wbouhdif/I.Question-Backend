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

    /**
     * Constructs instance of AnsweredQuestionnaireDOA with the answeredQuestionnaireRepository via dependency injection.
     * @param answeredQuestionnaireRepository Parameter of type AnsweredQuestionnaireRepository to be injected into.
     */
    @Autowired
    public AnsweredQuestionnaireDAO(AnsweredQuestionnaireRepository answeredQuestionnaireRepository) {
        this.answeredQuestionnaireRepository = answeredQuestionnaireRepository;
    }

    /**
     * Finds all answered questionnaires in database.
     * @return
     * Returns list of all answered questionnaires found in database.
     */
    public List<AnsweredQuestionnaire> getAnsweredQuestionnaires() {
        return answeredQuestionnaireRepository.findAll();
    }

    /**
     * Finds answered questionnaire in database with given id.
     * @param id ID to be looked for.
     * @return
     * Returns answered questionnaire with given id.
     */
    public Optional<AnsweredQuestionnaire> getAnsweredQuestionnaireById(UUID id) {
        return answeredQuestionnaireRepository.findById(id);
    }

    /**
     * Creates answered questionnaire in database.
     * @param answeredQuestionnaire Answered questionnaire to be posted.
     * @return
     * Returns generated UUID of created answered questionnaire.
     */
    @Transactional
    public UUID createAnsweredQuestionnaire(AnsweredQuestionnaire answeredQuestionnaire) {
        answeredQuestionnaireRepository.save(answeredQuestionnaire);
        return answeredQuestionnaire.getId();
    }

    /**
     * Checks if answered questionnaire with given ID exists in database.
     * @param id ID of answered questionnaire to be looked for.
     * @return
     * Returns true or false depending on the result of existsById().
     */
    public boolean existsById(UUID id){
        return answeredQuestionnaireRepository.existsById(id);
    }

    /**
     * Finds all answered questionnaires with given questionnaire.
     * @param questionnaireId ID of questionnaire to be looked for.
     * @return
     * Returns list of all answered questionnaires with given questionnaire that were found.
     */
    public List<AnsweredQuestionnaire> getAnsweredQuestionnairesByQuestionnaire(UUID questionnaireId) {
        return answeredQuestionnaireRepository.getAnsweredQuestionnairesByQuestionnaire(questionnaireId);
    }

}
