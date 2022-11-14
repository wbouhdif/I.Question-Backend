package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AnsweredQuestionnaireDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.AnsweredQuestionnaire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/answered_questionnaire")
public class AnsweredQuestionnaireController {

    private final AnsweredQuestionnaireDAO answeredQuestionnaireDAO;

    @Autowired
    public AnsweredQuestionnaireController(AnsweredQuestionnaireDAO answeredQuestionnaireDAO) {
        this.answeredQuestionnaireDAO = answeredQuestionnaireDAO;
    }

    @GetMapping
    public List<AnsweredQuestionnaire> getAnsweredQuestionnaires() {
        return answeredQuestionnaireDAO.getAnsweredQuestionnaires();
    }

    @GetMapping(path = "{answeredQuestionnaireId}")
    public Optional<AnsweredQuestionnaire> getAnsweredQuestionnaire(@PathVariable("answeredQuestionnaireId") UUID id) throws EntityNotFoundException {
        Optional<AnsweredQuestionnaire> answeredQuestionnaire = answeredQuestionnaireDAO.getAnsweredQuestionnaireById(id);
        if (answeredQuestionnaire.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return answeredQuestionnaire;
    }

    @PostMapping
    public UUID createAnsweredQuestionnaire(@RequestBody AnsweredQuestionnaire answeredQuestionnaire) {
        return answeredQuestionnaireDAO.createAnsweredQuestionnaire(answeredQuestionnaire);
    }


}
