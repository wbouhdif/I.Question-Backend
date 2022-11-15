package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AnswerDAO;
import spineapp.backend.daos.AnsweredQuestionnaireDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Answer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/answer")
public class AnswerController {

    private final AnswerDAO answerDAO;
    private final AnsweredQuestionnaireDAO answeredQuestionnaireDAO;

    @Autowired
    public AnswerController(AnswerDAO answerDAO, AnsweredQuestionnaireDAO answeredQuestionnaireDAO) {
        this.answerDAO = answerDAO;
        this.answeredQuestionnaireDAO = answeredQuestionnaireDAO;
    }

    @PostMapping
    public void createAnswer(@RequestBody Answer answer) {
        answerDAO.createAnswer(answer);
    }

    @GetMapping(path = "answeredQuestionnaire={answeredQuestionnaire}")
    public List<Answer> getAnswersByAnsweredQuestionnaire(@PathVariable("answeredQuestionnaire") UUID answeredQuestionnaire) throws EntityNotFoundException {
        if (!answeredQuestionnaireDAO.existsById(answeredQuestionnaire)) {
            throw new EntityNotFoundException(answeredQuestionnaire);
        }
        return answerDAO.getAnswersByAnsweredQuestionnaire(answeredQuestionnaire);
    }


}
