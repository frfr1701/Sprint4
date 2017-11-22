package Server;

import static Domain.State.*;
import Domain.Session;
import java.io.*;
import java.net.Socket;

<<<<<<< HEAD
public class Server extends Thread{
    Socket socketToClient;
    Protocol protocol = new Protocol();
    
    public Server(Socket socketToClient) {
        this.socketToClient=socketToClient;
    }
    
    @Override
    public void run(){
        try ( 
              ObjectOutputStream oos= new ObjectOutputStream(socketToClient.getOutputStream());
              ObjectInputStream ois = new ObjectInputStream(socketToClient.getInputStream());
        ) {

            Session input, output;
            
            // Initiate conversation with client
            Protocol kkp = new Protocol();
            output = kkp.processInput(kkp.getInitialSession());
            oos.writeObject(output);

            while ((input = (Session)ois.readObject()) != null) {
                output = kkp.processInput(input);
                oos.writeObject(output);
                
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + socketToClient.getPort() + " or listening for a connection");
=======
class Server extends Thread {

    private final Socket socketToClientOne;
    private final Socket socketToClientTwo;
    private final Protocol protocol;
    private Session Session;

    Server(Socket socketToClientOne, Socket socketToClientTwo) {
        this.socketToClientOne = socketToClientOne;
        this.socketToClientTwo = socketToClientTwo;

        this.protocol = new Protocol();
        this.Session = protocol.getInitialSession();
    }

    @Override
    public void run() {
        try (ObjectOutputStream ClientOneOutput = new ObjectOutputStream(socketToClientOne.getOutputStream());
                ObjectInputStream ClientOneInput = new ObjectInputStream(socketToClientOne.getInputStream());
                ObjectOutputStream ClientTwoOutput = new ObjectOutputStream(socketToClientTwo.getOutputStream());
                ObjectInputStream ClientTwoInput = new ObjectInputStream(socketToClientTwo.getInputStream());) {

            ClientOneOutput.writeObject(Session);

            while ((Session = (Session) ClientOneInput.readObject()) != null) {

                Session = protocol.processSession(Session);
                ClientTwoOutput.writeObject(Session);

                Session = (Session) ClientTwoInput.readObject();

                Session = protocol.processSession(Session);
                ClientOneOutput.writeObject(Session);

                if (Session.getGameState() == GAMECOMPLETE) {
                    Session.changePlayer();
                    ClientTwoOutput.writeObject(Session);
                    socketToClientOne.close();
                    socketToClientTwo.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + socketToClientOne.getPort() + " or listening for a connection");
>>>>>>> fe7cc7f2f208a680673645482ddf5fbcff95f12b
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found when trying to listen on port "
<<<<<<< HEAD
                + socketToClient.getPort() + " or listening for a connection");
=======
                    + socketToClientOne.getPort() + " or listening for a connection");
>>>>>>> fe7cc7f2f208a680673645482ddf5fbcff95f12b
            System.out.println(e.getMessage());
        }
    }
}
