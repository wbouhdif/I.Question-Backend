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

    /**
     * Constructs instance of QuestionController with the questionDAO via dependency injection.
     * @param questionDAO Parameter of type QuestionDAO to be injected into.
     */
    @Autowired
    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    /**
     * Creates new entry in the question table in the database.
     * @param question Object of type question to be posted.
     * @return
     * Returns generated UUID of posted question.
     */
    @PostMapping
    public UUID createQuestion(@RequestBody Question question) {
        return questionDAO.createQuestion(question);
    }

    /**
     * Finds question in database with given id.
     * @param id ID of question to be looked for.
     * @return
     * Returns question with given id.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given ID could not be found.
     */
    @GetMapping(path = "{id}")
    public Optional<Question> getQuestion(@PathVariable("id") UUID id) throws EntityNotFoundException {
        Optional<Question> question = questionDAO.getQuestionById(id);
        if (question.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return question;
    }

    /**
     * Finds all questions in the database.
     * @return
     * Returns list of all questions that were found in the database.
     */
    @GetMapping
    public List<Question> getQuestions(){
        return questionDAO.getQuestions();
    }

    @DeleteMapping(path = "{id}")
    public void deleteQuestion(@PathVariable("id") UUID id) throws EntityNotFoundException {
        if (!questionDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        questionDAO.deleteQuestion(id);
    }

}
