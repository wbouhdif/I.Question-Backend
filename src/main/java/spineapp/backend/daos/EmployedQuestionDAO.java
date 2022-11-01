package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployedQuestionDAO {

    private final EmployedQuestionRepository employedQuestionRepository;

    @Autowired
    public EmployedQuestionDAO(EmployedQuestionRepository employedQuestionRepository) {
        this.employedQuestionRepository = employedQuestionRepository;
    }

}
