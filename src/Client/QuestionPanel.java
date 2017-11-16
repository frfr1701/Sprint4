package Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    class QuestionPanel extends JPanel {
        
        Label answer1 = new Label("Svar 1", Label.CENTER);
        Label answer2 = new Label("Svar 2", Label.CENTER);
        Label answer3 = new Label("Svar 3", Label.CENTER);
        Label answer4 = new Label("Svar 4", Label.CENTER);

    public QuestionPanel(MouseListener ma) {
        
        answer1.addMouseListener(ma);
    }
        
}
