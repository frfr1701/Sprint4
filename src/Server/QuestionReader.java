package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.*;
import java.util.*;

public class QuestionReader implements Serializable{

    Path dir = Paths.get("src\\Resources");
    DirectoryStream<Path> directoryStream;
    List<String> subjects = new ArrayList<>();
    List<String[]> questions = new ArrayList<>();

    public QuestionReader() {
        try {
            directoryStream = Files.newDirectoryStream(dir, "*.{txt}");
            directoryStream.forEach((path) -> {
                subjects.add(path.getFileName().toString().replace(".txt", ""));
                FileReader(path);
            });
        } catch (IOException ex) {
            System.out.println("Fel vid inläsning av textfiler från " + dir.toString());
            System.out.println(ex.getCause());
        }
    }

    private void FileReader(Path p) {
        String[] temp = new String[6];
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(p))) {
            while (((temp[0] = br.readLine()) != null)
                    && ((temp[1] = br.readLine()) != null)
                    && ((temp[2] = br.readLine()) != null)
                    && ((temp[3] = br.readLine()) != null)
                    && ((temp[4] = br.readLine()) != null)
                    && ((temp[5] = br.readLine()) != null)) {
                questions.add(temp);
            }
        } catch (IOException ex) {
            System.out.println("Fel vid inläsning av filen " + p.getFileName());
            System.out.println(ex.getCause());
        }
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public List<String[]> getQuestions() {
        return questions;
    }
}
