package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.EmployedQuestionDAO;
import spineapp.backend.daos.QuestionnaireDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.EmployedQuestion;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/employed_question")
public class EmployedQuestionController {

    private final EmployedQuestionDAO employedQuestionDAO;
    private final QuestionnaireDAO questionnaireDAO;

    /**
     * Constructs instance of EmployedQuestionController with the employedQuestionDAO and questionnaireDAO via dependency injection.
     * @param employedQuestionDAO Parameter of type EmployedQuestionDAO to be injected into.
     * @param questionnaireDAO Parameter of type QuestionnaireDAO to be injected into.
     */
    @Autowired
    public EmployedQuestionController(EmployedQuestionDAO employedQuestionDAO, QuestionnaireDAO questionnaireDAO) {
        this.employedQuestionDAO = employedQuestionDAO;
        this.questionnaireDAO = questionnaireDAO;
    }

    /**
     * Creates new entry in employed_question table in the database.
     * @param employedQuestion Object of type EmployedQuestion to be posted.
     */
    @PostMapping
    public void createEmployedQuestion(@RequestBody EmployedQuestion employedQuestion) {
        employedQuestionDAO.createEmployedQuestion(employedQuestion);
    }

    /**
     * Finds all employed question with given questionnaire.
     * @param questionnaire ID of questionnaire to be looked for.
     * @return
     * Returns all employed questions with given questionnaire.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given ID could not be found.
     */
    @GetMapping(path = "questionnaire={id}")
    public List<EmployedQuestion> getEmployedQuestionsByQuestionnaire(@PathVariable("id") UUID questionnaire) throws EntityNotFoundException {
        if (!questionnaireDAO.existsById(questionnaire)) {
            throw new EntityNotFoundException(questionnaire);
        }
        return employedQuestionDAO.getEmployedQuestionsByQuestionnaire(questionnaire);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployedQuestion(@PathVariable("id") UUID id) throws EntityNotFoundException {
        if (!employedQuestionDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        employedQuestionDAO.deleteEmployedQuestion(id);
    }
}
