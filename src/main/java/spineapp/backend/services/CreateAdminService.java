package spineapp.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spineapp.backend.constants.AccountTypeConstants;
import spineapp.backend.daos.AccountDAO;
import spineapp.backend.daos.AccountTypeDAO;
import spineapp.backend.models.Account;
import spineapp.backend.models.AccountType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreateAdminService {

    private final AccountDAO accountDAO;
    private final PasswordEncoder passwordEncoder;
    private final AccountTypeDAO accountTypeDAO;

    @Autowired
    public CreateAdminService(AccountDAO accountDAO, PasswordEncoder passwordEncoder, AccountTypeDAO accountTypeDAO) {
        this.accountDAO = accountDAO;
        this.passwordEncoder = passwordEncoder;
        this.accountTypeDAO = accountTypeDAO;
    }

    public void listenTerminal() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String email;
        String password;
        String firstName;
        String lastName;

        while (true) {
            if (reader.readLine().equals("/create admin")) {
                System.out.println("Enter e-mail: ");
                email = reader.readLine();

                System.out.println("Enter password: ");
                password = reader.readLine();

                System.out.println("Enter first name: ");
                firstName = reader.readLine();

                System.out.println("Enter last name: ");
                lastName = reader.readLine();

                System.out.println("Create admin account with e-mail: '" + email + "' and password: '" + password + "'? (Y/N)");
                if (reader.readLine().toUpperCase().equals("Y")) {
                    createAdmin(email, password, firstName, lastName);
                } else {
                    System.out.println("Admin creation cancelled.");
                }
            }
        }
    }

    public void createAdmin(String email, String password, String firstName, String lastName) {
        String encodedPassword = passwordEncoder.encode(password);

        Optional<AccountType> accountType = accountTypeDAO.getAccountTypeByName(AccountTypeConstants.ADMIN.getName());
        Account admin = new Account(email, encodedPassword, firstName, lastName, true, accountType.get());

        accountDAO.registerNewAccount(admin);
        System.out.println("\nAdmin account succesfully created.");
    }
}
