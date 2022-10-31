package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AccountTypeDAO;

@RestController
public class AccountTypeController {
    @Autowired private AccountTypeDAO accountTypeDAO;
}
