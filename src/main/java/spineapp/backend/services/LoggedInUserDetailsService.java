package spineapp.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import spineapp.backend.daos.AccountRepository;
import spineapp.backend.models.Account;

import java.util.Collections;
import java.util.Optional;

@Component
public class LoggedInUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    /**
     * Constructs instance of LoggedInUserDetailsService with the accountRepository via dependency injection.
     * @param accountRepository Parameter of type AccountRepository to be injected into.
     */
    @Autowired
    public LoggedInUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Finds the user that is associated with the provided email address.
     * @param email Email address of the user.
     * @return
     * Returns the user associated with the provided email address.
     * @throws UsernameNotFoundException
     * Throws an exception if the email address provided is not associated with any existing account in the database.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> accountRes = accountRepository.findAccountByEmail(email);
        if(accountRes.isEmpty())
            throw new UsernameNotFoundException("Could not find user with email = " + email);
        Account account = accountRes.get();
        return new org.springframework.security.core.userdetails.User(
                email,
                account.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + account.getType().getName().toUpperCase())));
    }
}