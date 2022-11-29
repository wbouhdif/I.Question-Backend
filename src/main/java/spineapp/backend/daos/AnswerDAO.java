package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Answer;

import java.util.List;
import java.util.UUID;

@Component
public class AnswerDAO {

    private final AnswerRepository answerRepository;

    /**
     * Constructs instance of AnswerDAO with the answerRepository via dependency injection.
     * @param answerRepository Parameter of type AnswerRepository to be injected into.
     */
    @Autowired
    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    /**
     * Creates entry in the answer table in the database
     * @param answer Answer to be posted.
     */
    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    /**
     * Finds all answers in database with given answered questionnaire.
     * @param answeredQuestionnaire Answered questionnaire to be looked for.
     * @return
     * Returns list of all answers with given answered questionnaire.
     */
    public List<Answer> getAnswersByAnsweredQuestionnaire(UUID answeredQuestionnaire) {
        return answerRepository.findAllByAnsweredQuestionnaire(answeredQuestionnaire);
    }

    /**
     * Finds all answers in database with given employed question.
     * @param employedQuestion Employed question to be looked for.
     * @return
     * Returns list of answers with given employed question.
     */
    public List<Answer> getAnswersByEmployedQuestion(UUID employedQuestion) {
        return answerRepository.findAllByEmployedQuestion(employedQuestion);
    }

}
