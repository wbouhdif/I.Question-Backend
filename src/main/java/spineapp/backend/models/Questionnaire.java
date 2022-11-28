package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EmployedQuestion> employedQuestions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<AnsweredQuestionnaire> answeredQuestionnaires;

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
