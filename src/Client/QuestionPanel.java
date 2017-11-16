package Client;

<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class QuestionPanel extends JPanel{
    
    Label answer1, answer2, answer3, answer4, question;
    JButton giveUp;
    Color backgroundColor;
    

    
    
    public QuestionPanel(Label answer1, Label answer2, Label answer3, Label answer4, Label question, JButton giveUp, Color backgroundColor) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.giveUp = giveUp;
        this.backgroundColor = backgroundColor;
    }

    public QuestionPanel() {
    }
    
    
    
   public void setPanel(){
       JPanel panel = new JPanel();
       JPanel questionpanel = new JPanel();
       panel.setLayout(new BorderLayout());
       questionpanel.setLayout(new GridLayout(2,2));
       
       questionpanel.add(answer1);
       questionpanel.add(answer2);
       questionpanel.add(answer3);
       questionpanel.add(answer4);
       
       
       
       panel.add("Center", questionpanel);
       panel.add("North", question);
       panel.add("South", giveUp);
       
       panel.setBackground(backgroundColor);
    }
   
  
       
       
       
       
   }

    
  
    
    
    
    
    

=======
import javax.swing.*;

    class QuestionPanel extends JPanel {
}
>>>>>>> Jakob
