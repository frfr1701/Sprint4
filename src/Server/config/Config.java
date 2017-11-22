package Server.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Integer numberOfRounds;
    private Integer questionsPerRound;

    public Config(){

        Properties properties = new Properties();
        try {
            
            properties.load(new FileInputStream("src/Server/config/Config.properties"));
        } catch (IOException e) {
            System.out.println("fel vid inläsning av config filen");
            System.out.println(e.getCause());
        }
        this.numberOfRounds =  Integer.valueOf(properties.getProperty("numberOfRounds", "2"));
        this.questionsPerRound =  Integer.valueOf(properties.getProperty("questionsPerRound", "3"));
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public Integer getQuestionsPerRound() {
        return questionsPerRound;
    }
}
