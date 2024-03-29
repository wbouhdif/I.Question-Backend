package spineapp.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spineapp.backend.models.Account;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    /**
     * Finds account in database with given email.
     * @param email Email to be looked for.
     * @return
     * Returns an account with given email.
     */
    @Query("SELECT a FROM Account a WHERE a.email = ?1")
    Optional<Account> findAccountByEmail(String email);

    /**
     * Sets password of account with given ID to given password.
     * @param password Value to set password to.
     * @param id ID of account to be altered.
     */
    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.password = ?1 WHERE a.id = ?2")
    void updatePassword(String password, UUID id);

}
