package Server;

import Domain.*;
import static Domain.GameState.*;
import Server.config.Config;
import java.util.List;

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
    int questionsperround;
    int numberOfRounds;
    protected List<String> allSubjects;
    protected List<String[]> allQuestions;
    

    Protocol(){
        c = new Config();
        questionsperround =  c.getQuestionsPerRound();
        numberOfRounds = c.getNumberOfRounds();
    }

    public Session getInitialSession() {
        return new Session();
    }

    public Session processInput(Session s) {
        state = s.getState();
        gameState = s.getGameState();
        printState();
        
    
        switch (gameState) {
            case SERVERFIRST:
                s.setAllSubjects(allSubjects);
                s.setQuestionsThisRound(allQuestions);
                //val kategeri
                
                //svara
                //svara
                //svara
                //(DYNAMISKT)


                //SWTICHPLAYER
                s.setGameState(CLIENTFIRST);
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
                s.addToRoundCounter();
                s.changePlayer();
                if (s.getRoundCounter() == numberOfRounds ) { // TODO: Lägg till roundcounter() clienten efter varje runda
                            s.setGameState(CLIENTFINAL);
                        } else {
                            s.setGameState(CLIENTMIDDLE);
                        }
                
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
                s.changePlayer();
                s.setGameState(GAMECOMPLETE);
                
                break;
        }
        return s;
    }
    
    
    public void printState(){
        System.out.println("Server: " + state);
    }
    
    

}
