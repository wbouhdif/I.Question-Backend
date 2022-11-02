package spineapp.backend.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "\"question\"")

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String type;

    @Column
    private String text;

    @Column
    private Boolean mandatory;

    @OneToMany
    @JoinColumn(name = "question")
    private Set<EmployedQuestion> employedQuestions = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "question")
    private Set<Option> options = new HashSet<>();

    public Question() {}

    public Question(String type, String text, Boolean mandatory) {
        this.type = type;
        this.text = text;
        this.mandatory = mandatory;
    }

}
