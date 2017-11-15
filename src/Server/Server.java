package Server;

import Domain.Session;
import Domain.test.Question;
import Server.config.Config;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        
        int portNumber = 44444;

        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();

        ) {

            Config config = new Config(); //TODO: Vart borde denna ligga?



            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
            Question[] questions = objectMapper.readValue(new FileInputStream("src/Domain/test/Questions.json"), Question[].class);


            ObjectOutputStream oos= new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
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
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
} 
