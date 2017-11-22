package Server;

import static Domain.State.*;
import Domain.*;
import Server.config.Config;
import java.util.*;

class Protocol {

    private final QuestionReader qr;
    private final Config c;

    private final List<String> allSubjects;
    private final List<String[]> allQuestions;
    private final int numberOfRounds;
    private final int numberOfQuestions;
    private final int numberOfSubjects;

    private State gameState;

    protected Protocol() {
        c = new Config();
        numberOfRounds = c.getNumberOfRounds();
        numberOfSubjects = 3;
        numberOfQuestions = 3;

        qr = new QuestionReader();
        allSubjects = qr.getSubjects();
        allQuestions = qr.getQuestions();
    }

<<<<<<< HEAD
    
    public Session processInput(Session s) {
        State state = s.getState();
        System.out.println("Server: " + state);
        s.setState(State.SERVERSTART);
        
        if (state == State.CLIENTSTARTSGAME ){
            if(s.getAnswer().equalsIgnoreCase("J")){
                s.setSubjectChoices(qr.getSubjects());
                subjectsRondTemp = s.getsubjectChoices(); // tillkalla metod isätllet
                s.setState(state.SERVERSENTWHATCATEGORYQUESTION);
            }
            
        } else if (state == State.CLIENTPICKEDSUBJECT) {
               
            if (s.getwhatSubject().equalsIgnoreCase(subjectsRondTemp.get(0))) {  

                System.out.println("Klienten valde " + subjectsRondTemp.get(0));
                questionsRondTemp = qr.getQuestions(subjectsRondTemp.get(0));
                s.setquestionsInARond(questionsRondTemp);
                s.setQuestion(questionsRondTemp.get(currentQuestionInRond)[question]);

            } else if (s.getwhatSubject().equalsIgnoreCase(subjectsRondTemp.get(1))) {

                System.out.println("Klienten valde " + subjectsRondTemp.get(1));
                questionsRondTemp = qr.getQuestions(subjectsRondTemp.get(1));
                s.setquestionsInARond(questionsRondTemp);
                s.setQuestion(questionsRondTemp.get(currentQuestionInRond)[question]);

            } else if (s.getwhatSubject().equalsIgnoreCase(subjectsRondTemp.get(2))) {

                System.out.println("Klienten valde " + subjectsRondTemp.get(2));
                questionsRondTemp = qr.getQuestions(subjectsRondTemp.get(2));
                s.setquestionsInARond(questionsRondTemp);
                s.setQuestion(questionsRondTemp.get(currentQuestionInRond)[question]);

            }
            System.out.println("Size " +s.getQuestionsInARond().size());
            s.setState(State.SERVERSENTQUESTION);

        } else if (state == State.CLIENTCLICKEDANSWER) {
            if (s.getAnswer().equalsIgnoreCase(questionsRondTemp.get(currentQuestionInRond)[correctAnswer])) {

                s.setVerdict(true);
                s.addScoreRond();
                s.addScoreTotal();
            } else {
                s.setVerdict(false);
            }
            currentQuestionInRond++;
            s.setState(State.SERVERSENTANSWER);
=======
    protected Session getInitialSession() {
        return new Session(numberOfSubjects, numberOfQuestions, numberOfRounds);
    }
>>>>>>> master

    protected Session processSession(Session session) {
        gameState = session.getGameState();
        switch (gameState) {
            case LOADGAME:
                session.setAllSubjects(allSubjects);
                session.setAllQuestions(allQuestions);

                session.setGameState(FIRST);
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
<<<<<<< HEAD

}
=======
}
>>>>>>> master
