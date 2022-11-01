package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.AnsweredQuestionnaire;

import java.util.UUID;

@Repository
public interface AnsweredQuestionnaireRepository extends JpaRepository<AnsweredQuestionnaire, UUID> {

}
