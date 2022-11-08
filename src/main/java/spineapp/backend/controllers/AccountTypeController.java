package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AccountTypeDAO;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Account;
import spineapp.backend.models.AccountType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/account_type")
public class AccountTypeController {

    private final AccountTypeDAO accountTypeDAO;

    /**
     * Constructor to create a new Account Type Controller for a given DAO
     * @param accountTypeDAO A DAO of Account Type
     */
    @Autowired
    AccountTypeController(AccountTypeDAO accountTypeDAO) {
        this.accountTypeDAO = accountTypeDAO;
    }

    /**
     * Gathers a list of all the account types using the Account Type DAO's getAccountTypes() function.
     * @return
     * returns a list of Account Types.
     */
    @GetMapping
    public List<AccountType> getAccountTypes() {
        return accountTypeDAO.getAccountTypes();
    }

    /**
     * returns the specific Account Type belonging to the ID given as parameter
     * @param id ID of an Account Type
     * @throws EntityNotFoundException
     * Will throw exception if entity with given id could not be found.
     * @return
     * returns the Account Type belonging to the given ID
     */
    @GetMapping (path = "{account_typeId}")
    public Optional<AccountType> getAccountType(@PathVariable("account_typeId") UUID id) throws EntityNotFoundException {
        Optional<AccountType> accountType = accountTypeDAO.getAccountTypeById(id);
        if (accountType.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return accountType;
    }

    /**
     * Create a new Account Type
     * @param accountType An account type given as a parameter for creating a new Account Type
     */
    @PostMapping
    public void createAccountType(@RequestBody AccountType accountType) {
        accountTypeDAO.createAccountType(accountType);
    }

    /**
     * Will attempt to delete the Account Type belonging to the given ID.
     * @param id ID belonging to an Account Type
     * @throws EntityNotFoundException
     * Will throw an expection if the Account Type belonging to the given ID does not exist.
     */
    @DeleteMapping(path = "{account_typeId}")
    public void deleteAccountType(@PathVariable("account_typeId") UUID id) throws EntityNotFoundException {
        if (!accountTypeDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        accountTypeDAO.deleteAccountType(id);
    }
}
