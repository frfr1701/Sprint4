package Server;

import static Domain.State.*;
import Domain.*;
import Server.config.Config;
import java.util.*;

class Protocol {

    private final QuestionReader qr;
    private final Config c;

    private final List<String> allSubjects;
    private final List<List<String>> allQuestions;
    private final int numberOfRounds;
    private final int numberOfQuestions;
    private final int numberOfSubjects;

    private State gameState;

    protected Protocol() {
        c = new Config();
        numberOfRounds = c.getNumberOfRounds();
        numberOfSubjects = 3;
        numberOfQuestions = c.getQuestionsPerRound();

        qr = new QuestionReader();
        allSubjects = qr.getSubjects();
        allQuestions = qr.getQuestions();
    }


    protected Session getInitialSession() {
        return new Session(numberOfSubjects, numberOfQuestions, numberOfRounds);
    }

    protected Session processSession(Session session) {
        gameState = session.getGameState();
        switch (gameState) {
            case LOADGAME:
                session.setAllSubjects(allSubjects);
                session.setAllQuestions(allQuestions);
                
                session.setGameState(FIRST);
                session.changePlayer();
                break;
            case FIRST:
                session.addToRoundCounter();
                session.setGameState(MIDDLE);
                session.changePlayer();
                break;
            case MIDDLE:
                
                if (session.isFinalRound()) {
                    session.setGameState(FINAL);
                    session.changePlayer();
                    break;
                }
                
                session.addToRoundCounter();
                session.changePlayer();
                break;
            case FINAL:
                session.setGameState(GAMECOMPLETE);
                session.changePlayer();
                break;
        }
        return session;
    }
}
