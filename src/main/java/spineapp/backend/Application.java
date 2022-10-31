package spineapp.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import spineapp.backend.constants.AccountTypeConstants;
import spineapp.backend.daos.AccountTypeDAO;
import spineapp.backend.daos.AccountTypeRepository;


@SpringBootApplication
public class Application {

    @Autowired private AccountTypeRepository accountTypeRepository;
    @Autowired private AccountTypeDAO accountTypeDao;

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
