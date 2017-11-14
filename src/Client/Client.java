package Client;
import Server.QuestionReader.*;
import Domain.*;
import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) throws IOException {
        
        String hostName = "127.0.0.1"; //localhost
        //String hostName = "172.20.200.194"; //localhost
        int portNumber = 44444;

        try (
            Socket kkSocket = new Socket(hostName, portNumber);
        ) {
            ObjectOutputStream oos= new ObjectOutputStream(kkSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(kkSocket.getInputStream());
            
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            Session session;
            
            while ((session = (Session) ois.readObject()) != null) {
                //There should be error handling for WAITING and CLIENTCLICKEDANSWER 
                if(session.getState() == State.SERVERSENTWHATCATEGORYQUESTION){
                    System.out.println("Server: " + session.getsubjectChoices() + "         State: " + session.getState());
                    session.setWhatSubject(stdIn.readLine());
                    session.setState(State.CLIENTPICKEDSUBJECT);
                }
                else if(session.getState() == State.SERVERSENTQUESTION) {
                    
                    System.out.println("Server: " + session.getwhatSubject() +": "+ session.getQuestion() + "         State: " + session.getState());
                    session.setAnswer(stdIn.readLine());
                    session.setState(State.CLIENTCLICKEDANSWER);
                } else if(session.getState() == State.SERVERSENTANSWER){     
                    
                    if (session.getVerdict()){
                        System.out.println("Server: Du gissade RÄTT!");
                    }
                    else{
                        System.out.println("Server: Du gissade FEL!");
                    }
                    session.setState(State.ANOTHERQUESTION);
                }
                
                oos.writeObject(session);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            e.printStackTrace();
            System.exit(1);
        }
        catch (ClassNotFoundException e) {
            System.err.println("Couldn't find class " +
                hostName);
            System.exit(1);
        }
    }
}