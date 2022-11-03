package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.springframework.data.annotation.Persistent;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
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
