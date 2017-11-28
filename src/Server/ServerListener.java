package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerListener {

    private Server server;
    private final ServerSocket socketToServer;
    

    ServerListener() throws IOException {
        this.socketToServer = new ServerSocket(44444);
    }

    private void start() {
        while (true) {
            try {
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
        try {
            ServerListener serverListener = new ServerListener();
            serverListener.start();
        } catch (IOException ex) {
            System.out.println("IOexception trying to start server");
        }
    }
}
