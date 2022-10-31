package spineApp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spineApp.backend.models.Account;
import spineApp.backend.models.AccountType;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, UUID> {
    Optional<Account> findByName(String name);
}
