package spineApp.backend.controllers;

public class SpineHomeController {
    private static SpineHomeController instance;
    public static SpineHomeController getInstance() {
        if (instance == null) {
            instance = new SpineHomeController();
        }
        return instance;
    }
}
