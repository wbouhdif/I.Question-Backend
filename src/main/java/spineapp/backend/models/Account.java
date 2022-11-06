package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "\"account\"")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String email;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "is_validated")
    private Boolean isValidated;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private AccountType type;

    @OneToMany
    @JoinColumn(name = "caregiver")
    private Set<AnsweredQuestionnaire> answeredQuestionnaires = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "account")
    private Set<Questionnaire> questionnaires = new HashSet<>();

    public Account() {}

    public Account(String email, String password, String firstName, String lastName, String middleName, Boolean isValidated, AccountType type) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.isValidated = isValidated;
        this.type = type;
    }

}
