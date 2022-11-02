package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.springframework.data.annotation.Persistent;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCanManageQuestionnaires() {
        return canManageQuestionnaires;
    }

    public void setCanManageQuestionnaires(Boolean canManageQuestionnaires) {
        this.canManageQuestionnaires = canManageQuestionnaires;
    }

    public Boolean getCanFillQuestionnaires() {
        return canFillQuestionnaires;
    }

    public void setCanFillQuestionnaires(Boolean canFillQuestionnaires) {
        this.canFillQuestionnaires = canFillQuestionnaires;
    }

    public Boolean getCanAuthoriseAccounts() {
        return canAuthoriseAccounts;
    }

    public void setCanAuthoriseAccounts(Boolean canAuthoriseAccounts) {
        this.canAuthoriseAccounts = canAuthoriseAccounts;
    }

    public Boolean getCanViewAnonymousData() {
        return canViewAnonymousData;
    }

    public void setCanViewAnonymousData(Boolean canViewAnonymousData) {
        this.canViewAnonymousData = canViewAnonymousData;
    }

    public Boolean getCanViewPersonalisedData() {
        return canViewPersonalisedData;
    }

    public void setCanViewPersonalisedData(Boolean canViewPersonalisedData) {
        this.canViewPersonalisedData = canViewPersonalisedData;
    }
}
