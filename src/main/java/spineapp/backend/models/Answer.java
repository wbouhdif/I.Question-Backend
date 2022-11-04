package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "\"answer\"")

public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "answered_questionnaire", referencedColumnName = "id")
    @JsonManagedReference
    private AnsweredQuestionnaire answeredQuestionnaire;

    /**
     * Constructs an empty Answer without parameters. These can be defined after creation.
     */
    public Answer() {}

    /**
     * Constructor for Answer
     * @param text Text for the answer
     * @param answeredQuestionnaire The answered questionnaire the answer belongs to
     */
    public Answer(String text, AnsweredQuestionnaire answeredQuestionnaire) {
        this.text = text;
        this.answeredQuestionnaire = answeredQuestionnaire;
    }

}
