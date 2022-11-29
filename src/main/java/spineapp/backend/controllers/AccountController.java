package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AccountDAO;
import spineapp.backend.daos.AccountTypeDAO;
import spineapp.backend.exceptions.EmailTakenException;
import spineapp.backend.exceptions.EntityNotFoundException;
import spineapp.backend.models.Account;
import spineapp.backend.services.GeneratePassword;
import spineapp.backend.services.SendEmailService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/account", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
    private final AccountDAO accountDAO;
    private final AccountTypeDAO accountTypeDAO;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructs instance of AccountController with the accountDAO, accountTypeDAO and passwordEncoder via dependency injection.
     * @param accountDAO Parameter of type AccountDAO to be injected into.
     * @param accountTypeDAO Parameter of type AccountTypeDAO to be injected into.
     * @param passwordEncoder Parameter of type PasswordEncoder to be injected into.
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
     * Returns an arraylist of type Account.
     */
    @GetMapping
    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

    /**
     * Finds a specific account linked to the given ID parameter.
     * @param id ID belonging to an account.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given id could not be found.
     * @return
     * Returns the account which corresponds with the given ID parameter.
     */
    @GetMapping (path = "{accountId}")
    public Optional<Account> getAccount(@PathVariable("accountId") UUID id) throws EntityNotFoundException {
        Optional<Account> account = accountDAO.getAccountById(id);
        if (account.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return account;
    }

    /**
     * Finds a specific account linked to the given email parameter.
     * @param email Email belonging to an account.
     * @return
     * Returns the account which corresponds with the given email parameter.
     * @throws EntityNotFoundException
     * Will throw exception if entity with given id could not be found.
     */
    @GetMapping (path = "email={email}")
    public Optional<Account> getAccountByEmail(@PathVariable("email") String email) throws EntityNotFoundException {
        Optional<Account> account = accountDAO.findAccountByEmail(email);
        if (account.isEmpty()) {
            throw new EntityNotFoundException(email);
        }
        return account;
    }

    /**
     * Registers a new account for a user.
     * @param account a new account instance to register the new account on.
     * @throws EmailTakenException
     * Will throw an exception in case the email address used to register the new user is already in the database.
     * @throws EntityNotFoundException
     * Will throw an exception if the account-type of the given ID does not exist.
     */
    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerNewAccount(@RequestBody Account account) throws EmailTakenException, EntityNotFoundException {

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
     * Sets the authorised attribute of account with given id to value of payload.
     * @param id ID of account to be altered.
     * @param authorised boolean which the authorised attribute of the account with given id will be set to.
     * @throws EntityNotFoundException
     * Will throw an exception if the account with given ID does not exist.
     */
    @PutMapping(path = "{accountId}/authorised")
    public void setAuthorised(@PathVariable("accountId") UUID id, @RequestBody boolean authorised) throws EntityNotFoundException {
        if (!accountDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }

        accountDAO.setAuthorised(id, authorised);
    }

    /**
     * Used to delete an existing account from the database.
     * @param id an ID belonging to an Account.
     * @throws EntityNotFoundException
     * Will throw an exception if the account belonging to the given ID parameter does not exist.
     */
    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") UUID id) throws EntityNotFoundException {
        if (!accountDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        accountDAO.deleteAccount(id);
    }

    /**
     * Sets password of account with given id to a randomly generated password.
     * @param id ID of account to be altered.
     * @param email Email where the new password is to be sent to.
     */
    @PutMapping(path = "/newpassword/{accountId}")
    public void newPassword (@PathVariable("accountId") UUID id, @RequestBody String email) {
        String password = GeneratePassword.getInstance().generateNewPassword();
        String encodedPassword = passwordEncoder.encode(password);
        accountDAO.updatePassword(id, encodedPassword);
        SendEmailService.getInstance().SendNewPassword(email, password);
    }
}
