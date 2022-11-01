package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AnsweredQuestionnaireDAO;

@RestController
@RequestMapping(path = "api/answered_questionnaire")
public class AnsweredQuestionnaireController {

    private final AnsweredQuestionnaireDAO answeredQuestionnaireDAO;

    @Autowired
    public AnsweredQuestionnaireController(AnsweredQuestionnaireDAO answeredQuestionnaireDAO) {
        this.answeredQuestionnaireDAO = answeredQuestionnaireDAO;
    }

}
