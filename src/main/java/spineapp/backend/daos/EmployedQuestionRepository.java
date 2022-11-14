package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.EmployedQuestion;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployedQuestionRepository extends JpaRepository<EmployedQuestion, UUID> {
    @Query("SELECT a FROM EmployedQuestion a WHERE a.questionnaire.id = ?1")
    List<EmployedQuestion> findAllByQuestionnaire(UUID questionnaireId);
}
