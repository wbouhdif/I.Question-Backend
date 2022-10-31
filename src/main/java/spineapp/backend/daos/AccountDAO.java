package spineapp.backend.daos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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
        Optional<Account> accountByEmail = accountRepository.findAccountByEmail(account.getEmail());
        if (accountByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        accountRepository.save(account);
    }
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }


    public void deleteAccount(UUID id) {
        boolean exists = accountRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Account with id " + id + " does not exist");
        }
        accountRepository.deleteById(id);
    }
}
