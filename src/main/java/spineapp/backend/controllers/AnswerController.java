package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AnswerDAO;
import spineapp.backend.daos.AnsweredQuestionnaireDAO;
import spineapp.backend.daos.EmployedQuestionDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Answer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/answer")
public class AnswerController {

    private final AnswerDAO answerDAO;
    private final AnsweredQuestionnaireDAO answeredQuestionnaireDAO;
    private final EmployedQuestionDAO employedQuestionDAO;

    @Autowired
    public AnswerController(AnswerDAO answerDAO, AnsweredQuestionnaireDAO answeredQuestionnaireDAO, EmployedQuestionDAO employedQuestionDAO) {
        this.answerDAO = answerDAO;
        this.answeredQuestionnaireDAO = answeredQuestionnaireDAO;
        this.employedQuestionDAO = employedQuestionDAO;
    }

    @PostMapping
    public void createAnswer(@RequestBody Answer answer) {
        answerDAO.createAnswer(answer);
    }

    @GetMapping(path = "answered_questionnaire={answered_questionnaire}")
    public List<Answer> getAnswersByAnsweredQuestionnaire(@PathVariable("answered_questionnaire") UUID answeredQuestionnaire) throws EntityNotFoundException {
        if (!answeredQuestionnaireDAO.existsById(answeredQuestionnaire)) {
            throw new EntityNotFoundException(answeredQuestionnaire);
        }
        return answerDAO.getAnswersByAnsweredQuestionnaire(answeredQuestionnaire);
    }

    @GetMapping(path = "employed_question={employed_question}")
    public List<Answer> getAnswersByEmployedQuestion(@PathVariable("employed_question") UUID employedQuestion) throws EntityNotFoundException {
        if (!employedQuestionDAO.existsById(employedQuestion)) {
            throw new EntityNotFoundException(employedQuestion);
        }
        return answerDAO.getAnswersByEmployedQuestion(employedQuestion);
    }


}
