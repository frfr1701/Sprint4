package Client;

import Domain.Session;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

<<<<<<< HEAD
public class GamePanel extends Client implements ActionListener {

    ColorSettingPanel csp;
=======
class GamePanel extends Client implements ActionListener {

>>>>>>> master
    StartPanel sp;
    CategoryPanel cp;
    QuestionPanel qp;
    ResultPanel rp;
<<<<<<< HEAD
    List<IPanel> panelList;
    Color standardColor = new Color(238, 238, 238);
    Color backgroundColor = new Color(175, 175, 200);
    int correctAnswer;

    public GamePanel() {

        csp = new ColorSettingPanel(this);
        sp = new StartPanel(this);
        qp = new QuestionPanel(ma);
        rp = new ResultPanel();
        cp = new CategoryPanel(this);
    }

    public void setPanel() {

        setTitle("VÄRLDENS BÄSTA QUIZ!");
        setSize(450, 550);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        add(sp);
        sp.setPanel();

        revalidate();
        repaint();

        panelList = new ArrayList<>();
        panelList.add(sp);
        panelList.add(cp);
        panelList.add(csp);
        panelList.add(qp);
        panelList.add(rp);

        panelList.forEach(p -> {
            p.setPanel();
        });

    }
    public static void main(String[] args) {
        GamePanel g = new GamePanel();
        g.setPanel();
    }

    MouseListener ma = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {

            if (e.getSource() == qp.answer1) {
                if (1 == 1) {
                    qp.answer1.setBackground(Color.GREEN);
                } else {
                    qp.answer1.setBackground(Color.RED);
                }

            }
            if (e.getSource() == qp.answer2) {

                if (1 == 1) {
                    qp.answer2.setBackground(Color.GREEN);
                } else {
                    qp.answer2.setBackground(Color.RED);
                }

            }
            if (e.getSource() == qp.answer3) {
                if (1 == 2) {
                    qp.answer3.setBackground(Color.GREEN);
                } else {
                    qp.answer3.setBackground(Color.RED);
                }

            }
            if (e.getSource() == qp.answer4) {

                if (1 == 1) {
                    qp.answer4.setBackground(Color.GREEN);
                } else {
                    qp.answer4.setBackground(Color.RED);
                }

            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {

            if (e.getSource() == qp.answer1) {

                qp.answer1.setBackground(standardColor);
            }
            if (e.getSource() == qp.answer2) {

                qp.answer2.setBackground(standardColor);

            }
            if (e.getSource() == qp.answer3) {

                qp.answer3.setBackground(standardColor);

            }
            if (e.getSource() == qp.answer4) {

                qp.answer4.setBackground(standardColor);

            }

        }

    };
=======
    JFrame mastern;
    public GamePanel() {
        this.mastern = new JFrame();
        this.sp = new StartPanel(this);
        this.qp = new QuestionPanel();
        this.rp = new ResultPanel();
    }

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
>>>>>>> master

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sp.newGame) {
<<<<<<< HEAD
            remove(sp);
            add(cp);
            cp.setPanel();
            

        } else if (ae.getSource() == sp.exitGame || ae.getSource() == cp.exitGame) {
=======
            mastern.remove(sp);
            mastern.add(qp);
        }
        if (ae.getSource() == sp.exitGame) {
>>>>>>> master
            System.exit(0);
        } else if (ae.getSource() == cp.goBack) {
            remove(cp);
            add(sp);
            sp.setPanel();
        } else if (ae.getSource() == cp.category1) {
            remove(cp);
            add(qp);
            qp.setPanel();
        } else if (ae.getSource() == cp.category1) {
            remove(cp);
            add(qp);
            qp.setPanel();
        } else if (ae.getSource() == cp.category3) {
            remove(cp);
            add(qp);
            qp.setPanel();
        } else if (ae.getSource() == sp.settings) {
            remove(sp);
            add(csp);
            csp.setPanel();
        } else if (ae.getSource() == csp.black) {
            panelList.forEach(p -> p.setColor(Color.BLACK));
        } else if (ae.getSource() == csp.yellow) {
            panelList.forEach(p -> p.setColor(Color.YELLOW));
        } else if (ae.getSource() == csp.red) {
            panelList.forEach(p -> p.setColor(Color.RED));
        } else if (ae.getSource() == csp.standard) {
            panelList.forEach(p -> p.setColor(backgroundColor));
        } else if (ae.getSource() == csp.goBack) {
            remove(csp);
            add(sp);
            sp.setPanel();
        }
<<<<<<< HEAD
        revalidate();
        repaint();
=======
        mastern.revalidate();
        mastern.repaint();
>>>>>>> master

    }
}
