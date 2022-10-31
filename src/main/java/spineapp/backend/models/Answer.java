package spineApp.backend.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "\"answer\"")

public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "answered_questionnaire", referencedColumnName = "id")
    private AnsweredQuestionnaire answeredQuestionnaire;

    public Answer() {}

    public Answer(String text, AnsweredQuestionnaire answeredQuestionnaire) {
        this.text = text;
        this.answeredQuestionnaire = answeredQuestionnaire;
    }

}
