package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AccountDAO;
import spineapp.backend.daos.AnsweredQuestionnaireDAO;
import spineapp.backend.daos.QuestionnaireDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.AnsweredQuestionnaire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/answered_questionnaire")
public class AnsweredQuestionnaireController {

    private final AnsweredQuestionnaireDAO answeredQuestionnaireDAO;
    private final QuestionnaireDAO questionnaireDAO;
    private final AccountDAO accountDAO;

    /**
     * Constructs instance of AnswerController with the questionnaireDAO and answeredQuestionnaireDAO via dependency injection.
     * @param answeredQuestionnaireDAO Parameter of type AnsweredQuestionnaireDAO to be injected into.
     * @param questionnaireDAO Parameter of type QuestionnaireDAO to be injected into.
     */
    @Autowired
    public AnsweredQuestionnaireController(AnsweredQuestionnaireDAO answeredQuestionnaireDAO, QuestionnaireDAO questionnaireDAO, AccountDAO accountDAO) {
        this.answeredQuestionnaireDAO = answeredQuestionnaireDAO;
        this.questionnaireDAO = questionnaireDAO;
        this.accountDAO = accountDAO;
    }

    /**
     * Finds all answered questionnaires in database.
     * @return
     * Returns list of all answered questionnaires in database.
     */
    @GetMapping
    public List<AnsweredQuestionnaire> getAnsweredQuestionnaires() {
        return answeredQuestionnaireDAO.getAnsweredQuestionnaires();
    }

    /**
     * Finds answered questionnaire with given id.
     * @param id ID of answered questionnaire to be looked for.
     * @return
     * Returns answered questionnaire with given id.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given ID could not be found.
     */
    @GetMapping(path = "{answeredQuestionnaireId}")
    public Optional<AnsweredQuestionnaire> getAnsweredQuestionnaire(@PathVariable("answeredQuestionnaireId") UUID id) throws EntityNotFoundException {
        Optional<AnsweredQuestionnaire> answeredQuestionnaire = answeredQuestionnaireDAO.getAnsweredQuestionnaireById(id);
        if (answeredQuestionnaire.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return answeredQuestionnaire;
    }

    /**
     * Creates answered questionnaire in database.
     * @param answeredQuestionnaire Instance of type AnsweredQuestionnaire to be posted.
     * @return
     * Returns generated UUID of posted answered questionnaire.
     */
    @PostMapping
    public UUID createAnsweredQuestionnaire(@RequestBody AnsweredQuestionnaire answeredQuestionnaire) {
        return answeredQuestionnaireDAO.createAnsweredQuestionnaire(answeredQuestionnaire);
    }

    /**
     * Finds all answered questionnaires with given questionnaire.
     * @param id id of questionnaire to be looked for.
     * @return
     * Returns list of all answered questionnaires with given questionnaire.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given ID could not be found.
     */
    @GetMapping(path = "questionnaire={questionnaireId}")
    public List<AnsweredQuestionnaire> getAnsweredQuestionnairesByQuestionnaire(@PathVariable("questionnaireId") UUID id) throws EntityNotFoundException {
        if (!questionnaireDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        return answeredQuestionnaireDAO.getAnsweredQuestionnairesByQuestionnaire(id);
    }

    @GetMapping(path = "account={accountId}")
    public List<AnsweredQuestionnaire> getAnsweredQuestionnairesByAccount(@PathVariable("accountId") UUID id) throws EntityNotFoundException {
        if (!accountDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        return answeredQuestionnaireDAO.getAnsweredQuestionnairesByAccount(id);
    }

    @DeleteMapping(path = "{answeredQuestionnaireId}")
    public void deleteAnsweredQuestionnaire(@PathVariable("answeredQuestionnaireId") UUID id) throws EntityNotFoundException {
        if (!answeredQuestionnaireDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        this.answeredQuestionnaireDAO.deleteAnsweredQuestionnaire(id);
    }



}
