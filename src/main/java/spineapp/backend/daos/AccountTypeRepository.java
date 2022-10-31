package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spineapp.backend.models.Account;
import spineapp.backend.models.AccountType;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, UUID> {
    Optional<Account> findByName(String name);
}
