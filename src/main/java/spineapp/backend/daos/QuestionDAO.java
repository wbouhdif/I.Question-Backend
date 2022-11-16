package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Question;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class QuestionDAO {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionDAO(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestion(Question question){
        questionRepository.save(question);
    }

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(UUID id){
        return questionRepository.findById(id);
    }

    public void deleteQuestion(UUID id){
        questionRepository.deleteById(id);
    }

    public boolean existsById(UUID id){
        return questionRepository.existsById(id);
    }

    //add "exists by question text" method + add to controller and to repository
}
