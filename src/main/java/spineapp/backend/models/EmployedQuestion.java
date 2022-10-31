package spineapp.backend.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "\"employed_question\"")

public class EmployedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "question", referencedColumnName = "id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "questionnaire", referencedColumnName = "id")
    private Questionnaire questionnaire;

    @Column
    private int position;

    public EmployedQuestion() {}

    public EmployedQuestion(Question question, Questionnaire questionnaire, int position) {
        this.question = question;
        this.questionnaire = questionnaire;
        this.position = position;
    }

}
