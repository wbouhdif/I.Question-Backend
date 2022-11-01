package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.OptionDAO;

@RestController
@RequestMapping(path = "api/option")
public class OptionController {

    private final OptionDAO optionDAO;

    @Autowired
    public OptionController(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

}
