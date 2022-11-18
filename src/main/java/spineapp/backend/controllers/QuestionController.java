package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.QuestionDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Question;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/question")
public class QuestionController {

    private final QuestionDAO questionDAO;


    @Autowired
    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @PostMapping
    public UUID createQuestion(@RequestBody Question question) throws EntityNotFoundException{
        if (questionDAO.existsByText(question.getText())){
            throw new EntityNotFoundException(question.getId());
        }
        return questionDAO.createQuestion(question);
    }

    @GetMapping(path = "{questionId}")
    public Optional<Question> getQuestion(@PathVariable("questionId") UUID id) throws EntityNotFoundException {
        Optional<Question> question = questionDAO.getQuestionById(id);
        if (question.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return question;
    }

    @GetMapping
    public List<Question> getQuestions(){
        return questionDAO.getQuestions();
    }

}
