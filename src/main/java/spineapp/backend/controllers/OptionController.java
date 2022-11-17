package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.OptionDAO;
import spineapp.backend.daos.QuestionDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.exceptions.OptionNotFoundByIdException;
import spineapp.backend.exceptions.OptionNotFoundByTextException;
import spineapp.backend.models.Option;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/option")
public class OptionController {

    private final OptionDAO optionDAO;
    private final QuestionDAO questionDAO;

    @Autowired
    public OptionController(OptionDAO optionDAO, QuestionDAO questionDAO) {
        this.optionDAO = optionDAO;
        this.questionDAO = questionDAO;
    }
    

    @PostMapping
    public void createNewOption(@RequestBody Option option) throws EntityNotFoundException {

        if (optionDAO.getOptionByText(option.getText()).isPresent()){
            throw new EntityNotFoundException(option.getText());
        }
        optionDAO.createOption(option);

    }

    @GetMapping(path = "question={question}")
    public List<Option> getOptionsByQuestion(@PathVariable("question") UUID question) throws EntityNotFoundException {
        if (!questionDAO.existsById(question)) {
            throw new EntityNotFoundException(question);
        }
        return optionDAO.getOptionsByQuestion(question);
    }

}
