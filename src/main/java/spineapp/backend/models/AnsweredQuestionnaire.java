package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answeredQuestionnaire")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Answer> answers;

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
