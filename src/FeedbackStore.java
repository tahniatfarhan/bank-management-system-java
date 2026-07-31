import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FeedbackStore {
    private static final String FILE = "feedback.txt";

    public static void append(String author, String text) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write("[" + LocalDateTime.now() + "] " + author + ":\n");
            fw.write(text + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
