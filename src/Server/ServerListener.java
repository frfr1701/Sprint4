    package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {

    private ServerSocket serverSocket;

    public ServerListener() throws IOException {
        this.serverSocket = new ServerSocket(44444);
    }

    public void server() {
        while (true) {
            try {
                Socket socketToClient = serverSocket.accept();
                Socket socketToClient2 = serverSocket.accept();
                Server clientHandler = new Server(socketToClient, socketToClient2);
                clientHandler.start();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerListener start = new ServerListener();
        start.server();
    }
}
