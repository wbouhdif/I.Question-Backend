package spineApp.controllers;

public class EditQuestionnaireController {
    private static EditQuestionnaireController instance;
    public static EditQuestionnaireController getInstance() {
        if (instance == null) {
            instance = new EditQuestionnaireController();
        }
        return instance;
    }
}
