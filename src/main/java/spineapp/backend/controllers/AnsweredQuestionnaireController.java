package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AnsweredQuestionnaireDAO;
import spineapp.backend.models.AnsweredQuestionnaire;

import java.util.List;

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

}
