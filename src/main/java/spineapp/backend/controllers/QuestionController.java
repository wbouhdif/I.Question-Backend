package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.QuestionDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.exceptions.QuestionExistsByIdException;
import spineapp.backend.exceptions.QuestionExistsByTextException;
import spineapp.backend.models.Question;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/question")
public class QuestionController {

    private final QuestionDAO questionDAO;

    public List<Question> getQuestions(){
        return questionDAO.getQuestions();
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewQuestion(@RequestBody Question question) throws QuestionExistsByIdException, QuestionExistsByTextException {

        if (questionDAO.existsById(question.getId())) {
            throw new QuestionExistsByIdException();
        }

        if (questionDAO.existsByText(question.getText())){
            throw new QuestionExistsByTextException();
        }


        questionDAO.createQuestion(question);
    }

    @Autowired
    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @GetMapping(path = "{questionId}")
    public Optional<Question> getQuestion(@PathVariable("questionId") UUID id) throws EntityNotFoundException {
        Optional<Question> question = questionDAO.getQuestionById(id);
        if (question.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return question;
    }

    @PostMapping
    public void createQuestion(@RequestBody Question question) {
        questionDAO.createQuestion(question);
    }

}
