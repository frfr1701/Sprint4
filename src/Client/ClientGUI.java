package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Ian
 */
public class ClientGUI extends JFrame implements ActionListener {
    
    String filepath = "/Users/Ian/Desktop/test/export.png";
    ImageIcon logo = new ImageIcon(filepath);
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel btn1 = new JPanel();
    JPanel btn2 = new JPanel();
    JPanel btn3 = new JPanel();
    JPanel btn4 = new JPanel();
    JButton question = new JButton(logo);
    JButton giveUp = new JButton("Ge upp");
    List<JPanel> listpanel = new ArrayList<>();
    
    ClientGUI(){
       giveUp.setFont(new Font("Sanserif", Font.PLAIN, 20));
       giveUp.addActionListener(this);
       listpanel.add(btn1);
       listpanel.add(btn2);
       listpanel.add(btn3);
       listpanel.add(btn4);
        
        
        for (JPanel answers : listpanel) {
            answers.addMouseListener(ma);
            panel.add(answers);
        }
     
        panel.setLayout(new GridLayout(2,2));
        setVisible(true);
        setSize(800, 600);
        panel2.setLayout(new BorderLayout());
        panel2.add("Center", panel);
        panel2.add("North", question);
        panel2.add("South", giveUp);
        add(panel2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    

    
        
     
                
    }
        public void shuffle(List<JPanel> answers, JPanel panel) {
        Collections.shuffle(answers);
        for (JPanel a : answers) {
            panel.add(a);
        }
        panel.revalidate();
        panel.repaint();
    }
    
   
    
    public static void main(String[] args) {
        ClientGUI m = new ClientGUI();
        
    }
    MouseAdapter ma = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
           
                    if (e.getSource() == btn1) 
                        btn1.setBackground(Color.GREEN);
                    if (e.getSource() == btn2)
                        btn2.setBackground(Color.GREEN);
                    if (e.getSource() == btn3)
                        btn3.setBackground(Color.GREEN);
                    if (e.getSource() == btn4)
                        btn4.setBackground(Color.GREEN);
                     
                    
                }
            
     @Override
     public void mouseReleased(MouseEvent e) {
             
                    if (e.getSource() == btn1) 
                        btn1.setBackground(Color.white);
                    if (e.getSource() == btn2)
                        btn2.setBackground(Color.white);
                    if (e.getSource() == btn3)
                        btn3.setBackground(Color.white);
                    if (e.getSource() == btn4)
                        btn4.setBackground(Color.white);
                        
        }                 
    };
    
    public void actionPerformed(ActionEvent ae){
        
        JButton pushed = (JButton) ae.getSource();
        
        if(giveUp == pushed){
            System.exit(0);
                         
        }
        
        
        
        
        
        
    }
    
}
            

    
    
    


         
                 

    
    
            
    

