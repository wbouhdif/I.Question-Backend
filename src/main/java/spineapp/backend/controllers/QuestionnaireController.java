package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private QuestionnaireDAO questionnaireDAO;

    @Autowired
    public QuestionnaireController(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    @PostMapping
    public UUID createQuestionnaire(@RequestBody Questionnaire questionnaire) {
        return questionnaireDAO.createQuestionnaire(questionnaire);
    }
    @GetMapping(path = "{questionnaireId}")
    public Optional<Questionnaire> getQuestionnaireID(@PathVariable("questionnaireId") UUID id) throws EntityNotFoundException {
        Optional<Questionnaire> questionnaire = questionnaireDAO.getQuestionnaireById(id);
        if (questionnaire.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return questionnaire;
    }

    @GetMapping
    public List<Questionnaire> getQuestionnaires() {
        return questionnaireDAO.getQuestionnaires();
    }

    @DeleteMapping(path = "{questionnaireId}")
    public void deleteQuestionnaire(@PathVariable("questionnaireId") UUID id) throws EntityNotFoundException {
        if (!questionnaireDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        questionnaireDAO.deleteQuestionnaire(id);
    }

}
