package Client;

import Domain.*;
import static Domain.State.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.*;

class Client {

    public static void main(String[] args) throws IOException {
        Client start = new Client();
        start.Client();
    }

    private static final int PORTNUMBER = 44444;
    private static final String HOSTNAMNE = "127.0.0.1";
    private final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private final Queue<String> answers = new LinkedList<>();

    private Session session;
    private List<List<String>> questions;
    private List<String> subjects;

    private void Client() {
        try (Socket socketToServer = new Socket(HOSTNAMNE, PORTNUMBER);
                ObjectOutputStream serverOutput = new ObjectOutputStream(socketToServer.getOutputStream());
                ObjectInputStream serverInput = new ObjectInputStream(socketToServer.getInputStream());) {
            clientprotocol:
            while ((session = (Session) serverInput.readObject()) != null) {
                switch (session.getGameState()) {
                    case FIRST:
                        System.out.println(subjects = session.getSubjects());
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
                        System.out.println(subjects = session.getSubjects());
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
        questions.stream()
                .filter((question) -> (question.get(2).equalsIgnoreCase(answers.remove())))
                .forEach((correctAnswer) -> {
                    session.givePointToPlayer();
                });
        
    }

    private void askQuestions() {
        questions.stream().map((question) -> {
            question.stream().filter(string -> (question.indexOf(string) > 0)).collect(Collectors.toList())
                    .stream().forEach(string -> {
                        System.out.println(string);
                    });
            return question;
        }).forEachOrdered((question) -> {
            try {
                answers.add(stdIn.readLine());
            } catch (IOException ex) {
                System.out.println("askQuestion IOException");
            }
        });
    }

}
