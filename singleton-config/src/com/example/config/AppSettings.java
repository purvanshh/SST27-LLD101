package com.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings {
    private final Properties props = new Properties();
    private static volatile AppSettings instance;

    private AppSettings() {}

    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (AppSettings.class) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    public synchronized void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.clear();
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load settings", e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
    // Optionally, add set(String key, String value) if mutability is needed
}
