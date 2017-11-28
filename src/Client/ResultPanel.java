package Client;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Domain.Session;
import java.util.List;

public class ResultPanel extends JPanel{

    private final Session session;
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JLabel v1 = new JLabel("Jag                                    ");
    JLabel v2 = new JLabel("                     Motståndare");
    JTextField f1 = new JTextField();
    Color backgroundColor = new Color(20, 134, 186);
    Color redColor = new Color(210,45,45);
    Color greenColor = new Color(131, 202, 57);
    JButton exitGame = new JButton("Avsluta");
    List<Boolean> one;
    List<Boolean> two;
    JButton[] bplayer1;
    JButton[] bplayer2;
 
    protected ResultPanel(ActionListener al, Session session) {
        this.session = session;
        exitGame.addActionListener(al);
        bplayer1 = new JButton[session.getNumberOfRounds() * session.getNumberOfQuestions()];
        bplayer2 = new JButton[session.getNumberOfRounds() * session.getNumberOfQuestions()];
    }

    protected void setPanel() {
        setBorder(BorderFactory.createLineBorder(backgroundColor, 10));
        setLayout(new BorderLayout());

        for (int i = 0; i < bplayer1.length; i++) {
            bplayer1[i] = new JButton();
            bplayer2[i] = new JButton();
            bplayer1[i].setBackground(backgroundColor);
            bplayer2[i].setBackground(backgroundColor);
        }
        if (session.isWhichPlayer()) {
            one = session.getResultPlayer1();
            two = session.getResultPlayer2();
            f1.setText(session.getResultPlayer1().stream().filter(current -> current.equals(true)).count()
                    + " - " + session.getResultPlayer2().stream().filter(current -> current.equals(true)).count());
        } else {
            two = session.getResultPlayer1();
            one = session.getResultPlayer2();
            f1.setText(session.getResultPlayer2().stream().filter(current -> current.equals(true)).count()
                    + " - " + session.getResultPlayer1().stream().filter(current -> current.equals(true)).count());
        }

        for (int i = 0; i < one.size(); i++) {
            if (one.get(i)) {
                bplayer1[i].setBackground(greenColor);
            } else {
                bplayer1[i].setBackground(redColor);
            }
        }
        for (int i = 0; i < two.size(); i++) {
            if (two.get(i)) {
                bplayer2[i].setBackground(greenColor);
            } else {
                bplayer2[i].setBackground(redColor);
            }
        }
       
        v1.setForeground(Color.white);
        v2.setForeground(Color.white);
        p1.add(v1);
        p1.add(f1);
        f1.setEditable(false);
        p1.add(v2);
        p1.setBackground(backgroundColor);
        p1.setBorder(BorderFactory.createLineBorder(backgroundColor, 20));
        add("North", p1);

        p2.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(session.getNumberOfRounds(), session.getNumberOfQuestions() * 2 + 1));
        p2.setBackground(backgroundColor);
        p3.setBackground(backgroundColor);
        p3.setBorder(BorderFactory.createLineBorder(backgroundColor, 20));
        int player1 = 0;
        int player2 = 0;
        for (int i = 0; i < session.getNumberOfRounds(); i++) {
            for (int j = 0; j < session.getNumberOfQuestions(); j++) {
                p2.add(bplayer1[player1++]);
            }
            p2.add(new Label("Round " + (i + 1), Label.CENTER ));
            for (int j = 0; j < session.getNumberOfQuestions(); j++) {
                p2.add(bplayer2[player2++]);
            }
        }
        add("Center", p2);

        p3.add(exitGame);
        add("South", p3);
    }
}
