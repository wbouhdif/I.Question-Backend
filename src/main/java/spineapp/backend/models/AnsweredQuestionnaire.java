package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
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
    @JoinColumn(name = "caregiver", referencedColumnName = "id")
    @JsonManagedReference
    private Account caregiver;

    @ManyToOne
    @JoinColumn(name = "questionnaire", referencedColumnName = "id")
    @JsonManagedReference
    private Questionnaire questionnaire;

    @Column(name = "client_name")
    private String clientName;

    @OneToMany
    @JoinColumn(name = "answered_questionnaire")
    @JsonBackReference
    private Set<Answer> answers = new HashSet<>();

    public AnsweredQuestionnaire() {}

    public AnsweredQuestionnaire(Account caregiver, Questionnaire questionnaire, String clientName) {
        this.caregiver = caregiver;
        this.questionnaire = questionnaire;
        this.clientName = clientName;
    }

}
