package Server;

import static Domain.State.*;
import Domain.Session;
import java.io.*;
import java.net.Socket;

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
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found when trying to listen on port "
                    + socketToClientOne.getPort() + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
