package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "question", referencedColumnName = "id")
    @JsonManagedReference
    private Question question;

    @ManyToOne
    @JoinColumn(name = "questionnaire", referencedColumnName = "id")
    @JsonManagedReference
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
