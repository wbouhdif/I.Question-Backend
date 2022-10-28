package spineApp.controllers;

public class FillingQuestionnaireController {
    private static FillingQuestionnaireController instance;
    public static FillingQuestionnaireController getInstance() {
        if (instance == null) {
            instance = new FillingQuestionnaireController();
        }
        return instance;
    }
}
