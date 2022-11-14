package spineapp.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "\"account_type\"")

public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "can_manage_questionnaires", nullable = false)
    private Boolean canManageQuestionnaires;

    @Column(name = "can_fill_questionnaires", nullable = false)
    private Boolean canFillQuestionnaires;

    @Column(name = "can_authorise_accounts", nullable = false)
    private Boolean canAuthoriseAccounts;

    @Column(name = "can_view_anonymous_data", nullable = false)
    private Boolean canViewAnonymousData;

    @Column(name = "can_view_personalised_data", nullable = false)
    private Boolean canViewPersonalisedData;

    /**
     * Constructs an empty account type without parameters. These can be defined after creation.
     */
    public AccountType() {}

    /**
     * Constructs a new Account Type
     * @param name Name
     * @param canManageQuestionnaires A check to see whether the new account type can manage questionnaires
     * @param canFillQuestionnaires A check to see whether the new account type can fill in existing questionnaires
     * @param canAuthoriseAccounts A check to see whether the new account type can Authorise other accounts
     * @param canViewAnonymousData A check to see whether the new account type can view anonymised data
     * @param canViewPersonalisedData A check to see whether the new account type can view personalised data
     */
    public AccountType(String name,
                       Boolean canManageQuestionnaires,
                       Boolean canFillQuestionnaires,
                       Boolean canAuthoriseAccounts,
                       Boolean canViewAnonymousData,
                       Boolean canViewPersonalisedData) {
        this.name = name;
        this.canManageQuestionnaires = canManageQuestionnaires;
        this.canFillQuestionnaires = canFillQuestionnaires;
        this.canAuthoriseAccounts = canAuthoriseAccounts;
        this.canViewAnonymousData = canViewAnonymousData;
        this.canViewPersonalisedData = canViewPersonalisedData;
    }

}
