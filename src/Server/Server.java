package Server;

import Domain.Session;
import java.io.*;
import java.net.Socket;

public class Server extends Thread {

    Socket socketToClient;
    Socket socketToClient2;

    Server(Socket socketToClient, Socket socketToClient2) {
        this.socketToClient = socketToClient;
        this.socketToClient2 = socketToClient2;
    }

    @Override
    public void run() {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(socketToClient.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socketToClient.getInputStream());
                ObjectOutputStream oos2 = new ObjectOutputStream(socketToClient2.getOutputStream());
                ObjectInputStream ois2 = new ObjectInputStream(socketToClient2.getInputStream());) {
            Session input, input2 = null, output, output2;

            // Initiate conversation with client
            Protocol protocol = new Protocol();
            output = protocol.processInput(protocol.getInitialSession());
            output2 = protocol.processInput(protocol.getInitialSession());
            oos.writeObject(output);
            
            while ((input = (Session) ois.readObject()) != null || (input2 = (Session) ois2.readObject()) != null) {
                if (protocol.getWhichPlayer()) {
                    oos.writeObject(output);
                    output = protocol.processInput(input);
                    oos.writeObject(output);
                } else{
                    oos2.writeObject(output2);
                    output2 = protocol.processInput(input2);
                    oos2.writeObject(output2);
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + socketToClient.getPort() + " or listening for a connection");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found when trying to listen on port "
                    + socketToClient.getPort() + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
