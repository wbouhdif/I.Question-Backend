package spineApp.backend.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "\"answered_questionnaire\"")

public class AnsweredQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Account caregiver;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Questionnaire questionnaire;

    @Column(name = "client_name")
    private String clientName;

}