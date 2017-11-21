package Domain;

import static Domain.GameState.*;
import java.io.Serializable;
import java.util.List;

public class Session implements Serializable {

    static final long serialVersionUID = -7588980448693010399L;
    protected State state;
    protected GameState gameState;
    protected String question;
    protected List<String> allSubjects;
    protected List<String[]> allQuestions;
    
    protected String roundSubject;
    protected List<String[]> roundQuestions;
    
    protected String answer = "";
    protected int currentRond = 0;
    protected int scoreRond = 0;
    protected int scoreTotal = 0;
    protected Player one;
    protected Player two;
    protected boolean whichPlayer;
    protected final int correctAnswer = 2;
    protected int roundCounter = 1;



    public Session() {
        gameState = CLIENTFIRST;
        one = new Player();
        two = new Player();
    }

    public void setAllSubjects(List<String> allSubjects) {
        this.allSubjects = allSubjects;
    }

    public void setQuestionsThisRound(List<String[]> allQuestions) {
        this.allQuestions = allQuestions;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public State getState() {
        return state;
    }

    public GameState getGameState() {
        return gameState;
    }
    
    
    public void addToRoundCounter () {
        roundCounter++;
    }
    
    public void resetRoundCounter () {
        roundCounter = 1;
    }
    
    public int getRoundCounter () {
        return roundCounter;
    }

    public List<String> getDynamicSubjects() {
       return (List<String>)ListManger.differentElements(allSubjects, 3);
    }

    public List<String[]> getDynamicQuestions(String whatSubject) {
        roundQuestions = (List<String[]>) ListManger.differentElements(ListManger.filterBySubject(allQuestions, whatSubject), 3);
        return roundQuestions;
    }
    
    public boolean getWhichPlayer(){
        return whichPlayer;
    }
    
    public void changePlayer(){
        whichPlayer = !whichPlayer;
    }

    public void givePoint() {
        if (whichPlayer) {
            one.givePoint();
        }else{
            two.givePoint();
        }
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
    
    
    
    //HHHEEELP

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String[]> getAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(List<String[]> allQuestions) {
        this.allQuestions = allQuestions;
    }

    public String getRoundSubject() {
        return roundSubject;
    }

    public void setRoundSubject(String roundSubject) {
        this.roundSubject = roundSubject;
    }

    public List<String[]> getRoundQuestions() {
        return roundQuestions;
    }

    public void setRoundQuestions(List<String[]> roundQuestions) {
        this.roundQuestions = roundQuestions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCurrentRond() {
        return currentRond;
    }

    public void setCurrentRond(int currentRond) {
        this.currentRond = currentRond;
    }

    public int getScoreRond() {
        return scoreRond;
    }

    public void setScoreRond(int scoreRond) {
        this.scoreRond = scoreRond;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public Player getOne() {
        return one;
    }

    public void setOne(Player one) {
        this.one = one;
    }

    public Player getTwo() {
        return two;
    }

    public void setTwo(Player two) {
        this.two = two;
    }

    public boolean isWhichPlayer() {
        return whichPlayer;
    }

    public void setWhichPlayer(boolean whichPlayer) {
        this.whichPlayer = whichPlayer;
    }
            
            
}
