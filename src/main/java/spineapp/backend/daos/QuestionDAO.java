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

    /**
     * Constructs instance of QuestionDAO with the questionRepository via dependency injection.
     * @param questionRepository Parameter of type QuestionRepository to be injected into.
     */
    @Autowired
    public QuestionDAO(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * Creates entry in table question in database.
     * @param question Question to be posted.
     * @return
     * Returns generated UUID of posted question.
     */
    @Transactional
    public UUID createQuestion(Question question){
        questionRepository.save(question);
        return question.getId();
    }

    /**
     * Finds all questions in database.
     * @return
     * Returns list of all questions that were found.
     */
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    /**
     * Finds question in database with given ID.
     * @param id ID to be looked for.
     * @return
     * Returns question with given ID.
     */
    public Optional<Question> getQuestionById(UUID id){
        return questionRepository.findById(id);
    }

    /**
     * Checks whether question with given ID exists in database.
     * @param id ID to be checked.
     * @return
     * Returns true or false depending on result of existsById().
     */
    public boolean existsById(UUID id){
        return questionRepository.existsById(id);
    }

}
