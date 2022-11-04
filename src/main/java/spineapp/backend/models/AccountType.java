package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "\"account_type\"")

public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @Column(name = "can_manage_questionnaires")
    private Boolean canManageQuestionnaires;

    @Column(name = "can_fill_questionnaires")
    private Boolean canFillQuestionnaires;

    @Column(name = "can_authorise_accounts")
    private Boolean canAuthoriseAccounts;

    @Column(name = "can_view_anonymous_data")
    private Boolean canViewAnonymousData;

    @Column(name = "can_view_personalised_data")
    private Boolean canViewPersonalisedData;

    @OneToMany
    @JoinColumn(name = "type")
    @JsonBackReference
    private Set<Account> accounts = new HashSet<>();

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
