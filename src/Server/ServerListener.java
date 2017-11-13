package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread{
    
    private ServerSocket serverSocket;;

    public ServerListener() throws IOException {
        this.serverSocket = new ServerSocket(12345);
    }
    
        @Override
        public void run() {
            while (true) {
                try {
                    final Socket socketToClient = serverSocket.accept();
                    Server clientHandler = new Server(socketToClient) {};
                    clientHandler.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) throws IOException {
        ServerListener s = new ServerListener();
        s.start();
    }
}

