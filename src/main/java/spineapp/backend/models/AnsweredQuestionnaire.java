package spineapp.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "\"answered_questionnaire\"")

public class AnsweredQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "caregiver", referencedColumnName = "id", nullable = false)
    private Account caregiver;

    @ManyToOne
    @JoinColumn(name = "questionnaire", referencedColumnName = "id")
    private Questionnaire questionnaire;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    /**
     * Constructs an empty AnsweredQuestionnaire without parameters. These can be defined after creation
     */
    public AnsweredQuestionnaire() {}

    /**
     * Constructs a new AnsweredQuestionnaire
     * @param caregiver The Caregiver/healthcare worker who filled in the questionnaire
     * @param questionnaire The questionnaire that was answered
     * @param clientName The name of the client who answered the questionnaire
     */
    public AnsweredQuestionnaire(Account caregiver, Questionnaire questionnaire, String clientName) {
        this.caregiver = caregiver;
        this.questionnaire = questionnaire;
        this.clientName = clientName;
    }

}
