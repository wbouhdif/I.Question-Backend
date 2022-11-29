package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import spineapp.backend.models.Questionnaire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class QuestionnaireDAO {

    private final QuestionnaireRepository questionnaireRepository;

    /**
     * Constructs instance of QuestionnaireDAO with the questionnaireRepository via dependency injection.
     * @param questionnaireRepository Parameter of type QuestionnaireRepository to be injected into.
     */
    @Autowired
    public QuestionnaireDAO(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    /**
     * Finds all questionnaires in database.
     * @return
     * Returns list of all questionnaires that were found.
     */
    public List<Questionnaire> getQuestionnaires(){
        return questionnaireRepository.findAll();
    }

    /**
     * Finds questionnaire in database with given ID.
     * @param id ID to be looked for.
     * @return
     * Returns questionnaire with given ID.
     */
    public Optional<Questionnaire> getQuestionnaireById(UUID id) {
        return questionnaireRepository.findById(id);
    }

    /**
     * Creates entry in questionnaire table in database.
     * @param questionnaire Questionnaire to be posted.
     * @return
     * Returns generated UUID of posted questionnaire.
     */
    @Transactional
    public UUID createQuestionnaire(Questionnaire questionnaire){
        questionnaireRepository.save(questionnaire);
        return questionnaire.getId();
    }

    /**
     * Checks whether questionnaire with given ID exists in database.
     * @param id ID to be checked.
     * @return
     * Returns true or false depending on result of existsById().
     */
    public boolean existsById(UUID id){
        return questionnaireRepository.existsById(id);
    }

    /**
     * Deletes questionnaire with given ID from database.
     * @param id ID of questionnaire to be deleted.
     */
    public void deleteQuestionnaire(UUID id) {
        questionnaireRepository.deleteById(id);
    }

}
