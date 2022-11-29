package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.AccountType;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, UUID> {

    /**
     * Finds account type in database with given name.
     * @param name Name to be looked for.
     * @return
     * Returns account type with given name.
     */
    Optional<AccountType> findByName(String name);
}
