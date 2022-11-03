package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AccountDAO;
import spineapp.backend.models.Account;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {
    private final AccountDAO accountDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountController(AccountDAO accountDAO, PasswordEncoder passwordEncoder) {
        this.accountDAO = accountDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }



    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") UUID id) {
        accountDAO.deleteAccount(id);
    }

}
