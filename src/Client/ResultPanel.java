package Client;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ResultPanel extends JPanel implements IPanel {
    
    
    

    public ResultPanel() {
        
        
    }
    
    @Override
    public void setPanel(){
        setBorder(BorderFactory.createLineBorder((new Color(175, 175, 200)), 10));
        
      
    }
    @Override
    public void setColor(Color backgroundColor){
        
    }


}