package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.EmployedQuestion;

import java.util.UUID;

@Repository
public interface EmployedQuestionRepository extends JpaRepository<EmployedQuestion, UUID> {

}
