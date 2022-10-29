package spineApp.backend.controllers;

public class HealthcareHomeController {
    private static HealthcareHomeController instance;
    public static HealthcareHomeController getInstance() {
        if (instance == null) {
            instance = new HealthcareHomeController();
        }
        return instance;
    }
}
