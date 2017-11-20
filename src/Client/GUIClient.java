package Client;

import com.sun.org.apache.bcel.internal.generic.Select;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.html.Option;

public class GUIClient extends JFrame implements ActionListener{
////
    JFrame f = new JFrame("QuizKampen");

    JPanel pp = new JPanel();

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();

    JLabel l1 = new JLabel("  Round 1 ");
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();

    JButton b11 = new JButton();
    JButton b22 = new JButton();
    JButton b33 = new JButton();
    JLabel l2 = new JLabel("  Round 2 ");
   
    JButton b44 = new JButton();
    JButton b55 = new JButton();
    JButton b66 = new JButton();

    JButton bs = new JButton("Spela ");
    JButton bG = new JButton("Ge upp");

    GUIClient() {
        bs .setBackground(Color.GREEN);
        bG.setBackground(Color.RED);
        JLabel v1 = new JLabel("User 1");
        JLabel v2 = new JLabel("User 2");
        JTextField f1 = new JTextField("   0 - 0  ");
        p1.add(v1);
        p1.add(f1);
        p1.add(v2);
        f.add(p1, BorderLayout.NORTH);

       p2.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(2, 7));

        b1.setPreferredSize(new Dimension(30, 30));
        b1.setFont(new Font("Helvetica", Font.BOLD, 20));
 b1.setBackground(Color.CYAN);
        p2.add(b1);
        b2.setPreferredSize(new Dimension(50, 30));
        b2.setFont(new Font("Helvetica", Font.BOLD, 20));
         b2.setBackground(Color.CYAN);
        p2.add(b2);
        b3.setPreferredSize(new Dimension(50, 30));
        b3.setFont(new Font("Helvetica", Font.BOLD, 20));
         b3.setBackground(Color.CYAN);
        p2.add(b3);
       p2.add(l1);
           ///
        b4.setPreferredSize(new Dimension(50, 30));
        b4.setFont(new Font("Helvetica", Font.BOLD, 20));
         b4.setBackground(Color.CYAN);
        p2.add(b4);
        b5.setPreferredSize(new Dimension(50, 30));
        b5.setFont(new Font("Helvetica", Font.BOLD, 20));
         b5.setBackground(Color.CYAN);
        p2.add(b5);
        b6.setPreferredSize(new Dimension(50, 30));
        b6.setFont(new Font("Helvetica", Font.BOLD, 20));
         b6.setBackground(Color.CYAN);
        p2.add(b6);
        // f.add(p2, BorderLayout.CENTER);

        // p2.setLayout(new FlowLayout());
        b11.setPreferredSize(new Dimension(50, 30));
        b11.setFont(new Font("Helvetica", Font.BOLD, 20));
         b11.setBackground(Color.CYAN);

        p2.add(b11);
        b22.setPreferredSize(new Dimension(50, 30));
        b22.setFont(new Font("Helvetica", Font.BOLD, 20));
         b22.setBackground(Color.CYAN);
        p2.add(b22);
        b33.setPreferredSize(new Dimension(50, 30));
        b33.setFont(new Font("Helvetica", Font.BOLD, 20));
         b33.setBackground(Color.CYAN);
        p2.add(b33);
       p2.add(l2);
 
        b44.setPreferredSize(new Dimension(50, 30));
        b44.setFont(new Font("Helvetica", Font.BOLD, 20));
         b44.setBackground(Color.CYAN);
        p2.add(b44);
        b55.setPreferredSize(new Dimension(50, 30));
        b55.setFont(new Font("Helvetica", Font.BOLD, 20));
         b55.setBackground(Color.CYAN);
        p2.add(b55);
        b66.setPreferredSize(new Dimension(50, 30));
        b66.setFont(new Font("Helvetica", Font.BOLD, 20));
         b66.setBackground(Color.CYAN);
        p2.add(b66);
        f.add(p2, BorderLayout.CENTER);

        p4.setLayout(new FlowLayout());
        p4.add(bs);
        p4.add(bG);
        bG.addActionListener(this);
        bs.addActionListener(this);
        f.add(p4, BorderLayout.SOUTH);

        f.pack();

        //f.setSize(300, 300);
        f.setLocation(1000, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        GUIClient d = new GUIClient();
        // JOptionPane.showConfirmDialog(null,"vill du ge upp " );
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        ////
      if (ae.getSource()==bG){
   ///
        int input = JOptionPane.showConfirmDialog(null, "Om du ge upp få du -24 poäng . Är du säker på att  du vill ge upp?",
                " Ge upp",JOptionPane.YES_NO_CANCEL_OPTION     );
          
///
	
	System.out.println(input);
        
        
        
   
    }else if (ae.getSource()==bs){
    
   
    
          //JOptionPane.showMessageDialog(null," spela ");
    
    
    }
    
    
////////  
    }}


