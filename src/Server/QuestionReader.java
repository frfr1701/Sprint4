package Server;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class QuestionReader {
    public static void main(String[] args) {
        
        QuestionReader go = new QuestionsAndSubjects(1, 2);
        
        List<String[]> ra = go.getQuestions("Hej");
        ra.forEach((string) -> {
            for (String string1 : string) {
                System.out.println(string1);
            }
        });
    }

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

    /**
     * //läser in 5 rader från en textfil och lägger dem i en array 
     * //plats 0 är kategori
     * //plats 1 är frågan
     * //plats 2 är RÄTT svar
     * //plats 3 är fel svar 
     * //plats 4 är fel svar
     * //plats 5 är fel svar
     * @param p path för filen som ska läsas in
     */
    private void FileReader(Path p) {
        String[] temp = new String[6];
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(p))) {
            while (((temp[0] = br.readLine()) != null)
                    && ((temp[1] = br.readLine()) != null)
                    && ((temp[2] = br.readLine()) != null)
                    && ((temp[3] = br.readLine()) != null)
                    && ((temp[4] = br.readLine()) != null)
                    && ((temp[5] = br.readLine()) != null)) {
                questions.add(Arrays.copyOf(temp, temp.length));
            }
        } catch (IOException ex) {
            System.out.println("Fel vid inläsning av filen " + p.getFileName());
            System.out.println(ex.getCause());
        }
    }
    
    /**
     * @return ALLA kategorier som finns att välja på
     */
    public List<String> getSubjects() {
        return subjects;
    }
    
    /**
     * @param subject vilken kategori man vill ha frågor på
     * @return returnerar ALLA frågor på specifierad kategori
     */
    public List<String[]> getQuestions(String subject) {
        List<String[]> temp = questions.stream()
                .filter((index) -> index[0]
                .equalsIgnoreCase(subject))
                .collect(Collectors.toList());
        return temp;
    }
}

class QuestionsAndSubjects extends QuestionReader {

    private final int NumberOfQuestions;
    private final int NumberOfSubjects;

    public QuestionsAndSubjects(int NumberOfQuestions, int NumberOfSubjects) {
        if (NumberOfSubjects > subjects.size()) {
            throw new IllegalArgumentException("Det finns inte så många kategorier"
                    + "\navalible:" + subjects.size() 
                    + "\nrequested:" + NumberOfSubjects);
        }
        this.NumberOfQuestions = NumberOfQuestions;
        this.NumberOfSubjects = NumberOfSubjects;
    }
    /**
     * @return Speciferat antal subjects (se konstruktor)
     */
    @Override
    public List<String> getSubjects() {
        Set<String> randomIndexSet = new HashSet<>();
        while (randomIndexSet.size()<NumberOfSubjects) {
            randomIndexSet.add(subjects.get((int)(Math.random() * subjects.size())));
        }
        List<String> returnList = randomIndexSet.stream().collect(Collectors.toList());
        Collections.shuffle(returnList);
        return returnList;
    }
    /**
     * @param subject vilken kategori man vill ha frågor på
     * @return specifierat antal frågor (se konstruktor)
     */
    @Override
    public List<String[]> getQuestions(String subject) {
        List<String[]> filteredList = questions.stream().filter(indexOfList -> indexOfList[0]
                .equalsIgnoreCase(subject))
                .collect(Collectors.toList());
        
        if (NumberOfQuestions > filteredList.size()) {
            throw new IllegalArgumentException("\nDet finns inte tillräckligt många frågor "
                    + "i den här kategorin!\navalible:" 
                    + filteredList.size() 
                    + "\nrequested:" + NumberOfQuestions);
        }
        

        Set<String[]> randomIndexSet = new HashSet<>();
        while (randomIndexSet.size()<NumberOfQuestions) {
            randomIndexSet.add(filteredList.get((int)(Math.random() * filteredList.size())));
        }
        
        List<String[]> returnList = randomIndexSet.stream().collect(Collectors.toList());
        Collections.shuffle(returnList);
        return returnList;
        
    }
}
