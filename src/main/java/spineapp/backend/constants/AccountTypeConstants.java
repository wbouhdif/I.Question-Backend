package spineapp.backend.constants;


import spineapp.backend.models.AccountType;

public class AccountTypeConstants {

    public static final AccountType ADMIN = new AccountType("Admin", true, true, true, true, false);
    public static final AccountType CAREGIVER = new AccountType("Caregiver", false, true, false, false, true);
    public static final AccountType SPINE = new AccountType("Spine", true, true, false, true, false);

}
