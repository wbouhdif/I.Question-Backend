package spineApp.controllers;

public class LoginController {
    private static LoginController instance;
    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }
}
