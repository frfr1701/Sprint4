package Server;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class QuestionReader implements Serializable {

    private final Path dir = Paths.get("src\\Server\\Resources");
    private DirectoryStream<Path> directoryStream;
    protected List<String> subjects;
    protected List<String[]> questions;

    public QuestionReader() {
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

    /**
     * //läser in 5 rader från en textfil och lägger dem i en array 
     * //plats 1 är frågan 
     * //plats 2 är RÄTT svar 
     * //plats 3 är fel svar 
     * //plats 4 är fel svar 
     * //plats 5 är fel svar
     * //(Plats 0 i arrayen blir kategorin)
     * @param p path för filen som ska läsas in
     */
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

    public List<String> getSubjects() {
        return subjects;
    }
    
    public List<String[]> getQuestions(String subject) {
        return questions.stream().filter((index) -> index[0].equalsIgnoreCase(subject)).collect(Collectors.toList());
    }
}

class QuestionsAndSubjects extends QuestionReader {

    private final int NumberOfQuestions;
    private final int NumberOfSubjects;

    public QuestionsAndSubjects(int NumberOfQuestions, int NumberOfSubjects) {
        this.NumberOfQuestions = NumberOfQuestions;
        this.NumberOfSubjects = NumberOfSubjects;
    }

    @Override
    public List<String> getSubjects() {
        return shuffleMaList(makeListFromSet(differentElements(subjects, NumberOfSubjects)));
    }

    @Override
    public List<String[]> getQuestions(String subject) {
        return shuffleMaList(makeListFromSet(differentElements(filteredBoiSubject(subject), NumberOfQuestions)));
    }

    private Set differentElements(List fromList, int antal) {
        Set<Object> UniqueElements = new HashSet<>();
        while (UniqueElements.size() < antal) {
            UniqueElements.add(giveRandomElement(fromList));
        }
        return UniqueElements;
    }

    private Object giveRandomElement(List chosenOne) {
        return chosenOne.get((int) (Math.random() * chosenOne.size()));
    }

    private List<String[]> filteredBoiSubject(String filterByThisSubject) {
        return questions.stream().filter(indexOfList -> indexOfList[0].equalsIgnoreCase(filterByThisSubject)).collect(Collectors.toList());
    }

    private List makeListFromSet(Set set) {
        return (List) set.stream().collect(Collectors.toList());
    }

    private List shuffleMaList(List shuffleMe) {
        Collections.shuffle(shuffleMe);
        return shuffleMe;
    }
}
