package spineapp.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import spineapp.backend.constants.AccountTypeConstants;
import spineapp.backend.daos.AccountTypeDAO;
import spineapp.backend.daos.AccountTypeRepository;


@SpringBootApplication
public class Application {
    private final AccountTypeRepository accountTypeRepository;
    private final AccountTypeDAO accountTypeDao;

    @Autowired
    public Application(AccountTypeRepository accountTypeRepository, AccountTypeDAO accountTypeDao) {
        this.accountTypeRepository = accountTypeRepository;
        this.accountTypeDao = accountTypeDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createAccountTypes() {
        if (accountTypeRepository.findAll().isEmpty()) {

            accountTypeDao.createAccountType(AccountTypeConstants.ADMIN);
            accountTypeDao.createAccountType(AccountTypeConstants.CAREGIVER);
            accountTypeDao.createAccountType(AccountTypeConstants.SPINE);

        }
    }
}
