package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spineapp.backend.models.AccountType;

@Component
public class AccountTypeDao {
    @Autowired private AccountTypeRepository accountTypeRepository;

    public void addAccountType(AccountType accountType) {
        accountTypeRepository.save(accountType);
    }
}
