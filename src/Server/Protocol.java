package Server;

import Domain.*;
import static Domain.State.SERVERSENTANSWER;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Protocol {
    QuestionReader qr = new QuestionsAndSubjects(4, 3);
    
    List<String[]> questionsRondTemp = new ArrayList<>();
    List<String> subjectsRondTemp = new ArrayList<>();
   // String [][] matte = {fråga1Test, fråga2Test};
    private int category = 0;
    private int question = 1;
    private int correctAnswer= 2;
    private int currentQuestionInRond = 0;
    private int randomQuestion = 0; 
     
    Protocol(){
       
    }

    
    public Session getInitialSession(){
        subjectsRondTemp = qr.getSubjects();
        return new Session(subjectsRondTemp); 
    }
    
    public Session processInput(Session s) {
        State state = s.getState();
        System.out.println("Server: "+ state);
    
        s.setState(State.SERVERSENTWHATCATEGORYQUESTION);
            
         if (state == State.CLIENTPICKEDSUBJECT) { 
          
            if(s.getwhatSubject().equalsIgnoreCase(subjectsRondTemp.get(0))){    //Klienten kommer välja kategory och setta setwhatCategory
                
                System.out.println("Klienten valde " + subjectsRondTemp.get(0));
                questionsRondTemp= qr.getQuestions(subjectsRondTemp.get(0));
                s.setquestionsInARond(questionsRondTemp);
                s.setQuestion(questionsRondTemp.get(currentQuestionInRond)[question]);
               
                 
            } else if(s.getwhatSubject().equalsIgnoreCase(subjectsRondTemp.get(1))){
                
                System.out.println("Klienten valde " + subjectsRondTemp.get(1));
                questionsRondTemp= qr.getQuestions(subjectsRondTemp.get(1));
                s.setquestionsInARond(questionsRondTemp);
                s.setQuestion(questionsRondTemp.get(currentQuestionInRond)[question]);
               
                
            } else if(s.getwhatSubject().equalsIgnoreCase(subjectsRondTemp.get(2))) {
                
                System.out.println("Klienten valde " + subjectsRondTemp.get(2));
                questionsRondTemp= qr.getQuestions(subjectsRondTemp.get(2));
                s.setquestionsInARond(questionsRondTemp);
                s.setQuestion(questionsRondTemp.get(currentQuestionInRond)[question]);
               
            }
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
            
         } else if(state == State.ANOTHERQUESTION){ //längd på listan?
            s.setQuestion(questionsRondTemp.get(currentQuestionInRond)[question]);
            s.setState(State.SERVERSENTQUESTION);
             
         }
        return s;
    }
//    public String [] randomizeCategories(String [] subjects){
  
//      threeSubjects
//        
//    }
    
//    public List randomizeQuestions(List questionsRondTemp){
//        Collections.shuffle(questionsRondTemp);
//        return questionsRondTemp;
//    }

}