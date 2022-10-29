package spineApp.backend.controllers;

public class AnsweredQuestionnaireController {
    private static AnsweredQuestionnaireController instance;
    public static AnsweredQuestionnaireController getInstance() {
        if (instance == null) {
            instance = new AnsweredQuestionnaireController();
        }
        return instance;
    }
}
