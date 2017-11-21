package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerListener {

    private ServerSocket socketToServer;
    private Server server;

    private void start() {
        while (true) {
            try {
                socketToServer = new ServerSocket(44444);
                Socket socketToClientOne = socketToServer.accept();
                Socket socketToClientTwo = socketToServer.accept();
                server = new Server(socketToClientOne, socketToClientTwo);
                server.start();
            } catch (IOException e) {
                System.out.println("IOexception i serverListener");
            }
        }
    }

    public static void main(String[] args) {
        ServerListener serverListener = new ServerListener();
        serverListener.start();
    }
}
