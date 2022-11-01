package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.QuestionnaireDAO;

@RestController
@RequestMapping(path = "api/questionnaire")
public class QuestionnaireController {

    private final QuestionnaireDAO questionnaireDAO;

    @Autowired
    public QuestionnaireController(QuestionnaireDAO questionnaireDAO) {
        this.questionnaireDAO = questionnaireDAO;
    }

}
