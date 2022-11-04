package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
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

    /**
     * Constructs an empty account without parameters. These can be defined after creation.
     */
    public Account() {}

    /**
     * Constructs an Account object
     * @param email Email address
     * @param password password
     * @param firstName first name
     * @param lastName last name
     * @param middleName middle name
     * @param isValidated check to see if the account has been validated by the Admin
     * @param type Type of the account
     */
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
