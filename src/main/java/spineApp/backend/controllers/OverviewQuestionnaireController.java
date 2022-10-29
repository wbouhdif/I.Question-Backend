package spineApp.backend.controllers;

public class OverviewQuestionnaireController {
    private static OverviewQuestionnaireController instance;
    public static OverviewQuestionnaireController getInstance() {
        if (instance == null) {
            instance = new OverviewQuestionnaireController();
        }
        return instance;
    }
}
