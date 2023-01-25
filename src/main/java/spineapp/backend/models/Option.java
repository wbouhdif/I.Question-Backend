package spineapp.backend.models;

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

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private int position;

    @ManyToOne
    @JoinColumn(name = "question", referencedColumnName = "id", nullable = false)
    private Question question;

    /**
     * Constructs en empty Option without parameters. These can be defined after creation.
     */
    public Option() {}

    /**
     * Constructs a new Option
     * @param text The text for the new option
     * @param question The question the option will belong to
     */
    public Option(String text, Question question) {
        this.text = text;
        this.question = question;
    }

}
