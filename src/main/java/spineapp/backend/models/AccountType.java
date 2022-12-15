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

    /**
     * Constructs an empty account type without parameters. These can be defined after creation.
     */
    public AccountType() {}

    /**
     * Constructs a new Account Type
     * @param name Name
     */
    public AccountType(String name) {
        this.name = name;
    }

}
