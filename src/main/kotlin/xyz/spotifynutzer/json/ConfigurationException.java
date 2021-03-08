package xyz.spotifynutzer.json;

public class ConfigurationException extends Exception {

    public ConfigurationException() {
        super("Failed to Convert Config");
    }

    public ConfigurationException(String message) {
        super(message);
    }
}
