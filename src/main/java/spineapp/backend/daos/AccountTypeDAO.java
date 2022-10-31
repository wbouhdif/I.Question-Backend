package spineApp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineApp.backend.daos.AccountTypeRepository;
import spineApp.backend.models.AccountType;

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
