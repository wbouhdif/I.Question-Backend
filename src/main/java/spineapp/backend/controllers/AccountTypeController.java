package spineApp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spineApp.backend.daos.AccountTypeDAO;

@RestController
public class AccountTypeController {
    @Autowired
    private final AccountTypeDAO accountTypeDAO;

    public AccountTypeController(AccountTypeDAO accountTypeDAO) {
        this.accountTypeDAO = accountTypeDAO;
    }

}
