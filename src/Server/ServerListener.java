package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

<<<<<<< HEAD
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

=======
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
>>>>>>> fe7cc7f2f208a680673645482ddf5fbcff95f12b
