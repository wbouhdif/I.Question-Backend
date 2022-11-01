package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.EmployedQuestionDAO;

@RestController
@RequestMapping(path = "api/employed_question")
public class EmployedQuestionController {

    private final EmployedQuestionDAO employedQuestionDAO;

    @Autowired
    public EmployedQuestionController(EmployedQuestionDAO employedQuestionDAO) {
        this.employedQuestionDAO = employedQuestionDAO;
    }

}
