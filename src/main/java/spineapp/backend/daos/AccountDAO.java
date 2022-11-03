package spineapp.backend.daos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AccountDAO {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountDAO(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void registerNewAccount(Account account) {
        accountRepository.save(account);
    }
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }


    public void deleteAccount(UUID id) {
        accountRepository.deleteById(id);
    }

    public Optional<Account> findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    public boolean existsById(UUID id) {
        return accountRepository.existsById(id);
    }
}
