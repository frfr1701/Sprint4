package Domain;

import static Domain.State.*;
import java.io.Serializable;
import java.util.List;

public class Session implements Serializable {

    private final Player one;
    private final Player two;
    private boolean whichPlayer;

    private List<String> allSubjects;
    private List<List<String>> allQuestions;
    private List<List<String>> questionsThisRound;

    private final int numberOfQuestions;
    private final int numberOfSubjects;
    private final int numberOfRounds;

    private State gameState;
    private int roundCounter;
    
    public Session(int numberOfSubjects, int numberOfQuestions, int numberOfRounds) {
        gameState = LOADGAME;
        one = new Player();
        two = new Player();
        roundCounter = 1;
        this.numberOfSubjects = numberOfSubjects;
        this.numberOfQuestions = numberOfQuestions;
        this.numberOfRounds = numberOfRounds;
    }

    //--------------------------------------------------------------------------
    //player start
    public void changePlayer() {
        whichPlayer = !whichPlayer;
    }

    public void givePointToPlayer() {
        if (whichPlayer) {
            one.givePoint();
        } else {
            two.givePoint();
        }
    }
    
    public int getPointsFromPlayer() {
        return whichPlayer ? one.getPoints() : two.getPoints();
    }
    //player end

    //--------------------------------------------------------------------------
    //gamestate start
    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    public State getGameState() {
        return gameState;
    }
    //gamestate end

    //--------------------------------------------------------------------------
    //roundCounter start
    public void addToRoundCounter() {
        roundCounter++;
    }

    public int getRoundCounter() {
        return roundCounter;
    }
    
    public boolean isFinalRound(){
        return roundCounter == numberOfRounds;
    }
    //roundCounter end

    //--------------------------------------------------------------------------
    //questions and subjects start
    public void setAllSubjects(List<String> allSubjects) {
        this.allSubjects = allSubjects;
    }

    public void setAllQuestions(List<List<String>> allQuestions) {
        this.allQuestions = allQuestions;
    }

    public List<String> getSubjects() {
        return ListManger.getSessionSubjects(allSubjects, numberOfSubjects);
    }

    public List<List<String>> getQuestions(String chosenSubject) {
        return questionsThisRound = ListManger.getSessionQuestions(allQuestions, chosenSubject, numberOfQuestions);
    }
    
    public void setQuestionsThisRound(List<List<String>> roundQuestions) {
        this.questionsThisRound = roundQuestions;
    }

    public List<List<String>> getQuestionsThisRound() {
        return questionsThisRound;
    }
    //questions and subjects end

    //--------------------------------------------------------------------------
}
