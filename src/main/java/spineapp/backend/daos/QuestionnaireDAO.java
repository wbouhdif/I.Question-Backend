package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Questionnaire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class QuestionnaireDAO {

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireDAO(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public List<Questionnaire> getQuestionnaires(){
        return questionnaireRepository.findAll();
    }

    public Optional<Questionnaire> getQuestionnaireById(UUID id) {
        return questionnaireRepository.findById(id);
    }

    public void createQuestionnaire(Questionnaire questionnaire){
        questionnaireRepository.save(questionnaire);
    }

    public boolean existsById(UUID id){
        return questionnaireRepository.existsById(id);
    }

}
