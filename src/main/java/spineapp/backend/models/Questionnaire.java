package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "\"questionnaire\"")

public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "account", referencedColumnName = "id")
    @JsonManagedReference
    private Account account;

    @OneToMany
    @JoinColumn(name = "questionnaire")
    @JsonBackReference
    private Set<AnsweredQuestionnaire> answeredQuestionnaires = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "questionnaire")
    @JsonBackReference
    private Set<EmployedQuestion> employedQuestions = new HashSet<>();

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
