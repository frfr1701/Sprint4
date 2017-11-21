package Domain;

import java.util.*;
import java.util.stream.Collectors;

class ListManger{
    
    public static List<?> differentElements(List<?> fromList, int antal) {
        Set UniqueElements = new HashSet();
        while (UniqueElements.size() < antal) {
            UniqueElements.add(giveRandomElement(fromList));
        }
        return (List<?>)UniqueElements.stream().collect(Collectors.toList());
    }

    public static Object giveRandomElement(List chosenOne) {
        return chosenOne.get((int) (Math.random() * chosenOne.size()));
    }

    public static List<String[]> filterBySubject(List<String[]> fromList, String filterByThisSubject) {
        return fromList.stream().filter(indexOfList -> indexOfList[0].equalsIgnoreCase(filterByThisSubject)).collect(Collectors.toList());
    }

    public static List shuffleList(List shuffleMe) {
        Collections.shuffle(shuffleMe);
        return shuffleMe;
    }
}
