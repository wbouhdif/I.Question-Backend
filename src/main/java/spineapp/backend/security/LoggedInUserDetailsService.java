package spineapp.backend.security;

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

    @Autowired private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> accountRes = accountRepository.findAccountByEmail(email);
        if(accountRes.isEmpty())
            throw new UsernameNotFoundException("Could not findUser with email = " + email);
        Account account = accountRes.get();
        return new org.springframework.security.core.userdetails.User(
                email,
                account.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}