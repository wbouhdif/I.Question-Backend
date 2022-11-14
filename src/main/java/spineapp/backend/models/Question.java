package spineapp.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "\"question\"")

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Boolean mandatory;

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
