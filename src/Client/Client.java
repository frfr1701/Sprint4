package Client;

import Server.QuestionReader.*;
import Domain.*;
import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Client {

    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1"; //localhost
        int portNumber = 44444;

        try (
            Socket kkSocket = new Socket(hostName, portNumber);) {
            ObjectOutputStream oos = new ObjectOutputStream(kkSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(kkSocket.getInputStream());

            BufferedReader stdIn
                    = new BufferedReader(new InputStreamReader(System.in));
            Session session;

            while ((session = (Session) ois.readObject()) != null) {
                //There should be error handling for WAITING and CLIENTCLICKEDANSWER 
                if(session.getState() == State.SERVERSTART){
                        
                    System.out.println("Server: "+ session.getState() + "\n" + session.getMessege());
                    session.setAnswer(stdIn.readLine());
                    System.out.println("------------------------------------------");
                    session.setState(State.CLIENTSTARTSGAME);
                    
                } else if (session.getState() == State.SERVERSENTWHATCATEGORYQUESTION) {
                        
                    System.out.println("Server: "+ session.getState() + "\nVälj mellan ämnen:  " + session.getsubjectChoices());
                    session.setWhatSubject(stdIn.readLine());
                    System.out.println("------------------------------------------");
                    session.setState(State.CLIENTPICKEDSUBJECT);
                        
                } else if (session.getState() == State.SERVERSENTQUESTION) {

                    System.out.println("Server: "+ session.getState() + "\nValtämne:  " + session.getwhatSubject() + "\nFråga:  " + session.getQuestion());
                    session.setAnswer(stdIn.readLine());
                    session.setState(State.CLIENTCLICKEDANSWER);
                    
                } else if (session.getState() == State.SERVERSENTANSWER) {

                    if (session.getVerdict()) {
                        System.out.println("Server: Du gissade RÄTT! Poäng denna runda: " + session.getScoreRond());
                        System.out.println("------------------------------------------");
                        session.setState(State.ANOTHERQUESTION);
                    } else {
                        System.out.println("Server: Du gissade FEL! Poäng denna runda: " + session.getScoreRond());
                        System.out.println("------------------------------------------");
                        session.setState(State.ANOTHERQUESTION); 
                    }
                  
                } else if (session.getState() == State.RESULTSCREEN){
                    
                     System.out.println("Server: "+ session.getState()+"\nRunda: "+ session.getCurrentRond() + "\n" + "Resultat för ronden: "+ session.getScoreRond()+ "\nResultat totalt: "+ session.getScoreTotal());
                     session.resetScoreRond();
                     session.setMessege("För starta ny runda tryck J");
                     System.out.println(session.getMessege());
                     session.setAnswer(stdIn.readLine());
                     System.out.println("------------------------------------------");
                     
                     session.setState(State.CLIENTSTARTSGAME);
                     
                } else if (session.getState() == State.FINISHEDGAME){
                    
                    System.out.println("Server: "+ session.getState()+"\nSpelet är avslutat du fick totalt:  "+ session.getScoreTotal() 
                            + "\nTEST - Vad står ronder på nu: " + session.getCurrentRond() 
                            + "\n" + "Resultat för ronden: "+ session.getScoreRond());
                    session.resetRonds();
                    session.setMessege("Vill du starta nytt spel J");
                    System.out.println("------------------------------------------");
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
