package Server.config;

import java.io.*;
import java.util.*;

public class Config {

    private final Integer numberOfRounds;
    private final Integer questionsPerRound;
    private final Properties properties;
    
    public Config(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/Server/config/Config.properties"));
        } catch (IOException e) {
            System.out.println("fel vid inläsning av config filen");
            System.out.println(e.getCause());
        }
        numberOfRounds =  Integer.valueOf(properties.getProperty("numberOfRounds", "2"));
        questionsPerRound =  Integer.valueOf(properties.getProperty("questionsPerRound", "3"));
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public Integer getQuestionsPerRound() {
        return questionsPerRound;
    }
}
