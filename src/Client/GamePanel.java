package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Ian
 */
public class QuestionBoard extends JFrame implements ActionListener {
    
    String filepath = "/Users/Ian/Desktop/test/export.png";
    ImageIcon logo = new ImageIcon(filepath);
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    Label answer1 = new Label("Fråga 1", Label.CENTER);
    Label answer2 = new Label("Fråga 2", Label.CENTER);
    Label answer3 = new Label("Fråga 3", Label.CENTER);
    Label answer4 = new Label("Fråga 4", Label.CENTER);
    JButton question = new JButton("EN SVÅR FRÅGA");
    JButton giveUp = new JButton("Ge upp");
    
    
    QuestionBoard(){
        question.setFont(new Font("Arial", Font.PLAIN, 20));
        answer1.addMouseListener(ma);
        answer2.addMouseListener(ma);
        answer3.addMouseListener(ma);
        answer4.addMouseListener(ma);
        giveUp.addActionListener(this);
        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
        panel.setLayout(new GridLayout(2,2));
        setVisible(true);
        setSize(500, 400);
        panel2.setLayout(new BorderLayout());
        Color lightBlue = new Color(175, 175, 255);
        panel2.setBackground(lightBlue);
        panel2.setOpaque(false);
        
        
        
        panel2.add("Center", panel);
        panel2.add("North", question);
        panel2.add("South", giveUp);
        add(panel2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       answer1.addMouseListener(ma);
       answer2.addMouseListener(ma);
       answer3.addMouseListener(ma);
       answer4.addMouseListener(ma);
                
    }
    
    public static void main(String[] args) {
        QuestionBoard m = new QuestionBoard();
    }
    
    
    
    
    
    
    MouseAdapter ma = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
           
                    if (e.getSource() == answer1) {
                        answer1.setBackground(Color.GREEN);
                    }
                    if (e.getSource() == answer2){
                        answer2.setBackground(Color.GREEN);
                    }
                    if (e.getSource() == answer3){
                        answer3.setBackground(Color.GREEN);
                    }
                    if (e.getSource() == answer4){
                        answer4.setBackground(Color.GREEN);
                    }
                     
                    
                }
            
        public void mouseReleased(MouseEvent e) {
             
                    if (e.getSource() == answer1) {
                        answer1.setBackground(Color.WHITE);
                    }
                    if (e.getSource() == answer2){
                        answer2.setBackground(Color.WHITE);
                    }
                    if (e.getSource() == answer3){
                        answer3.setBackground(Color.WHITE);
                    }
                    if (e.getSource() == answer4){
                        answer4.setBackground(Color.WHITE);
                    } 
                       
        }                 
    };
    
    public void actionPerformed(ActionEvent ae){
        
        JButton pushed = (JButton) ae.getSource();
        
        if(giveUp == pushed){
            System.exit(0);
                         
        }
        
        
        
        
        
        
    }
    
}
    

            

    
    
    


         
                 

    
    
            
    

