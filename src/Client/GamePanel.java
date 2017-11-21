package Client;

import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends Client implements ActionListener {

    StartPanel sp;
    QuestionPanel qp;
    ResultPanel rp;
    JFrame mastern;
    public GamePanel() {
        this.mastern = new JFrame();
        this.sp = new StartPanel(this);
        this.qp = new QuestionPanel();
        this.rp = new ResultPanel();
    }

    @Override
    public void setPanel() {
        mastern.setSize(350, 400);
        mastern.setVisible(true);
        mastern.setLocationRelativeTo(null);
        mastern.setDefaultCloseOperation(3);
        mastern.add(sp);
        sp.setPanel();

        mastern.revalidate();
        mastern.repaint();

    }

    public static void main(String[] args) {
        GamePanel go = new GamePanel();
        go.setPanel();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sp.newGame) {
            mastern.remove(sp);
            mastern.add(qp);
        }
        if (ae.getSource() == sp.exitGame) {
            System.exit(0);
        }
        mastern.revalidate();
        mastern.repaint();

    }
}
