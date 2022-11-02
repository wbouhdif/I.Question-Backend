package spineapp.backend.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "\"questionnaire\"")

public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "account", referencedColumnName = "id")
    private Account account;

    @OneToMany
    @JoinColumn(name = "questionnaire")
    private Set<AnsweredQuestionnaire> answeredQuestionnaires = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "questionnaire")
    private Set<EmployedQuestion> employedQuestions = new HashSet<>();

    public Questionnaire() {}

    public Questionnaire(String name, Account account) {
        this.name = name;
        this.account = account;
    }

}
