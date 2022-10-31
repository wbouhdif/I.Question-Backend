package spineApp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineApp.backend.models.AccountType;

import java.util.List;

@Component
public class AccountTypeDAO {

    @Autowired
    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeDAO(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public AccountType createAccountType(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }

    public List<AccountType> getAccountTypes() {
        return accountTypeRepository.findAll();
    }
}
