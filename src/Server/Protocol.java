package Server;

import Domain.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Protocol {
    QuestionReader qr = new QuestionReader();
    String [] rond = getQuestions();    //Skickar in 3 frågor
    //private static final int NUMRIDDLES = 3;
    
    
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
       questions.add(fråga1Test);
       questions.add(fråga2Test);
   }
   
    
    public Session getInitialSession(){
        return new Session("ttt");
    }
    
    public Session processInput(Session s) {
        State state = s.getState();
        System.out.println("Server: "+ state);
        
        //There should be error handling for SERVERSENTQUESTION state
        if (state == State.WAITING){
            //Randomisera kategorinamn och spara ner 3 i array o skicka över till klienten
            if(s.getwhatCategory().equalsIgnoreCase(rondCategoryTest[0])){    //Klienten kommer välja kategory och setta setwhatCategory
               //randomizeQuestions(gr.getQuestion());
                randomizeQuestions(questions);
                // metod som randomiserar array med ämnet
                s.setState(State.SERVERSENTCATEGORYQUESTION);
            } else if(s.getwhatCategory().equalsIgnoreCase(rondCategoryTest[1])){
                
                //setcategory till jakob
                s.setState(State.SERVERSENTCATEGORYQUESTION);
            } else if(s.getwhatCategory().equalsIgnoreCase(rondCategoryTest[2])) {
               
                //setcategory till jakob
                s.setState(State.SERVERSENTCATEGORYQUESTION);
            }
         
        } else if(state == State.SERVERSENTCATEGORYQUESTION || state == State.SERVERSENTANSWER) {
              s.setQuestion(questions.get(currentQuestionInRond)[question]);
              s.setState(State.SERVERSENTQUESTION);
            
        } else if (state == State.CLIENTCLICKEDANSWER) {
            if (s.getAnswer().equalsIgnoreCase(matte[currentQuestionInRond][correctAnswer])) {
                s.setVerdict(true);
                s.addScoreRond();
                s.addScoreTotal();
            } else {
                s.setVerdict(false);
            }
            s.setState(State.SERVERSENTANSWER);
            currentQuestionInRond++;
            




//SKA egenetligen randomiseras
           // efter rondens slut ska rond scoren reseta s.resetScoreRond();
        }
        return s;
    }
    
    public List randomizeQuestions(List questions){
        return questions;
    }

}