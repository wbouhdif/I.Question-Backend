package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spineapp.backend.models.Option;

import java.util.List;
import java.util.UUID;

@Component
public class OptionDAO {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionDAO(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public void createOption(Option option){
        optionRepository.save(option);
    }

    public List<Option> getOptionsByQuestion(UUID question) {
        return optionRepository.findAllByQuestion(question);
    }

}
