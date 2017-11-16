package Client;

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
        setSize(200,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        add(sp);
        pack();
        
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
    }
}
