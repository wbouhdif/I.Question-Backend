package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.AccountType;

@Component
public class AccountTypeDAO {

    @Autowired
    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeDAO(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public void registerAccountType(AccountType accountType) {
        accountTypeRepository.save(accountType);
    }
}
