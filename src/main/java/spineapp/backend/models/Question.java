package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
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
    @JsonBackReference
    private Set<EmployedQuestion> employedQuestions = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "question")
    @JsonBackReference
    private Set<Option> options = new HashSet<>();

    /**
     * Constructs an empty Question without parameters. These can be defined after creation.
     */
    public Question() {}

    /**
     * Creates a new Question
     * @param type The type of the new question
     * @param text The Question's Text
     * @param mandatory A check to see whether the question needs to be answered or if it can be skipped
     */
    public Question(String type, String text, Boolean mandatory) {
        this.type = type;
        this.text = text;
        this.mandatory = mandatory;
    }

}
