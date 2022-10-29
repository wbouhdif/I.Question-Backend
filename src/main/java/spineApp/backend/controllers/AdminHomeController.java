package spineApp.backend.controllers;

public class AdminHomeController {
    private static AdminHomeController instance;
    public static AdminHomeController getInstance() {
        if (instance == null) {
            instance = new AdminHomeController();
        }
        return instance;
    }
}
