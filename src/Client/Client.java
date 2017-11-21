package Client;

import Domain.*;
import static Domain.GameState.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws IOException {
        Client start = new Client();
        start.Client();
    }
    
    private static final int PORTNUMBER = 44444;
    private static final String HOSTNAMNE = "127.0.0.1";
    Session session;
    List<String> subjects;
    List<String[]> questions;
    
    public void Client() {

        

        try (Socket kkSocket = new Socket(HOSTNAMNE, PORTNUMBER);
            ObjectOutputStream oos = new ObjectOutputStream(kkSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(kkSocket.getInputStream());
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));){
            
            while ((session = (Session) ois.readObject()) != null) {
                switch (session.getGameState()) {
                    case CLIENTFIRST:
                        subjects = session.getDynamicSubjects();

                        //GRAFIIIIIIK
                        questions = session.getDynamicQuestions((String) "DET HÄR SKA VARA SUBJECTET SOM ÄR VALT");

                        //GRAFIIIIIIK
                        checkAnaswers(questions);
                        
                        session.setGameState(SERVERMIDDLE);
                        break;
                    case CLIENTMIDDLE:
                        questions = session.getRoundQuestions();

                        //GRAFIIIIIIK

                        checkAnaswers(questions);

                        //GRAFIIIIIIK
                        
                        subjects = session.getDynamicSubjects();

                        //GRAFIIIIIIK

                        questions = session.getDynamicQuestions((String) "DET HÄR SKA VARA SUBJECTET SOM ÄR VALT");

                        checkAnaswers(questions);
                        session.setGameState(SERVERMIDDLE);
                        break;
                    case CLIENTFINAL:

                        questions = session.getRoundQuestions();

                        checkAnaswers(questions);
                        session.setGameState(SERVERFINAL);
                        break;
                    case GAMECOMPLETE:
                    default:
                }

                oos.writeObject(session);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + HOSTNAMNE);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + HOSTNAMNE);
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println("Couldn't find class "
                    + HOSTNAMNE);
            System.exit(1);
        }
    }

    private void checkAnaswers(List<String[]> questions) {
        int questionToAnswerMatcher = 0;

        for (String[] question : questions) {
            if (question[session.getCorrectAnswer()].equalsIgnoreCase(answers.get(questionToAnswerMatcher))) {
                session.givePoint();
            }
            questionToAnswerMatcher++;
        }
    }
    

}
