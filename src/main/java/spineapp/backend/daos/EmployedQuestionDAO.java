package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.EmployedQuestion;

import java.util.List;
import java.util.UUID;

@Component
public class EmployedQuestionDAO {

    private final EmployedQuestionRepository employedQuestionRepository;

    @Autowired
    public EmployedQuestionDAO(EmployedQuestionRepository employedQuestionRepository) {
        this.employedQuestionRepository = employedQuestionRepository;
    }

    public void createEmployedQuestion(EmployedQuestion employedQuestion){
        employedQuestionRepository.save(employedQuestion);
    }

    public List<EmployedQuestion> getEmployedQuestionsByQuestionnaire(UUID questionnaireId) {
        return employedQuestionRepository.findAllByQuestionnaire(questionnaireId);
    }
    public boolean existsById(UUID id){
        return employedQuestionRepository.existsById(id);
    }

}
