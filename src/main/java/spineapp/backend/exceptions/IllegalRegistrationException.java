package spineapp.backend.exceptions;

import spineapp.backend.models.AccountType;

import java.util.Optional;

public class IllegalRegistrationException extends Exception {

    public IllegalRegistrationException(Optional<AccountType> accountType) {
        super("Account with account type '" + accountType.get().getName() + "' cannot be registered.");
    }

    public IllegalRegistrationException(Boolean authorised) {
        super("Account with authorised set to '" + authorised.toString() + "' cannot be registered.");
    }
}
