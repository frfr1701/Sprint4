package Domain;

import java.io.*;

class Player implements Serializable {

    int points = 0;

    void givePoint() {
        points++;
    }

    int getPoints() {
        return points;
    }
}
