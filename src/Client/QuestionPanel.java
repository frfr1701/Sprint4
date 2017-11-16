package Client;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class QuestionPanel extends JPanel{
    
    Label answer1, answer2, answer3, answer4;
    JButton giveUp;
    Color backgroundColor;
    

    
    
    public QuestionPanel(Label answer1, Label answer2, Label answer3, Label answer4, JButton giveUp, Color backgroundColor) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.giveUp = giveUp;
        this.backgroundColor = backgroundColor;
    }
    
    
   public void setPanel(){
       
       JPanel questionpanel = new JPanel();
       questionpanel.setLayout(new GridLayout(2,2));
       
       
       
       
       
       
       
       
        
    }

    
  
    
    
    
    
    
}
