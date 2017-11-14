package Server;

import Domain.*;
import static Domain.State.SERVERSENTANSWER;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Protocol {
    QuestionReader qr = new QuestionReader();
    String [] threeSubjects;
    
    String [] fråga1Test = {"Matte", "Vad är 1 + 1", "2", "1100", "1010", "90098"};
    String [] fråga2Test = {"Matte", "Vad är 3 + 1", "4", "1100", "1010", "90098"};
    String [] rondCategoryTest = {"historia", "teknik", "matte"};
    
    List<String[]> questions = new ArrayList<>();
   // String [][] matte = {fråga1Test, fråga2Test};
    private int category = 0;
    private int question = 1;
    private int correctAnswer= 2;
    
    private int currentQuestionInRond = 0;
     private int randomQuestion = 0; 
     
    Protocol(){
       
    }

    
    public Session getInitialSession(){
        return new Session(rondCategoryTest); //här ska array av 3 ämnen ksickas in
    }
    
    public Session processInput(Session s) {
        State state = s.getState();
        System.out.println("Server: "+ state);
        System.out.println(questions.get(currentQuestionInRond)[question]);
        
        //There should be error handling for SERVERSENTQUESTION state
        if (state == State.WAITING ){
             s.setSubjectChoices(rondCategoryTest);
            //randomizeCategories(qr.getSubjects())
            //Randomisera kategorinamn och spara ner 3 i array o skicka över till klienten
             //s.setWhatSubject();  
            s.setState(State.SERVERSENTWHATCATEGORYQUESTION);
            
        }else if (state == State.CLIENTPICKEDSUBJECT) { 
            System.out.println("Klienten: valde " + s.getwhatSubject());
            if(s.getwhatSubject().equalsIgnoreCase(rondCategoryTest[0])){    //Klienten kommer välja kategory och setta setwhatCategory
                System.out.println("Klienten valde " + rondCategoryTest[0]);
                questions = qr.getQuestions();
                s.setQuestion(questions.get(currentQuestionInRond)[question]);
                s.setState(State.SERVERSENTQUESTION);
            } else if(s.getwhatSubject().equalsIgnoreCase(rondCategoryTest[1])){
                System.out.println("Klienten valde " + rondCategoryTest[1]);
                questions= qr.getQuestions();
                s.setQuestion(questions.get(currentQuestionInRond)[question]);
                s.setState(State.SERVERSENTQUESTION);
            } else if(s.getwhatSubject().equalsIgnoreCase(rondCategoryTest[2])) {
                System.out.println("Klienten valde " + rondCategoryTest[2]);
                questions = qr.getQuestions();
                s.setQuestion(questions.get(currentQuestionInRond)[question]);
                s.setState(State.SERVERSENTQUESTION);
            }
         
        } else if (state == State.CLIENTCLICKEDANSWER) {
            if (s.getAnswer().equalsIgnoreCase(questions.get(currentQuestionInRond)[correctAnswer])) {
                s.setVerdict(true);
                s.addScoreRond();
                s.addScoreTotal();
            } else {
                s.setVerdict(false);
            }
            currentQuestionInRond++;
            s.setState(State.SERVERSENTANSWER);
            
            
        
        }
        return s;
    }
//    public String [] randomizeCategories(String [] subjects){
  
//      threeSubjects
//        
//    }
    
//    public List randomizeQuestions(List questions){
//        Collections.shuffle(questions);
//        return questions;
//    }

}