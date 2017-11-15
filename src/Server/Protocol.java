package Server;

import Domain.*;
import static Domain.State.SERVERSENTANSWER;
import Server.config.Config;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Protocol {

    QuestionReader qr;
    Config c;


    List<String[]> questionsRondTemp = new ArrayList<>();
    List<String> subjectsRondTemp = new ArrayList<>();
    // String [][] matte = {fråga1Test, fråga2Test};
    private int category = 0;
    private int question = 1;
    private int correctAnswer = 2;
    private int currentQuestionInRond = 0;
    private int currentRond = 0;
    

    Protocol() throws IOException {
        c = new Config();
        qr = new QuestionsAndSubjects(c.getQuestionsPerRound(), 2);
        
    }

    public Session getInitialSession() {
        //subjectsRondTemp = qr.getSubjects();
        return new Session("Vill du starta nytt spel J");
    }

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

            if (s.getwhatSubject().equalsIgnoreCase(subjectsRondTemp.get(0))) {    //Klienten kommer välja kategory och setta setwhatCategory

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

        } else if (state == State.ANOTHERQUESTION) { 
            if(currentQuestionInRond == c.getQuestionsPerRound()){ // 4an ska bytas ut mot getter av antal valda frågor
               currentQuestionInRond = 0;
               s.addRond();
               if (s.getRond() == c.getNumberOfRounds()){
                 s.setState(State.FINISHEDGAME);
                 s.resetRond();
               } else {
                 s.setState(State.RESULTSCREEN);
               }
            }else {
               s.setQuestion(questionsRondTemp.get(currentQuestionInRond)[question]);
               s.setState(State.SERVERSENTQUESTION);
            } 
        }
        return s;
    }

}
