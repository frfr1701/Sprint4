package Domain;

import Server.config.Config;
import java.io.*;
import java.util.*;

class Player implements Serializable {
    
    private final List<Boolean> result = new ArrayList<>();
  
    protected void addAnswerToList(boolean i) {
        result.add(i);
    }
    protected List<Boolean> getPlayerResultList(){
        return result;
    }
    protected long getPlayerResult(){
        return result.stream().filter(value -> value.equals(true)).count();
    }
    protected long getPlayedRounds(){
        return result.stream().count()/new Config().getQuestionsPerRound();
    }
}
