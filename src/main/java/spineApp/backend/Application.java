package spineApp.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import spineApp.backend.constants.AccountTypeConstants;
import spineApp.backend.daos.AccountTypeDAO;
import spineApp.backend.daos.AccountTypeRepository;


@SpringBootApplication
public class Application {
    @Autowired
    private final AccountTypeRepository accountTypeRepository;
    @Autowired
    private final AccountTypeDAO accountTypeDao;

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
            accountTypeDao.registerAccountType(AccountTypeConstants.ADMIN);
            accountTypeDao.registerAccountType(AccountTypeConstants.CAREGIVER);
            accountTypeDao.registerAccountType(AccountTypeConstants.SPINE);

        }
    }
}
