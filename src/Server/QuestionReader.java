package Server;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class QuestionReader implements Serializable {

    private final Path dir = Paths.get("src\\Server\\Resources");
    private final DirectoryStream<Path> directoryStream;
    private List<String> subjects;
    private List<String[]> questions;
    QuestionReader() {
        questions = new ArrayList<>();
        subjects = new ArrayList<>();
        try {
            directoryStream = Files.newDirectoryStream(dir, "*.{txt}");
            directoryStream.forEach((path) -> {
                subjects.add(path.getFileName().toString().replace(".txt", ""));
                fileReader(path);
            });
        } catch (IOException ex) {
            System.out.println("Fel vid inläsning av textfiler från " + dir.toString());
            System.out.println(ex.getCause());
        }
    }

    private void fileReader(Path p) {
        String[] temp = new String[6];
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(p))) {
            while (((temp[1] = br.readLine()) != null)
                    && ((temp[2] = br.readLine()) != null)
                    && ((temp[3] = br.readLine()) != null)
                    && ((temp[4] = br.readLine()) != null)
                    && ((temp[5] = br.readLine()) != null)) {
                temp[0] = p.getFileName().toString().replace(".txt", "");
                questions.add(Arrays.copyOf(temp, temp.length));
            }
        } catch (IOException ex) {
            System.out.println("Fel vid inläsning av filen " + p.getFileName());
            System.out.println(ex.getCause());
        }
    }

    List<String> getSubjects() {
        return subjects;
    }

    List<String[]> getQuestions() {
        return questions;
    }
}
