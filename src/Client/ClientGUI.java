package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    
    ClientGUI(){
        
        btn1.addMouseListener(ma);
        btn2.addMouseListener(ma);
        btn3.addMouseListener(ma);
        btn4.addMouseListener(ma);
        giveUp.addActionListener(this);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.setLayout(new GridLayout(2,2));
        setVisible(true);
        setSize(800, 600);
        panel2.setLayout(new BorderLayout());
        
        
        panel2.add("Center", panel);
        panel2.add("North", question);
        panel2.add("South", giveUp);
        add(panel2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       btn1.addMouseListener(ma);
       btn2.addMouseListener(ma);
       btn3.addMouseListener(ma);
       btn4.addMouseListener(ma);
                
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
            
     public void mouseReleased(MouseEvent e) {
             
                    if (e.getSource() == btn1) 
                        btn1.setBackground(Color.BLACK);
                    if (e.getSource() == btn2)
                        btn2.setBackground(Color.BLACK);
                    if (e.getSource() == btn3)
                        btn3.setBackground(Color.BLACK);
                    if (e.getSource() == btn4)
                        btn4.setBackground(Color.BLACK);
                        
        }                 
    };
    
    public void actionPerformed(ActionEvent ae){
        
        JButton pushed = (JButton) ae.getSource();
        
        if(giveUp == pushed){
            System.exit(0);
                         
        }
        
        
        
        
        
        
    }
    
}
            

    
    
    


         
                 

    
    
            
    

