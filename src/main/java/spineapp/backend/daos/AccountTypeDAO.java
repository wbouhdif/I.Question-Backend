package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.AccountType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AccountTypeDAO {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeDAO(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public void createAccountType(AccountType accountType) {
        accountTypeRepository.save(accountType);
    }

    public List<AccountType> getAccountTypes() {
        return accountTypeRepository.findAll();
    }

    public Optional<AccountType> getAccountTypeById(UUID id) {
        boolean exists = accountTypeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Account type with id " + id + " does not exist");
        }
        return accountTypeRepository.findById(id);
    }

    public void deleteAccountType(UUID id) {
        boolean exists = accountTypeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Account type with id " + id + " does not exist");
        }
        accountTypeRepository.deleteById(id);
    }

    public boolean existsById(UUID id) {
        return accountTypeRepository.existsById(id);
    }

}
