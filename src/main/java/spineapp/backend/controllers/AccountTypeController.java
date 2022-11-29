package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AccountTypeDAO;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.AccountType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/account_type")
public class AccountTypeController {

    private final AccountTypeDAO accountTypeDAO;

    /**
     * Constructs instance of AccountTypeController with the accountTypeDAO via dependency injection.
     * @param accountTypeDAO Parameter of type AccountTypeDAO to be injected into.
     */
    @Autowired
    AccountTypeController(AccountTypeDAO accountTypeDAO) {
        this.accountTypeDAO = accountTypeDAO;
    }

    /**
     * Gathers a list of all the account types using the Account Type DAO's getAccountTypes() function.
     * @return
     * Returns a list of Account Types.
     */
    @GetMapping
    public List<AccountType> getAccountTypes() {
        return accountTypeDAO.getAccountTypes();
    }

    /**
     * Returns the specific Account Type belonging to the ID given as parameter
     * @param id ID of an Account Type
     * @throws EntityNotFoundException
     * Will throw exception if entity with given id could not be found.
     * @return
     * Returns the Account Type belonging to the given ID.
     */
    @GetMapping (path = "id={account_typeId}")
    public Optional<AccountType> getAccountType(@PathVariable("account_typeId") UUID id) throws EntityNotFoundException {
        Optional<AccountType> accountType = accountTypeDAO.getAccountTypeById(id);
        if (accountType.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return accountType;
    }

    /**
     * Finds account types in database with given name.
     * @param name Name of account-type to be looked for.
     * @return
     * Returns all account-types with given name.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given name could not be found.
     */
    @GetMapping (path = "name={account_typeName}")
    public Optional<AccountType> getAccountTypeByName(@PathVariable("account_typeName") String name) throws EntityNotFoundException {
        Optional<AccountType> accountType = accountTypeDAO.getAccountTypeByName(name);
        if (accountType.isEmpty()) {
            throw new EntityNotFoundException(name);
        }
        return accountType;
    }

    /**
     * Create a new Account Type.
     * @param accountType An account type given as a parameter for creating a new Account Type.
     */
    @PostMapping
    public void createAccountType(@RequestBody AccountType accountType) {
        accountTypeDAO.createAccountType(accountType);
    }

    /**
     * Will attempt to delete the Account Type belonging to the given ID.
     * @param id ID belonging to an account-type.
     * @throws EntityNotFoundException
     * Will throw an exception if the account-type belonging to the given ID does not exist.
     */
    @DeleteMapping(path = "{account_typeId}")
    public void deleteAccountType(@PathVariable("account_typeId") UUID id) throws EntityNotFoundException {
        if (!accountTypeDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        accountTypeDAO.deleteAccountType(id);
    }
}
