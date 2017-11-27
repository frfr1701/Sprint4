package Client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ResultPanel extends JPanel implements IPanel {

   JPanel p1 = new JPanel();
   JPanel p2 = new JPanel();
   JPanel p3 = new JPanel();

   JPanel p5 = new JPanel();
   JLabel v1 = new JLabel("User 1");
   JLabel v2 = new JLabel("User 2");
   JTextField f1 = new JTextField("0 - 0 ");

   JButton b1 = new JButton();
   JButton b2 = new JButton();
   JButton b3 = new JButton();
   JLabel l1 = new JLabel("Round 1");
   JButton b4 = new JButton();
   JButton b5 = new JButton();
   JButton b6 = new JButton();

   JButton b7 = new JButton();
   JButton b8 = new JButton();
   JButton b9 = new JButton();
   JLabel l2 = new JLabel("Round 2");
   JButton b10 = new JButton();
   JButton b11 = new JButton();
   JButton b12 = new JButton();

   JButton b13 = new JButton();
   JButton b14 = new JButton();
   JButton b15 = new JButton();
   JLabel l3 = new JLabel("Round 3");
   JButton b16 = new JButton();
   JButton b17 = new JButton();
   JButton b18 = new JButton();

   JButton b19 = new JButton();
   JButton b20 = new JButton();
   JButton b21 = new JButton();
   JLabel l4 = new JLabel("Round 4");
   JButton b22 = new JButton();
   JButton b23 = new JButton();
   JButton b24 = new JButton();
   Color backgroundColor;

   JButton bs = new JButton("Spela ");
   JButton exitGame = new JButton("Ge upp");

   public ResultPanel(ActionListener al) {
      exitGame.addActionListener(al);
   }

   public void setPanel() {
       setBorder(BorderFactory.createLineBorder((new Color(175, 175, 200)), 10));
       setLayout(new BorderLayout());
       p1.add(v1);
       p1.add(f1);
       f1.setEditable(false);
       p1.add(v2);
       add("North", p1);
       p2.setLayout(new FlowLayout());
       p2.setLayout(new GridLayout(4, 7));

       p2.add(b1);
       p2.add(b2);
       p2.add(b3);
       p2.add(l1);
       p2.add(b4);
       p2.add(b5);
       p2.add(b6);
       add(p2);

       p2.add(b7);
       p2.add(b8);
       p2.add(b9);
       p2.add(l2);
       p2.add(b10);
       p2.add(b11);
       p2.add(b12);
       add(p2);

       p2.add(b13);
       p2.add(b14);
       p2.add(b15);
       p2.add(l3);
       p2.add(b16);
       p2.add(b17);
       p2.add(b18);
       add(p2);

       p2.add(b19);
       p2.add(b20);
       p2.add(b21);
       p2.add(l4);
       p2.add(b22);
       p2.add(b23);
       p2.add(b24);
       add(p2);

       p3.add(bs);
       p3.add(exitGame);
       add("South", p3);
       

   }
   public void setColor(Color backgroundColor){
       this.backgroundColor = backgroundColor;
   }

}