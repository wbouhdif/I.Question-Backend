package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spineapp.backend.models.Questionnaire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class QuestionnaireDAO {

    private final QuestionnaireRepository questionnaireRepository ;

    @Autowired
    public QuestionnaireDAO(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }
    public List<Questionnaire> getQuestionnaires() {return questionnaireRepository.findAll();}

    public List<Questionnaire> getQuestionnaires(){
        return questionnaireRepository.findAll();
    }

    public Optional<Questionnaire> getQuestionnaireById(UUID id) {
        return questionnaireRepository.findById(id);
    }

    @Transactional
    public UUID createQuestionnaire(Questionnaire questionnaire){
        questionnaireRepository.save(questionnaire);
        return questionnaire.getId();
    }

    public boolean existsById(UUID id){
        return questionnaireRepository.existsById(id);
    }

    public void deleteQuestionnaire(UUID id) {
        questionnaireRepository.deleteById(id);
    }

}
