package Server.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Integer numberOfRounds;
    private Integer questionsPerRound;

    public Config() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Server/config/Config.properties"));

        this.numberOfRounds =  Integer.valueOf(properties.getProperty("numberOfRounds", "4"));
        this.questionsPerRound =  Integer.valueOf(properties.getProperty("questionsPerRound", "3"));
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public Integer getQuestionsPerRound() {
        return questionsPerRound;
    }
}
