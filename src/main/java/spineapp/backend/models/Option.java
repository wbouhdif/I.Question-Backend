package spineapp.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "\"option\"")

public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "question", referencedColumnName = "id")
    @JsonManagedReference
    private Question question;

    public Option() {}

    public Option(String text, Question question) {
        this.text = text;
        this.question = question;
    }

}
