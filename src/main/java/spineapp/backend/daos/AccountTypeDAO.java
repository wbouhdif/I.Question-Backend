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

    /**
     * Constructs instance of AccountDAO with the accountTypeRepository via dependency injection.
     * @param accountTypeRepository Parameter of type AccountRepository to be injected into.
     */
    @Autowired
    public AccountTypeDAO(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    /**
     * Creates a new account Type within the Account type repository.
     * @param accountType Instance of Account Type.
     */
    public void createAccountType(AccountType accountType) {
        accountTypeRepository.save(accountType);
    }

    /**
     * Finds all account types within the account type repository.
     * @return
     * Returns list of Type AccountType.
     */
    public List<AccountType> getAccountTypes() {
        return accountTypeRepository.findAll();
    }

    /**
     * Finds the account type for a given Account Type ID.
     * @param id ID belonging to an account type.
     * @return
     * Returns the account type belonging to the given ID.
     */
    public Optional<AccountType> getAccountTypeById(UUID id) {
        return accountTypeRepository.findById(id);
    }

    /**
     * Deletes an Account Type from the account type repository.
     * @param id ID belonging to an account type.
     */
    public void deleteAccountType(UUID id) {
        accountTypeRepository.deleteById(id);
    }

    /**
     * Finds whether an account exists within the repository.
     * @param id ID belonging to an account type.
     * @return
     * returns the Account type for the given account type ID.
     */
    public boolean existsById(UUID id) {
        return accountTypeRepository.existsById(id);
    }

    /**
     * Finds account type in repository with given name.
     * @param name Name to be looked for.
     * @return
     * Returns account type with given name.
     */
    public Optional<AccountType> getAccountTypeByName(String name) {
        return accountTypeRepository.findByName(name);
    }

}
