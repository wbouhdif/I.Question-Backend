package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AnswerDAO;
import spineapp.backend.daos.AnsweredQuestionnaireDAO;
import spineapp.backend.daos.EmployedQuestionDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Answer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/answer")
public class AnswerController {

    private final AnswerDAO answerDAO;
    private final AnsweredQuestionnaireDAO answeredQuestionnaireDAO;
    private final EmployedQuestionDAO employedQuestionDAO;

    /**
     * Constructs instance of AnswerController with the answerDAO, answeredQuestionnaireDAO and employedQuestionDAO via dependency injection.
     * @param answerDAO Parameter of type AnswerDAO to be injected into.
     * @param answeredQuestionnaireDAO Parameter of type AnsweredQuestionnaireDAO to be injected into.
     * @param employedQuestionDAO Parameter of type EmployedQuestionDAO to be injected into.
     */
    @Autowired
    public AnswerController(AnswerDAO answerDAO, AnsweredQuestionnaireDAO answeredQuestionnaireDAO, EmployedQuestionDAO employedQuestionDAO) {
        this.answerDAO = answerDAO;
        this.answeredQuestionnaireDAO = answeredQuestionnaireDAO;
        this.employedQuestionDAO = employedQuestionDAO;
    }

    /**
     * Creates new answer in the database.
     * @param answer Answer object to be posted to the database.
     */
    @PostMapping
    public void createAnswer(@RequestBody Answer answer) {
        answerDAO.createAnswer(answer);
    }

    /**
     * Finds all answers in the database with given answered questionnaire.
     * @param answeredQuestionnaire ID of answered questionnaire to be looked for.
     * @return
     * Returns list of all answers in the database with given answered questionnaire.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given name could not be found.
     */
    @GetMapping(path = "answered_questionnaire={id}")
    public List<Answer> getAnswersByAnsweredQuestionnaire(@PathVariable("id") UUID answeredQuestionnaire) throws EntityNotFoundException {
        if (!answeredQuestionnaireDAO.existsById(answeredQuestionnaire)) {
            throw new EntityNotFoundException(answeredQuestionnaire);
        }
        return answerDAO.getAnswersByAnsweredQuestionnaire(answeredQuestionnaire);
    }

    /**
     * Finds all answers in the database with given employed question.
     * @param employedQuestion ID of the Employed question to be looked for.
     * @return
     * Returns list of all answers in the database with given employed question.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given name could not be found.
     */
    @GetMapping(path = "employed_question={id}")
    public List<Answer> getAnswersByEmployedQuestion(@PathVariable("id") UUID employedQuestion) throws EntityNotFoundException {
        if (!employedQuestionDAO.existsById(employedQuestion)) {
            throw new EntityNotFoundException(employedQuestion);
        }
        return answerDAO.getAnswersByEmployedQuestion(employedQuestion);
    }


}
