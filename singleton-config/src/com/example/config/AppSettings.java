package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;


//thread-safe singleton 

public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    private static volatile AppSettings instance;
    private final Properties props = new Properties();
    private static boolean isInitialized = false;

    
    private AppSettings() {
       
        if (isInitialized) {
            throw new RuntimeException("Cannot create another instance of singleton AppSettings");
        }
        isInitializeTd = true;
    }

    // Double-checked locking 

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

    //synchronized method for thread-safe loading
    public synchronized void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.clear(); 
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

}
