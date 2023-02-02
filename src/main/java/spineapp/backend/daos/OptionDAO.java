package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spineapp.backend.models.Option;

import java.util.List;
import java.util.UUID;

@Component
public class OptionDAO {

    private final OptionRepository optionRepository;

    /**
     * Constructs instance of OptionDAO with the optionRepository via dependency injection.
     * @param optionRepository Parameter of type OptionRepository to be injected into.
     */
    @Autowired
    public OptionDAO(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    /**
     * Creates entry in option table in database.
     * @param option Option to be posted.
     */
    @Transactional
    public UUID createOption(Option option){
        optionRepository.save(option);
        return option.getId();
    }

    /**
     * Finds all options in database with given question.
     * @param question ID of question to be looked for.
     * @return
     * Returns list of all options with given question that were found.
     */
    public List<Option> getOptionsByQuestion(UUID question) {
        return optionRepository.findAllByQuestion(question);
    }

    public boolean existsById(UUID id) {
        return this.optionRepository.existsById(id);
    }

    public void deleteOption(UUID id) {
        optionRepository.deleteById(id);
    }
}
