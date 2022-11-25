package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Answer;

import java.util.List;
import java.util.UUID;

@Component
public class AnswerDAO {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public List<Answer> getAnswersByAnsweredQuestionnaire(UUID answeredQuestionnaire) {
        return answerRepository.findAllByAnsweredQuestionnaire(answeredQuestionnaire);
    }
    public List<Answer> getAnswersByEmployedQuestion(UUID employedQuestion) {
        return answerRepository.findAllByEmployedQuestion(employedQuestion);
    }


}
