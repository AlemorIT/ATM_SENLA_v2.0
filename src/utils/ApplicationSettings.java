package utils;

public enum ApplicationSettings {

    DATA_FILE("accounts.txt");

    private final String title;

    ApplicationSettings(String title) {
        this.title = title;
    }

    public String GetTitle() {
        return title;
    }
}
