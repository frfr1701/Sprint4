package Domain;

import java.util.*;
import java.util.stream.Collectors;

abstract class ListManger {

    protected static List<String[]> getSessionQuestions(List<String[]> allQuestions, String whichSubject, int amountOfQuestions) {
        return (List<String[]>) differentElements(filterBySubject(allQuestions, whichSubject), amountOfQuestions);
    }

    protected static List<String> getSessionSubjects(List<String> allSubjects, int amountOfSubjects) {
        return (List<String>) differentElements(allSubjects, amountOfSubjects);
    }
    
    
    
    protected static List<?> differentElements(List<?> fromList, int antal) {
        Set UniqueElements = new HashSet();
        while (UniqueElements.size() < antal) {
            UniqueElements.add(giveRandomElement(fromList));
        }
        return (List<?>) UniqueElements.stream().collect(Collectors.toList());
    }

    protected static Object giveRandomElement(List chosenOne) {
        return chosenOne.get((int) (Math.random() * chosenOne.size()));
    }

    protected static List<String[]> filterBySubject(List<String[]> fromList, String filterByThisSubject) {
        return fromList.stream().filter(indexOfList -> indexOfList[0].equalsIgnoreCase(filterByThisSubject)).collect(Collectors.toList());
    }

    protected static List shuffleList(List shuffleMe) {
        Collections.shuffle(shuffleMe);
        return shuffleMe;
    }
}
