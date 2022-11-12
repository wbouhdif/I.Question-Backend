package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.QuestionnaireDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Questionnaire;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/questionnaire")
public class QuestionnaireController {

    private final QuestionnaireDAO questionnaireDAO;

    @Autowired
    public QuestionnaireController(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

    @GetMapping(path = "{questionnaireId}")
    public Optional<Questionnaire> getQuestionnaire(@PathVariable("questionnaireId") UUID id) throws EntityNotFoundException {
        Optional<Questionnaire> questionnaire = questionnaireDAO.getQuestionnaireById(id);
        if (questionnaire.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return questionnaire;
    }

}
