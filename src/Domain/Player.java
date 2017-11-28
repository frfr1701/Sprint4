package Domain;

import Server.config.Config;
import java.io.*;
import java.util.*;

class Player implements Serializable {
    
    private final List<Boolean> result = new ArrayList<>();
  
    void addAnswerToList(boolean i) {
        result.add(i);
    }
    List<Boolean> getPlayerResultList(){
        return result;
    }
    long getPlayerResult(){
        return result.stream().filter(value -> value.equals(true)).count();
    }
    long getPlayedRounds(){
        return result.stream().count()/new Config().getQuestionsPerRound();
    }
}
