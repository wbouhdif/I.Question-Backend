package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AccountTypeDAO;
import org.springframework.web.bind.annotation.*;
import spineApp.backend.daos.AccountTypeDAO;
import spineApp.backend.models.AccountType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountTypeController {

    @Autowired private AccountTypeDAO accountTypeDAO;

    @PostMapping
    public void createAccountType(@RequestBody AccountType accountType) {
        accountTypeDAO.createAccountType(accountType);
    }

    @RequestMapping(value="/account_type", method=RequestMethod.GET)
    public List<AccountType> readAccountTypes() {
        return accountTypeDAO.getAccountTypes();
    }
}
