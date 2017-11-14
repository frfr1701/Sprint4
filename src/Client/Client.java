package Client;

import Domain.*;
import java.io.*;
import java.net.*;

public class Client {///
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
                //There should be error handling for WAITING and CLIENTSENTANSWER 
                if(session.getState() == State.SERVERSENTRIDDLE){
                    System.out.println("Server: " + session.getRiddle());
                    session.setAnswer(stdIn.readLine());
                    session.setState(State.CLIENTSENTANSWER);
                }
                else if(session.getState() == State.SERVERSENTANSWER) {
                    if (session.getVerdict()){
                        System.out.println("Server: Du gissade RÄTT!");
                    }
                    else{
                        System.out.println("Server: Du gissade FEL!");
                    }
                    session.setState(State.WAITING);
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