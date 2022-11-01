package spineapp.backend.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OptionDAO {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionDAO(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

}
