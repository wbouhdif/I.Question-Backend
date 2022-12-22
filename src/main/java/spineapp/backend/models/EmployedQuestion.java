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

    @Column(nullable = false)
    private int position;

    @Column(nullable = false)
    private Boolean mandatory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employedQuestion")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Answer> answers;


    /**
     * Constructs an empty Employed question without parameters. These can be defined after creation
     */
    public EmployedQuestion() {}

    /**
     * Creates a new EmployedQuestion
     * @param question The question that needs to be added
     * @param questionnaire the questionnaire it needs to be added to
     * @param position the position within the questionnaire where the question will be.
     * @param mandatory A check to see whether the question needs to be answered or if it can be skipped
     */
    public EmployedQuestion(Question question, Questionnaire questionnaire, int position, boolean mandatory) {
        this.question = question;
        this.questionnaire = questionnaire;
        this.position = position;
        this.mandatory = mandatory;
    }

}
