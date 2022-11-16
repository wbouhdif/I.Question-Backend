package spineapp.backend.daos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Account;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AccountDAO {
    private final AccountRepository accountRepository;

    /**
     * Constructs a new account DAO on a given Account Repository.
     * @param accountRepository instance of an Account repository.
     */
    @Autowired
    public AccountDAO(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Registers a given new Account in the account repository.
     * @param account instance of an account that is to be registered.
     */
    public void registerNewAccount(Account account) {
//        accountRepository.save(account);
        accountRepository.save(account);
    }

    /**
     * Gathers list of all accounts within account repository
     * @return
     * returns a List of the type Account containing all accounts found in the repository.
     */
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Finds single Account within account repository belonging to the provided ID
     * @param id ID belonging to an account
     * @return
     * returns the account object from the repository
     */
    public Optional<Account> getAccountById(UUID id) {
        return accountRepository.findById(id);
    }

    /**
     * Deletes the Account belonging to the provided ID from the account repository
     * @param id ID belonging to an Account
     */
    public void deleteAccount(UUID id) {
        accountRepository.deleteById(id);
    }

    /**
     * Finds single Account within account repository belonging to the provided email address
     * @param email an email address
     * @return
     * returns the account belonging to the given email address
     */
    public Optional<Account> findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    /**
     * Finds out whether an account belonging to the given ID exists within the account repository
     * @param id ID belonging to an account
     * @return
     * returns whether the account exists within the account repository
     */
    public boolean existsById(UUID id) {
        return accountRepository.existsById(id);
    }

    @Transactional
    public void setAuthorised(UUID accountId, boolean authorised) {
        Optional<Account> account = accountRepository.findById(accountId);
        account.get().setAuthorised(authorised);
    }

    public void updatePassword(UUID id, String encodedPassword) {
        Optional<Account> account = accountRepository.findById(id);
        account.get().setPassword(encodedPassword);
    }
}
