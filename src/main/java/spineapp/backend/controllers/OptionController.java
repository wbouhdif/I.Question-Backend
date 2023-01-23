package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.OptionDAO;
import spineapp.backend.daos.QuestionDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Option;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/option")
public class OptionController {

    private final OptionDAO optionDAO;
    private final QuestionDAO questionDAO;

    /**
     * Constructs instance of OptionController with the optionDAO and questionDAO via dependency injection.
     * @param optionDAO Parameter of type OptionDAO to be injected into.
     * @param questionDAO Parameter of type QuestionDAO to be injected into.
     */
    @Autowired
    public OptionController(OptionDAO optionDAO, QuestionDAO questionDAO) {
        this.optionDAO = optionDAO;
        this.questionDAO = questionDAO;
    }

    /**
     * Creates new entry in option table in the database.
     * @param option Object of type Option to be posted.
     */
    @PostMapping
    public void createNewOption(@RequestBody Option option) {
        optionDAO.createOption(option);
    }

    /**
     * Finds all options in database with given question.
     * @param question ID of question to be looked for.
     * @return
     * Returns all options in database with given question.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given ID could not be found.
     */
    @GetMapping(path = "question={question}")
    public List<Option> getOptionsByQuestion(@PathVariable("question") UUID question) throws EntityNotFoundException {
        if (!questionDAO.existsById(question)) {
            throw new EntityNotFoundException(question);
        }
        return optionDAO.getOptionsByQuestion(question);
    }

    @DeleteMapping(path = "{optionId}")
    public void deleteOption(@PathVariable("optionId") UUID id) throws EntityNotFoundException {
        if (!optionDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        optionDAO.deleteOption(id);
    }

}
