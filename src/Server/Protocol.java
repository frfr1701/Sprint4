package Server;

import Domain.*;
import Server.config.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Protocol {

    QuestionReader qr;
    Config c;
    protected boolean whichPlayer;

    // String [][] matte = {fråga1Test, fråga2Test};
    private int category = 0;
    private int question = 1;
    private int correctAnswer = 2;
    private int currentQuestionInRond = 0;
    private int currentRond = 0;
    private State state;
    private GameState gameState;
    
    protected List<String> allSubjects;
    protected List<String[]> allQuestions;
    

    Protocol(){
        c = new Config();
        int questionsperround =  c.getQuestionsPerRound();
        
    }

    public Session getInitialSession() {
        return new Session();
    }

    public Session processInput(Session s) {
        state = s.getState();
        gameState = s.getGameState();
        printState();
        
        s.setAllSubjects(allSubjects);
        s.setQuestionsThisRound(allQuestions);
        
        
        switch (gameState) {
            case SERVERFIRST:
                //val kategeri
                
                //svara
                //svara
                //svara
                //(DYNAMISKT)


                //SWTICHPLAYER
                break;
            case SERVERMIDDLE:
                
                //svara
                //svara
                //svara
                //(DYNAMISKT)
                
                //val kategeri

                //svara
                //svara
                //svara
                //(DYNAMISKT)


                
                //SWTICHPLAYER
                break;
            case SERVERFINAL:

                //svara
                //svara
                //svara
                //(DYNAMISKT)
                
                
                
                //VISA RESULTAT
                //SWTICHPLAYER
                //VISA RESULTAT
                break;
        }
        return s;
    }
    
    
    public void answerQuestions(){
    
    }
    
    public void chooseSubject(){
        
    }
    
    
    
    public void printState(){
        System.out.println("Server: " + state);
    }
    
    

}
