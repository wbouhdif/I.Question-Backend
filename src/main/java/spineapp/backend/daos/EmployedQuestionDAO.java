package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.EmployedQuestion;

import java.util.List;
import java.util.UUID;

@Component
public class EmployedQuestionDAO {

    private final EmployedQuestionRepository employedQuestionRepository;

    /**
     * Constructs instance of EmployedQuestionDAO with the employedQuestionRepository via dependency injection.
     * @param employedQuestionRepository Parameter of type EmployedQuestionDAO to be injected into.
     */
    @Autowired
    public EmployedQuestionDAO(EmployedQuestionRepository employedQuestionRepository) {
        this.employedQuestionRepository = employedQuestionRepository;
    }

    /**
     * Creates entry in table employed_question in database.
     * @param employedQuestion Employed question to be posted.
     */
    public void createEmployedQuestion(EmployedQuestion employedQuestion){
        employedQuestionRepository.save(employedQuestion);
    }

    /**
     * Finds all employed questions in database with given questionnaire.
     * @param questionnaireId ID of questionnaire to be looked for.
     * @return
     * Returns list of all employed questions with given questionnaire that were found.
     */
    public List<EmployedQuestion> getEmployedQuestionsByQuestionnaire(UUID questionnaireId) {
        return employedQuestionRepository.findAllByQuestionnaire(questionnaireId);
    }

    /**
     * Checks whether employed question with given ID exists in database.
     * @param id ID of employed question to be checked.
     * @return
     * Returns true or false depending on result of existsById().
     */
    public boolean existsById(UUID id){
        return employedQuestionRepository.existsById(id);
    }

    public void deleteEmployedQuestion(UUID id) {
        employedQuestionRepository.deleteById(id);
    }


}
