package com.dhairyashil;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HotelLogger implements Runnable {
    private final String message;

    public HotelLogger(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try (FileWriter fw = new FileWriter("hotel-actions.log", true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            fw.write("[LOG] [" + timestamp + "] " + message + "\n");
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}
