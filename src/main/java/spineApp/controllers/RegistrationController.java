package spineApp.controllers;

public class RegistrationController {
    private static RegistrationController instance;
    public static RegistrationController getInstance() {
        if (instance == null) {
            instance = new RegistrationController();
        }
        return instance;
    }
}
