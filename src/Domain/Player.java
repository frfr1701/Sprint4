package Domain;

public class Player {
    int points = 0;
    
    public void givePoint() {
        points++;
    }

    public int getPoints() {
        return points;
    }
}
