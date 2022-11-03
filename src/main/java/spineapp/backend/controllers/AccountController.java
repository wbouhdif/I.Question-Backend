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
import java.util.UUID;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {
    private final AccountDAO accountDAO;
    private final AccountTypeDAO accountTypeDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountController(AccountDAO accountDAO, AccountTypeDAO accountTypeDAO, PasswordEncoder passwordEncoder) {
        this.accountDAO = accountDAO;
        this.accountTypeDAO = accountTypeDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(path = "/accounts")
    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

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

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") UUID id) throws EntityNotFoundException {
        if (!accountDAO.existsById(id)) {
            throw new EntityNotFoundException(id);
        }

        accountDAO.deleteAccount(id);
    }

}
