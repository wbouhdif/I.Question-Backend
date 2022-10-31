package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.daos.AccountDAO;
import spineapp.backend.models.Account;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

    @PostMapping
    public void registerNewAccount(@RequestBody Account account) {
        accountDAO.registerNewAccount(account);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") UUID id) {
        accountDAO.deleteAccount(id);
    }

}
