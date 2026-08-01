package com.bank.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Utility class for logging customer feedback to a local file storage (feedback.txt).
 */
public class FeedbackStore {
    private static final String FILE = "feedback.txt";

    public static void append(String author, String text) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write("[" + LocalDateTime.now() + "] " + author + ":\n");
            fw.write(text + "\n\n");
        } catch (IOException e) {
            System.err.println("Failed to write feedback: " + e.getMessage());
        }
    }
}
