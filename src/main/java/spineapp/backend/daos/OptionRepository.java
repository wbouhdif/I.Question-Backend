package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.Option;

import java.util.List;
import java.util.UUID;

@Repository
public interface OptionRepository extends JpaRepository<Option, UUID> {
    @Query("SELECT a FROM Option a WHERE a.question.id = ?1")
    List<Option> findAllByQuestion(UUID questionId);

}
