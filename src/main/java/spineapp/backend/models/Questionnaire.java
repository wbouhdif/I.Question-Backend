package spineapp.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "\"questionnaire\"")

public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "account", referencedColumnName = "id")
    private Account account;

    /**
     * Constructs an empty questionnaire without parameters. These can be defined after creation.
     */
    public Questionnaire() {}

    /**
     * Constructs a Questionnaire object.
     * @param name Name of the questionnaire in question.
     * @param account Account responsible for creating the questionnaire.
     */
    public Questionnaire(String name, Account account) {
        this.name = name;
        this.account = account;
    }

}
