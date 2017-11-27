package Domain;

import Server.config.Config;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Player implements Serializable {
    
    private List<Boolean> result = new ArrayList<Boolean>();
  
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
