package spineApp.backend.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "\"account\"")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String email;

    @Column
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
    @JoinColumn(referencedColumnName = "id")
    private AccountType type;

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
