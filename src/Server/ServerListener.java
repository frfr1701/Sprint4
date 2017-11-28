package Server;

import java.io.*;
import java.net.*;

class ServerListener {

    private final ServerSocket socketToServer;
    private Socket socketToClientOne;
    private Socket socketToClientTwo;
    private Server server;

    ServerListener() throws IOException {
        this.socketToServer = new ServerSocket(44444);
    }

    private void start() throws IOException {
        while (true) {
            socketToClientOne = socketToServer.accept();
            socketToClientTwo = socketToServer.accept();
            server = new Server(socketToClientOne, socketToClientTwo);
            server.start();

        }
    }

    public static void main(String[] args) {
        try {
            ServerListener serverListener = new ServerListener();
            serverListener.start();
        } catch (IOException ex) {
            System.out.println("IOexception trying to start server");
        }
    }
}
