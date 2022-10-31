package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.AccountType;

import java.util.List;

@Component
public class AccountTypeDAO {

    @Autowired
    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeDAO(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public void createAccountType(AccountType accountType) {
        accountTypeRepository.save(accountType);
    }

    public List<AccountType> getAccountTypes() {
    }
}
