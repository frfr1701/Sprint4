package Domain;

import java.util.*;
import java.util.stream.Collectors;

abstract class ListManger {

    protected static List<List<String>> getSessionQuestions(List<List<String>> allQuestions, String whichSubject, int amountOfQuestions) {
        return new LinkedList<>((List<List<String>>) differentElements(filterBySubject(allQuestions, whichSubject), amountOfQuestions));
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

    protected static List<List<String>> filterBySubject(List<List<String>> fromList, String filterByThisSubject) {
        return fromList.stream().filter(indexOfList -> indexOfList.get(0).equalsIgnoreCase(filterByThisSubject)).collect(Collectors.toList());
    }
}
