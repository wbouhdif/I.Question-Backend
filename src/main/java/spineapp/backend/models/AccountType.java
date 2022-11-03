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

    public AccountType() {}

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
