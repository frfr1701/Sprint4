package Client;

import Domain.*;
import static Domain.GameState.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1"; //localhost
        int portNumber = 44444;

        List<String> subjects;
        List<String[]> questions;

        try (
                Socket kkSocket = new Socket(hostName, portNumber);) {
            ObjectOutputStream oos = new ObjectOutputStream(kkSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(kkSocket.getInputStream());

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            Session session;

            while ((session = (Session) ois.readObject()) != null) {
                int questionToAnswerMatcher = 0;
                
                switch (session.getGameState()) {
                    case CLIENTFIRST:

                        subjects = session.getDynamicSubjects();

                        //GRAFIIIIIIK
                        questions = session.getDynamicQuestions((String) "DET HÄR SKA VARA SUBJECTET SOM ÄR VALT");

                        //GRAFIIIIIIK
                        for (String[] question : questions) {
                            if (question[session.getCorrectAnswer()].equalsIgnoreCase(answers.get(questionToAnswerMatcher))) {
                                session.givePoint();
                            }
                            questionToAnswerMatcher++;
                        }
                        session.setGameState(SERVERMIDDLE);
                        break;
                    case CLIENTMIDDLE:
                        
                        questions = session.getRoundQuestions();
                        
                        for (String[] question : questions) {
                            if (question[session.getCorrectAnswer()].equalsIgnoreCase(answers.get(questionToAnswerMatcher))) {
                                session.givePoint();
                            }
                            questionToAnswerMatcher++;
                        }

                        
                        subjects = session.getDynamicSubjects();
                        questions = session.getDynamicQuestions((String) "DET HÄR SKA VARA SUBJECTET SOM ÄR VALT");

                        
                        
                        for (String[] question : questions) {
                            if (question[session.getCorrectAnswer()].equalsIgnoreCase(answers.get(questionToAnswerMatcher))) {
                                session.givePoint();
                            }
                            questionToAnswerMatcher++;
                        }
                        
                        
                        if (session.isLastRound()) {
                            session.setGameState(SERVERFINAL);
                        } else {
                            session.setGameState(SERVERMIDDLE);
                        }
                        break;
                    case CLIENTFINAL:
                        
                        questions = session.getRoundQuestions();

                        
                        for (String[] question : questions) {
                            if (question[session.getCorrectAnswer()].equalsIgnoreCase(answers.get(questionToAnswerMatcher))) {
                                session.givePoint();
                            }
                            questionToAnswerMatcher++;
                        }

                        break;
                }

                oos.writeObject(session);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + hostName);
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println("Couldn't find class "
                    + hostName);
            System.exit(1);
        }
    }
}
