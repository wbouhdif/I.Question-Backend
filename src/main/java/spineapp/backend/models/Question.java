package spineApp.backend.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "\"question\"")

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String type;

    @Column
    private String text;

    @Column
    private Boolean mandatory;

    public Question() {}

    public Question(String type, String text, Boolean mandatory) {
        this.type = type;
        this.text = text;
        this.mandatory = mandatory;
    }

}
