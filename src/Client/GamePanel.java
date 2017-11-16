package Client;

<<<<<<< HEAD
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
public class GamePanel extends JFrame implements ActionListener {
    Label question = new Label("Fråga");
    Label answer1 = new Label("svar 1", Label.CENTER);
    Label answer2 = new Label("svar 2", Label.CENTER);
    Label answer3 = new Label("svar 3", Label.CENTER);
    Label answer4 = new Label("svar 3", Label.CENTER);
    JButton giveUp = new JButton("Ge upp");
    JButton startGame = new JButton("Start game yo");
    ImageIcon logo = new ImageIcon("/Users/Ian/Desktop/test");
    JButton team = new JButton(logo);
    
    
    private final Color backgroundColor = new Color(175, 175, 255);
    StartMenu sm;
    QuestionPanel qp;
    ResultPanel rp;
    
    
    
   public GamePanel(){
        
        rp = new ResultPanel(backgroundColor);
        qp = new QuestionPanel(answer1, answer2, answer3, answer4, question, giveUp, backgroundColor);
        sm = new StartMenu(startGame, backgroundColor, team);
        
        
    
    }
    
    public void setGameFrame(){
        setTitle("SUPERQUIZ");
        setSize(750, 500);
        setVisible(true);
        //setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        answer1.addMouseListener(ma);
        answer2.addMouseListener(ma);
        answer3.addMouseListener(ma);
        answer4.addMouseListener(ma);
        JPanel hej = new JPanel();
        hej.add(new JLabel("suo"));
        add(hej);
        add(sm, BorderLayout.CENTER);
        pack();
        
        
        
                
        
        
    }
    
    public static void main(String[] args) {
        GamePanel mmm = new GamePanel();
        mmm.setGameFrame();
        
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
            
        @Override
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
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        JButton pushed = (JButton) ae.getSource();
        
        if (ae.getSource() == sm.startGame) {
            remove(sm);
            add(qp);
        
        
        if(pushed == giveUp){
            System.exit(0);
        }
        revalidate();
        repaint();
        
        
        
    }
    }
}
   
    

  
    

    

            

    
    
    


         
                 

    
    
            
    

=======
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JFrame implements ActionListener {
    StartPanel sp;
    QuestionPanel qp;
    ResultPanel rp;

   public GamePanel() {
        this.sp = new StartPanel(this);
        this.qp = new QuestionPanel();
        this.rp = new ResultPanel();
    }
    
   public void setPanel(){
        setSize(350, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        add(sp);
        sp.setPanel();
        
        
        revalidate();
        repaint();
        
   }
    
   
   public static void main(String[] args) {
        GamePanel go = new GamePanel();
        go.setPanel();
    }
    
   
   @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sp.newGame) {
            remove(sp);
            this.add(qp);
        }
        if (ae.getSource() == sp.exitGame){
            System.exit(0);
        }
        repaint();
        
    }
}
>>>>>>> Jakob
