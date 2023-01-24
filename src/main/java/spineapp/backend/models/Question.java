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
@Table(name = "\"question\"")

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String text;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Option> options;

    /**
     * Constructs an empty Question without parameters. These can be defined after creation.
     */
    public Question() {}

    /**
     * Creates a new Question
     * @param type The type of the new question
     * @param text The Question's Text
     */
    public Question(String type, String text) {
        this.type = type;
        this.text = text;
    }

}
