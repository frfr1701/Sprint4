package Server;

import Domain.Session;
import java.net.*;
import java.io.*;

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
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found when trying to listen on port "
                + socketToClient.getPort() + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
} 
