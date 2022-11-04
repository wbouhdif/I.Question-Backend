package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AccountDAO;
import spineapp.backend.daos.AccountTypeDAO;
import spineapp.backend.exceptions.EmailInvalidException;
import spineapp.backend.exceptions.EmailTakenException;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Account;
import spineapp.backend.services.EmailValidationService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {
    private final AccountDAO accountDAO;
    private final AccountTypeDAO accountTypeDAO;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructs an account controller for the given DAO's and password encoder
     * @param accountDAO DAO object of account
     * @param accountTypeDAO DAO object of the account type
     * @param passwordEncoder Encoder for the account's password
     */
    @Autowired
    public AccountController(AccountDAO accountDAO, AccountTypeDAO accountTypeDAO, PasswordEncoder passwordEncoder) {
        this.accountDAO = accountDAO;
        this.accountTypeDAO = accountTypeDAO;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Gathers a list of all accounts found in the account DAO using the account DAO's getAccounts() function.
     * @return
     * returns an arraylist of type Account.
     */
    @GetMapping
    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

    /**
     * Finds a specific account linked to the given ID parameter
     * @param id ID belonging to an account
     * @return
     * returns the account which corresponds with the given ID parameter
     */
    @GetMapping (path = "{accountId}")
    public Optional<Account> getAccount(@PathVariable("accountId") UUID id) {
        return accountDAO.getAccountById(id);
    }

    /**
     * Registers a new account for a user
     * @param account a new account instance to register the new account on
     * @throws EmailTakenException
     * Will throw an exception in case the email address used to register the new user is already in the database.
     * @throws EntityNotFoundException
     * Will throw an exception if the account on the given ID does not exist
     * @throws EmailInvalidException
     * Will throw an exception if the email address used to register the new user is not a valid email address (e.g. bad formatting or no domain given)
     */
    @PostMapping(path = "/register")
    public void registerNewAccount(@RequestBody Account account) throws EmailTakenException, EntityNotFoundException, EmailInvalidException {

        EmailValidationService.validateEmailAddress(account.getEmail());

        if (accountDAO.findAccountByEmail(account.getEmail()).isPresent()) {
            throw new EmailTakenException();
        }

        if (!accountTypeDAO.existsById(account.getType().getId())) {
            throw new EntityNotFoundException(account.getType().getId());
        }

        String encodedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassword);

        accountDAO.registerNewAccount(account);
    }

    /**
     * Used to delete an existing account from the database
     * @param id an ID belonging to an Account
     * @throws EntityNotFoundException
     * Will throw an exception if the account belonging to the given ID parameter does not exist
     */
    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") UUID id) throws EntityNotFoundException {
        if (!accountDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }

        accountDAO.deleteAccount(id);
    }

}
