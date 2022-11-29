package spineapp.backend.models;

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

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "answered_questionnaire", referencedColumnName = "id", nullable = false)
    private AnsweredQuestionnaire answeredQuestionnaire;

    @ManyToOne
    @JoinColumn(name = "employed_question", referencedColumnName = "id", nullable = false)
    private EmployedQuestion employedQuestion;


    /**
     * Constructs an empty Answer without parameters. These can be defined after creation.
     */
    public Answer() {}

    /**
     * Constructor for Answer
     * @param text Text for the answer
     * @param answeredQuestionnaire The answered questionnaire the answer belongs to
     * @param employedQuestion The employed question the answer belongs to.
     */
    public Answer(String text, AnsweredQuestionnaire answeredQuestionnaire, EmployedQuestion employedQuestion) {
        this.text = text;
        this.answeredQuestionnaire = answeredQuestionnaire;
        this.employedQuestion = employedQuestion;
    }

}
