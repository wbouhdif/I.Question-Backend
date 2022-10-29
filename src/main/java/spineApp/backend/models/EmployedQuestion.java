package spineApp.backend.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "\"account\"")

public class EmployedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Question question;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
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
