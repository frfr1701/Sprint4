package Server;

import Domain.*;

public class Protocol {

    //private static final int NUMRIDDLES = 3;
    private int currentRiddle = 0;

    private String[] clues = { "Vad är det som går och går men aldrig kommer till dörren?", "Vilken sten är alltid ihålig?", "Vilket öga kan inte se?"};
    private String[] answers = { "Klockan",
                                 "Skorstenen",
                                 "Nålsögat" };
    
    public Session getInitialSession(){
        return new Session(clues[currentRiddle]);
    }
    ////
    public Session processInput(Session s) {
        State state = s.getState();
        System.out.println("Server: "+state);
        
        //There should be error handling for SERVERSENTRIDDLE state

        if (state == State.WAITING || state == State.SERVERSENTANSWER) {
            s.setRiddle(clues[currentRiddle]);
            s.setState(State.SERVERSENTRIDDLE);
        } else if (state == State.CLIENTSENTANSWER) {
            if (s.getAnswer().equalsIgnoreCase(answers[currentRiddle])) {
                s.setVerdict(true);
            } else {
                s.setVerdict(false);
            }
            s.setState(State.SERVERSENTANSWER);
            currentRiddle++;
            currentRiddle = currentRiddle%clues.length;
        }
        return s;
    }

}