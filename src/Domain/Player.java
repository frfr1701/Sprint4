package Domain;

import java.io.*;

public class Player implements Serializable{
    int points = 0;
    
    public void givePoint() {
        points++;
    }

    public int getPoints() {
        return points;
    }
}
