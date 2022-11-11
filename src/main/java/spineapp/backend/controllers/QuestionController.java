package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.QuestionDAO;
import spineapp.backend.models.Question;

import java.util.List;

@RestController
@RequestMapping(path = "api/question")
public class QuestionController {

    private final QuestionDAO questionDAO;

    public List<Question> getQuestions(){
        return questionDAO.getQuestions();
    }

//    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void createNewQuestion(@RequestMapping Question question){
//
//    }

    @Autowired
    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

}
