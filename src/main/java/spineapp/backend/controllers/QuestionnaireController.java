package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.QuestionnaireDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Questionnaire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/questionnaire")
public class QuestionnaireController {

    private final QuestionnaireDAO questionnaireDAO;

    /**
     * Constructs instance of QuestionnaireController with the questionnaireDAO via dependency injection.
     * @param questionnaireDAO Parameter of type QuestionnaireDAO to be injected into.
     */
    @Autowired
    public QuestionnaireController(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    /**
     * Creates new entry in the questionnaire table in the database
     * @param questionnaire Object of type Questionnaire to be posted.
     * @return
     * Returns generated UUID of posted questionnaire.
     */
    @PostMapping
    public UUID createQuestionnaire(@RequestBody Questionnaire questionnaire) {
        return questionnaireDAO.createQuestionnaire(questionnaire);
    }

    /**
     * Finds questionnaire in database with given id.
     * @param id ID of questionnaire to be looked for.
     * @return
     * Returns questionnaire with given id.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given ID could not be found.
     */
    @GetMapping(path = "{id}")
    public Optional<Questionnaire> getQuestionnaireById(@PathVariable("id") UUID id) throws EntityNotFoundException {
        Optional<Questionnaire> questionnaire = questionnaireDAO.getQuestionnaireById(id);
        if (questionnaire.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return questionnaire;
    }

    /**
     * Find all questionnaires in database.
     * @return
     * Returns list of all questionnaires that were found in the database.
     */
    @GetMapping
    public List<Questionnaire> getQuestionnaires() {
        return questionnaireDAO.getQuestionnaires();
    }

    /**
     * Attempts to delete questionnaire with given id from the database.
     * @param id ID of questionnaire to be looked for.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given ID could not be found.
     */
    @DeleteMapping(path = "{id}")
    public void deleteQuestionnaire(@PathVariable("id") UUID id) throws EntityNotFoundException {
        if (!questionnaireDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        questionnaireDAO.deleteQuestionnaire(id);
    }

}
