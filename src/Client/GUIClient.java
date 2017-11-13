package Client;

import java.awt.FlowLayout;
import javax.swing.*;

public class GUIClient extends JFrame {
JFrame f =new JFrame ("QuizKampen");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4= new JPanel();
    
    
    JButton b1 =new JButton();
      JButton b2 =new JButton();
        JButton b3 =new JButton();
        
          JButton b4 =new JButton();
          JButton b5 =new JButton();
            JButton b6 =new JButton();
             
          
    GUIClient() {
        
 p1.setLayout(new FlowLayout());
 p1.add(b1);
  p1.add(b2);
   p1.add(b3);
  
    p1.add(b4);
     p1.add(b5);
      p1.add(b6);
 
       f. add(p1);
        pack();
        setSize(300, 300);
        setLocation(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        

    }

    public static void main(String[] args) {
GUIClient  d  =new GUIClient();
    }

}
