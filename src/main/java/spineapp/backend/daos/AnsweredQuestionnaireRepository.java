package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.AnsweredQuestionnaire;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnsweredQuestionnaireRepository extends JpaRepository<AnsweredQuestionnaire, UUID> {

    /**
     * Finds all answered questionnaires with given questionnaire.
     * @param questionnaireId ID of questionnaire to be looked for.
     * @return
     * Returns list of all answered questionnaires with given questionnaire that were found.
     */
    @Query("SELECT a FROM AnsweredQuestionnaire a WHERE a.questionnaire.id = ?1")
    List<AnsweredQuestionnaire> getAnsweredQuestionnairesByQuestionnaire(UUID questionnaireId);

    @Query("SELECT a FROM AnsweredQuestionnaire a WHERE a.caregiver.id = ?1")
    List<AnsweredQuestionnaire> getAnsweredQuestionnairesByAccount(UUID accountId);
}
