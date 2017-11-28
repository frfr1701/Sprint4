package Client;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Domain.Session;
import java.util.List;

public class ResultPanel extends JPanel{

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    JPanel p5 = new JPanel();
    JLabel v1 = new JLabel("                    Du");
    JLabel v2 = new JLabel("Motståndare");
    JTextField f1 = new JTextField();
    Color backgroundColor;
    boolean buttonEnable = false;

    JButton exitGame = new JButton("Avsluta");
    private final Session session;
    List<Boolean> one;
    List<Boolean> two;

    protected ResultPanel(ActionListener al, Session session) {
        exitGame.addActionListener(al);
        this.session = session;
    }

    protected void setPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLUE, 10));
        setLayout(new BorderLayout());

        JButton[] bplayer1 = new JButton[session.getNumberOfRounds() * session.getNumberOfQuestions()];
        JButton[] bplayer2 = new JButton[session.getNumberOfRounds() * session.getNumberOfQuestions()];
        for (int i = 0; i < bplayer1.length; i++) {
            bplayer1[i] = new JButton();
            bplayer2[i] = new JButton();
            bplayer1[i].setBackground(Color.BLUE);
            bplayer2[i].setBackground(Color.BLUE);
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
                bplayer1[i].setBackground(Color.GREEN);
            } else {
                bplayer1[i].setBackground(Color.RED);
            }
        }
        for (int i = 0; i < two.size(); i++) {
            if (two.get(i)) {
                bplayer2[i].setBackground(Color.GREEN);
            } else {
                bplayer2[i].setBackground(Color.RED);
            }
        }
        p1.add(v1);
        p1.add(f1);
        f1.setEditable(false);
        p1.add(v2);
        p1.setBackground(Color.BLUE);
        add("North", p1);

        p2.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(session.getNumberOfRounds(), session.getNumberOfQuestions() * 2 + 1));
        p2.setBackground(Color.BLUE);
        p3.setBackground(Color.BLUE);
        int player1 = 0;
        int player2 = 0;
        for (int i = 0; i < session.getNumberOfRounds(); i++) {
            for (int j = 0; j < session.getNumberOfQuestions(); j++) {
                p2.add(bplayer1[player1++]);
            }
            p2.add(new Label("Round " + (i + 1), Label.CENTER));
            for (int j = 0; j < session.getNumberOfQuestions(); j++) {
                p2.add(bplayer2[player2++]);
            }
        }
        add("Center", p2);

        p3.add(exitGame);
        add("South", p3);
    }
}
