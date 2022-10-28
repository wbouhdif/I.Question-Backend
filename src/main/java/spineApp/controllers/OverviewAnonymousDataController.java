package spineApp.controllers;

public class OverviewAnonymousDataController {
    private static OverviewAnonymousDataController instance;
    public static OverviewAnonymousDataController getInstance() {
        if (instance == null) {
            instance = new OverviewAnonymousDataController();
        }
        return instance;
    }
}
