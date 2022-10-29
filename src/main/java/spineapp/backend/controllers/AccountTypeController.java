package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AccountTypeDao;
import spineapp.backend.models.AccountType;

@RestController
public class AccountTypeController {
    @Autowired AccountTypeDao accountTypeDao;
}
