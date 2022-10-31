package spineapp.backend.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spineapp.backend.daos.AccountRepository;

@Configuration
public class AccountConfig {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
        return args -> {

        };
    }


}
