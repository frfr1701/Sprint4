package Client;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Domain.*;
import java.util.List;

public class ResultPanel extends JPanel {

    private final Color backgroundColor;
    private final Color redColor;
    private final Color greenColor;

    private final Session session;
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel p3;
    private final JLabel v1;
    private final JLabel v2;
    private final JTextField f1;
    private List<Boolean> one;
    private List<Boolean> two;
    private final JButton[] bplayer1;
    private final JButton[] bplayer2;

    protected JButton exitGame;

    protected ResultPanel(ActionListener al, Session gameSession) {
        session = gameSession;

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        v1 = new JLabel("You");
        v2 = new JLabel("Him");
        f1 = new JTextField();
        exitGame = new JButton("Avsluta");
        bplayer1 = new JButton[session.getNumberOfRounds() * session.getNumberOfQuestions()];
        bplayer2 = new JButton[session.getNumberOfRounds() * session.getNumberOfQuestions()];
        exitGame.addActionListener(al);

        greenColor = new Color(131, 202, 57);
        redColor = new Color(210, 45, 45);
        backgroundColor = new Color(20, 134, 186);
    }

    protected void setPanel() {
        setBorder(BorderFactory.createLineBorder(backgroundColor, 10));
        setLayout(new BorderLayout());

        for (int i = 0; i < bplayer1.length; i++) {
            bplayer1[i] = new JButton();
            bplayer2[i] = new JButton();
            bplayer1[i].setBackground(backgroundColor);
            bplayer2[i].setBackground(backgroundColor);
            bplayer1[i].setOpaque(true);
            bplayer2[i].setOpaque(true);
        }
        if (session.isWhichPlayer()) {
            one = session.getResultPlayer1();
            two = session.getResultPlayer2();
            SetScoreAndSetWinnerInTheEnd();
        } else {
            one = session.getResultPlayer2();
            two = session.getResultPlayer1();
            SetScoreAndSetWinnerInTheEnd();
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
        p1.add(f1, BorderLayout.CENTER);
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
            p2.add(new Label("Round " + (i + 1), Label.CENTER));
            for (int j = 0; j < session.getNumberOfQuestions(); j++) {
                p2.add(bplayer2[player2++]);
            }
        }
        add("Center", p2);

        p3.add(exitGame);
        add("South", p3);
    }

    private void SetScoreAndSetWinnerInTheEnd() {
        f1.setText(one.stream().filter(current -> current.equals(true)).count()
                + " - " + two.stream().filter(current -> current.equals(true)).count());
        if (session.getGameState() == State.GAMECOMPLETE) {
            if (one.stream().filter(current -> current.equals(true)).count()
                    > two.stream().filter(current -> current.equals(true)).count()) {
                v1.setText("(Winner) You");
                v2.setText("Him (Looser) ");
            } else if (one.stream().filter(current -> current.equals(true)).count()
                    < two.stream().filter(current -> current.equals(true)).count()) {
                v1.setText("(Looser) You");
                v2.setText("Him (Winner) ");
            } else {
                v1.setText("(Draw) You");
                v2.setText("Him (Draw)");
            }
        }
    }
}
