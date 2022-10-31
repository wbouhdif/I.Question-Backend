package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AccountTypeDAO;
import org.springframework.web.bind.annotation.*;
import spineapp.backend.models.AccountType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/account_type")
public class AccountTypeController {

    private final AccountTypeDAO accountTypeDAO;

    @Autowired
    AccountTypeController(AccountTypeDAO accountTypeDAO) {
        this.accountTypeDAO = accountTypeDAO;
    }

    @GetMapping
    public List<AccountType> getAccountTypes() {
        return accountTypeDAO.getAccountTypes();
    }

    @GetMapping (path = "{account_typeId}")
    public Optional<AccountType> getAccountType(@PathVariable("account_typeId") UUID id) {
        return accountTypeDAO.getAccountTypeById(id);
    }

    @PostMapping
    public void createAccountType(@RequestBody AccountType accountType) {
        accountTypeDAO.createAccountType(accountType);
    }

    @DeleteMapping(path = "{account_typeId}")
    public void deleteAccountType(@PathVariable("account_typeId") UUID id) {
        accountTypeDAO.deleteAccountType(id);
    }
}
