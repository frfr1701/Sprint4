package Server;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class QuestionReader implements Serializable {

    private final Path dir = Paths.get("src\\Server\\Resources");
    private DirectoryStream<Path> directoryStream;
    private List<String> subjects;
    private List<List<String>> questions;

    QuestionReader() {
        questions = new ArrayList<>();
        subjects = new ArrayList<>();
        try {
            directoryStream = Files.newDirectoryStream(dir, "*.{txt}");
            directoryStream.forEach((path) -> {
                subjects.add(path.getFileName().toString().replace(".txt", ""));
                questions.addAll(fileReader(path));
            });
        } catch (IOException ex) {
            System.out.println("Fel vid inläsning av textfiler från " + dir.toString());
            System.out.println(ex.getCause());
        }
    }
    private List<List<String>> fileReader(Path p) {
        String[] tempArray = new String[6];
        List<List<String>> tempList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(p))) {
            while (((tempArray[1] = br.readLine()) != null)
                    && ((tempArray[2] = br.readLine()) != null)
                    && ((tempArray[3] = br.readLine()) != null)
                    && ((tempArray[4] = br.readLine()) != null)
                    && ((tempArray[5] = br.readLine()) != null)) {
                tempArray[0] = p.getFileName().toString().replace(".txt", "");
                tempList.add(Arrays.asList(Arrays.copyOf(tempArray, tempArray.length)));
            }
        } catch (IOException ex) {
            System.out.println("Fel vid inläsning av filen " + p.getFileName());
            System.out.println(ex.getCause());
        }
        return tempList;
    }

    List<String> getSubjects() {
        return subjects;
    }
    
    List<List<String>> getQuestions() {
        return questions;
    }
}

