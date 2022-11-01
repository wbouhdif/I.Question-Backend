package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.Option;

import java.util.UUID;

@Repository
public interface OptionRepository extends JpaRepository<Option, UUID> {

}
