package spineapp.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "\"employed_question\"")

public class EmployedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "question", referencedColumnName = "id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "questionnaire", referencedColumnName = "id", nullable = false)
    private Questionnaire questionnaire;

    @Column
    private int position;

    /**
     * Constructs an empty Employed question without parameters. These can be defined after creation
     */
    public EmployedQuestion() {}

    /**
     * Creates a new EmployedQuestion
     * @param question The question that needs to be added
     * @param questionnaire the questionnaire it needs to be added to
     * @param position the position within the questionnaire where the question will be.
     */
    public EmployedQuestion(Question question, Questionnaire questionnaire, int position) {
        this.question = question;
        this.questionnaire = questionnaire;
        this.position = position;
    }

}
