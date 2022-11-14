package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AnswerDAO;
import spineapp.backend.models.Answer;

@RestController
@RequestMapping(path = "api/answer")
public class AnswerController {

    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerController(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    @PostMapping
    public void createAnswer(@RequestBody Answer answer) {
        answerDAO.createAnswer(answer);
    }


}
