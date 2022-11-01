package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AnswerDAO;

@RestController
@RequestMapping(path = "api/answer")
public class AnswerController {

    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerController(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

}
