package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.Answer;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UUID> {

    /**
     * Finds all answers in database with given answered questionnaire.
     * @param answeredQuestionnaireId ID of answered questionnaire to be looked for.
     * @return
     * Returns list of all answers with given answered questionnaire that were found.
     */
    @Query("SELECT a FROM Answer a WHERE a.answeredQuestionnaire.id = ?1")
    List<Answer> findAllByAnsweredQuestionnaire(UUID answeredQuestionnaireId);

    /**
     * Finds all answers in database with given employed question.
     * @param employedQuestionId ID of employed question to be looked for.
     * @return
     * Returns list of all answers with given employed question that were found.
     */
    @Query("SELECT a FROM Answer a WHERE a.employedQuestion.id = ?1")
    List<Answer> findAllByEmployedQuestion(UUID employedQuestionId);
}

