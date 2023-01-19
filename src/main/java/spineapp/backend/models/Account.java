package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "\"account\"")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private Boolean authorised;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date dateCreated;


    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id", nullable = false)
    private AccountType type;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "account")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Questionnaire> questionnaires;

    /**
     * Constructs an empty account without parameters. These can be defined after creation.
     */
    public Account() {

    }

    /**
     * Constructs an Account object
     * @param email Email address
     * @param password password
     * @param firstName first name
     * @param lastName last name
     * @param authorised check to see if the account has been authorised by the Admin
     * @param type Type of the account
     */
    public Account(String email, String password, String firstName, String lastName, Boolean authorised, AccountType type) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorised = authorised;
        this.type = type;
    }

}
