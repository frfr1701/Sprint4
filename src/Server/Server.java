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
            Session input, output;

            Protocol protocol = new Protocol();
            output = new Session();
            oos.writeObject(output);

            while ((input = (Session) ois.readObject()) != null) {

                output = protocol.processInput(input);
                oos2.writeObject(output);

                input = (Session) ois2.readObject(); 
                
                output = protocol.processInput(input);
                oos.writeObject(output);

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
