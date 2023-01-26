package spineapp.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import spineapp.backend.constants.AccountTypeConstants;
import spineapp.backend.daos.AccountTypeDAO;
import spineapp.backend.daos.AccountTypeRepository;
import spineapp.backend.services.CreateAdminService;

import java.io.IOException;


@SpringBootApplication
public class Application {
    private final AccountTypeRepository accountTypeRepository;
    private final AccountTypeDAO accountTypeDao;
    private final CreateAdminService createAdminService;

    /**
     * Constructs new instance of Application with an accountTypeRepository and AccountTypeDao being instantiated via dependency injection.
     * @param accountTypeRepository Instance of AccountTypeRepository.
     * @param accountTypeDao Instance of AccountTypeDAO.
     */
    @Autowired
    public Application(AccountTypeRepository accountTypeRepository, AccountTypeDAO accountTypeDao, CreateAdminService createAdminService) {
        this.accountTypeRepository = accountTypeRepository;
        this.accountTypeDao = accountTypeDao;
        this.createAdminService = createAdminService;
    }

    /**
     * Main method which is the entry point of the java program.
     * @param args Standard syntax of the main method.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Fires when application is fully running. Is responsible for creating account types if they are not yet present.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void createAccountTypes() {
        if (accountTypeRepository.findAll().isEmpty()) {

            accountTypeDao.createAccountType(AccountTypeConstants.ADMIN);
            accountTypeDao.createAccountType(AccountTypeConstants.CAREGIVER);
            accountTypeDao.createAccountType(AccountTypeConstants.SPINE);

        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void listenConsole() {
        try {
            createAdminService.listenTerminal();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
