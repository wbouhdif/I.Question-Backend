package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.Answer;
import spineapp.backend.models.AnsweredQuestionnaire;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnsweredQuestionnaireRepository extends JpaRepository<AnsweredQuestionnaire, UUID> {
    @Query("SELECT a FROM AnsweredQuestionnaire a WHERE a.questionnaire.id = ?1")
    List<AnsweredQuestionnaire> getAnsweredQuestionnairesByQuestionnaire(UUID questionnaireId);
}
