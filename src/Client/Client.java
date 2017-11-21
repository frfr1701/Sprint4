package Client;

import Domain.*;
import static Domain.State.*;
import java.io.*;
import java.net.*;
import java.util.*;

class Client {

    public static void main(String[] args) throws IOException {
        Client start = new Client();
        start.Client();
    }

    private static final int PORTNUMBER = 44444;
    private static final String HOSTNAMNE = "127.0.0.1";
    private final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private final List<String> answers = new ArrayList<>();

    private Session session;
    private List<String[]> questions;

    private void Client() {
        try (Socket socketToServer = new Socket(HOSTNAMNE, PORTNUMBER);
                ObjectOutputStream serverOutput = new ObjectOutputStream(socketToServer.getOutputStream());
                ObjectInputStream serverInput = new ObjectInputStream(socketToServer.getInputStream());) {
            clientprotocol:
            while ((session = (Session) serverInput.readObject()) != null) {
                switch (session.getGameState()) {
                    case FIRST:
                        System.out.println(session.getSubjects());
                        session.setQuestionsThisRound(questions = session.getQuestions(stdIn.readLine()));
                        askQuestions();
                        checkAnswers();

                        session.setGameState(MIDDLE);
                        serverOutput.writeObject(session);
                        break;
                    case MIDDLE:
                        questions = session.getQuestionsThisRound();
                        askQuestions();
                        checkAnswers();
                        //next round
                        System.out.println(session.getSubjects());
                        session.setQuestionsThisRound(questions = session.getQuestions(stdIn.readLine()));
                        askQuestions();
                        checkAnswers();

                        session.setGameState(MIDDLE);
                        serverOutput.writeObject(session);
                        break;
                    case FINAL:
                        questions = session.getQuestionsThisRound();
                        askQuestions();
                        checkAnswers();

                        session.setGameState(FINAL);
                        serverOutput.writeObject(session);
                        break;
                    case GAMECOMPLETE:
                        System.out.println(session.getPointsFromPlayer());
                        socketToServer.close();
                        break clientprotocol;
                    default:
                        serverOutput.writeObject(session);
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Don't know about host " + HOSTNAMNE);
        } catch (IOException e) {
            System.out.println("Couldn't get I/O for the connection to " + HOSTNAMNE);
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find class " + HOSTNAMNE);
        }
    }

    private void checkAnswers() {
        int index = 0;
        for (String[] question : questions) {
            if (question[2].equalsIgnoreCase(answers.get(index++))) {
                session.givePointToPlayer();
            }
        }
        answers.clear();
    }

    private void askQuestions() {
        try {
            for (String[] question : questions) {
                System.out.println(question[1]);
                for (int i = 2; i < question.length; i++) {
                    System.out.println(question[i]);
                }
                answers.add(stdIn.readLine());
            }
        } catch (IOException e) {
            System.out.println("inputStreamReader IOException");
        }
    }
}
