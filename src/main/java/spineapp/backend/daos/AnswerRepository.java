package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.Answer;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    @Query("SELECT a FROM Answer a WHERE a.answeredQuestionnaire.id = ?1")
    List<Answer> findAllByAnsweredQuestionnaire(UUID answeredQuestionnaireId);
    @Query("SELECT a FROM Answer a WHERE a.employedQuestion.id = ?1")
    List<Answer> findAllByEmployedQuestion(UUID employedQuestionId);
}

