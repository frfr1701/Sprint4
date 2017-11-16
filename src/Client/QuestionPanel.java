package Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    class QuestionPanel extends JPanel {
        Label question = new Label("Hur många länder finns det i världen?", Label.CENTER);
        Label answer1 = new Label("Svar 1", Label.CENTER);
        Label answer2 = new Label("Svar 2", Label.CENTER);
        Label answer3 = new Label("Svar 3", Label.CENTER);
        Label answer4 = new Label("Svar 4", Label.CENTER);
        JPanel panel = new JPanel();
        

    public QuestionPanel(MouseListener ma) {
        
        answer1.addMouseListener(ma);
        answer2.addMouseListener(ma);
        answer3.addMouseListener(ma);
        answer4.addMouseListener(ma);
    }
    
    public void setPanel(){
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(2,2));
        add("North", question);
        add("Center", panel);
        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
        
        
        
    }

   
        
}
