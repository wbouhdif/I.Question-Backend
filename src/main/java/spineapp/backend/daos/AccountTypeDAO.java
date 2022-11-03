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
        return accountTypeRepository.findById(id);
    }

    public void deleteAccountType(UUID id) {
        accountTypeRepository.deleteById(id);
    }

    public boolean existsById(UUID id) {
        return accountTypeRepository.existsById(id);
    }

}
