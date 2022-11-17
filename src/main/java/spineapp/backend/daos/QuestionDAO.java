package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Question;

import javax.transaction.Transactional;
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

    @Transactional
    public UUID createQuestion(Question question){
        questionRepository.save(question);
        return question.getId();
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

   public boolean existsByText(String text) {return questionRepository.findQuestionByText(text).isPresent();}
}
