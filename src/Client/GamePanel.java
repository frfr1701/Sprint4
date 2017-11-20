package Client;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JFrame implements ActionListener {

    StartPanel sp;
    QuestionPanel qp;
    ResultPanel rp;
    Color background = new Color(238, 238, 238);

    public GamePanel() {
        this.sp = new StartPanel(this);
        this.qp = new QuestionPanel(ma);
        this.rp = new ResultPanel();
    }

    public void setPanel() {
        setSize(450, 550);
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
    MouseListener ma = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {

            if (e.getSource() == qp.answer1) {

                qp.answer1.setBackground(Color.GREEN);
            }
            if (e.getSource() == qp.answer2) {
                
                qp.answer2.setBackground(Color.GREEN);

            }
            if (e.getSource() == qp.answer3) {
               
                qp.answer3.setBackground(Color.GREEN);

            }
            if (e.getSource() == qp.answer4) {
                
                qp.answer4.setBackground(Color.GREEN);

            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {

            if (e.getSource() == qp.answer1) {

                qp.answer1.setBackground(background);
            }
            if (e.getSource() == qp.answer2) {
                
                qp.answer2.setBackground(background);

            }
            if (e.getSource() == qp.answer3) {
                
                qp.answer3.setBackground(background);

            }
            if (e.getSource() == qp.answer4) {
                
                qp.answer4.setBackground(background);

            }

        }

    };

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sp.newGame) {
            remove(sp);
            this.add(qp);
            qp.setPanel();
            revalidate();
            repaint();
        }
        if (ae.getSource() == sp.exitGame) {
            System.exit(0);
        }
        repaint();

    }
}
