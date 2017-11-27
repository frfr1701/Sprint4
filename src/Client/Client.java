package Client;

import Domain.*;
import java.io.*;
import java.net.*;

import java.util.*;
import java.util.stream.*;

abstract class Client implements IPanel{

    public static void main(String[] args) throws IOException {
        Client start = new GameFrame();
        start.Client();
    }
    private static final int PORTNUMBER = 44444;
    private static final String HOSTNAMNE = "127.0.0.1";

    private ObjectInputStream serverInput;
    private Socket socketToServer;
    ObjectOutputStream serverOutput;

    Session session;
    State state;

    List<String> subjects;
    Queue<List<String>> questions;
    Queue<String> answers;

    public Client() {
        setPanel();
    }

    private void Client() {
        try {
            socketToServer = new Socket(HOSTNAMNE, PORTNUMBER);
            serverInput = new ObjectInputStream(socketToServer.getInputStream());
            serverOutput = new ObjectOutputStream(socketToServer.getOutputStream());

            while ((session = (Session) serverInput.readObject()) != null) {
                setGameStageGUI();
            }

        } catch (UnknownHostException e) {
            System.out.println("Don't know about host " + HOSTNAMNE);
        } catch (IOException e) {
            System.out.println("Couldn't get I/O for the connection to " + HOSTNAMNE);
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find class " + HOSTNAMNE);
        }
    }

    void writeObject() {
        try {
            serverOutput.writeObject(session);
        } catch (IOException ex) {
            System.out.println("IOException writeObject in client");
        }
    }

    public abstract void setGameStageGUI();
}
