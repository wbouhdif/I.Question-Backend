package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.EmployedQuestionDAO;
import spineapp.backend.daos.QuestionnaireDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.EmployedQuestion;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/employed_question")
public class EmployedQuestionController {

    private final EmployedQuestionDAO employedQuestionDAO;
    private final QuestionnaireDAO questionnaireDAO;

    @Autowired
    public EmployedQuestionController(EmployedQuestionDAO employedQuestionDAO, QuestionnaireDAO questionnaireDAO) {
        this.employedQuestionDAO = employedQuestionDAO;
        this.questionnaireDAO = questionnaireDAO;
    }

    @PostMapping
    public void createEmployedQuestion(@RequestBody EmployedQuestion employedQuestion) {
        employedQuestionDAO.createEmployedQuestion(employedQuestion);
    }

    @GetMapping(path = "questionnaire={questionnaire}")
    public List<EmployedQuestion> getEmployedQuestionsByQuestionnaire(@PathVariable("questionnaire") UUID questionnaire) throws EntityNotFoundException {
        if (!questionnaireDAO.existsById(questionnaire)) {
            throw new EntityNotFoundException(questionnaire);
        }
        return employedQuestionDAO.getEmployedQuestionsByQuestionnaire(questionnaire);
    }

}
