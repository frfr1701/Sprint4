package Client;

import Domain.*;
import java.io.*;
import java.net.*;
import java.util.*;

abstract class Client {

    public static void main(String[] args) throws IOException {
        Client start = new GameFrame();
        start.Client();
    }
    private static final int PORTNUMBER = 44444;
    private static final String HOSTNAMNE = "127.0.0.1";

    private Socket socketToServer;
    private ObjectInputStream serverInput;
    private ObjectOutputStream serverOutput;

    protected Session session;
    protected State state;

    protected List<String> subjects;
    protected Queue<List<String>> questions;
    protected Queue<String> answers;
    protected Queue panelQueue;

    private void Client() {
        setPanel();
        try {
            socketToServer = new Socket(HOSTNAMNE, PORTNUMBER);
            serverInput = new ObjectInputStream(socketToServer.getInputStream());
            serverOutput = new ObjectOutputStream(socketToServer.getOutputStream());
            while ((session = (Session) serverInput.readObject()) != null) {
                panelQueue = new LinkedList<>();
                questions = session.getQuestionsThisRound();
                switch (state = session.getGameState()) {
                    case FIRST:
                        addCategoryPanelToQueue();
                        addQuestionPanelsToQueue();
                        initSubjectPanel();
                        break;
                    case MIDDLE:
                        addQuestionPanelsToQueue();
                        addCategoryPanelToQueue();
                        addQuestionPanelsToQueue();
                        initQuestionPanel();
                        break;
                    case FINAL:
                        addQuestionPanelsToQueue();
                        initQuestionPanel();
                        break;
                    case GAMECOMPLETE:
                        addResultPanelToQueue();
                        initResultPanel();
                        break;
                    default:
                        writeObject();
                }
                RevalidateRepaint();
            }
        } catch (UnknownHostException e) {
            System.out.println("Don't know about host " + HOSTNAMNE);
        } catch (IOException e) {
            System.out.println("Couldn't get I/O for the connection to " + HOSTNAMNE);
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find class " + HOSTNAMNE);
        }
    }

    protected void writeObject() {
        try {
            serverOutput.writeObject(session);
        } catch (IOException ex) {
            System.out.println("IOException writeObject in client");
        }
    }

    protected abstract void addQuestionPanelsToQueue();

    protected abstract void addCategoryPanelToQueue();

    protected abstract void addResultPanelToQueue();

    protected abstract void initSubjectPanel();

    protected abstract void initQuestionPanel();

    protected abstract void initResultPanel();

    protected abstract void RevalidateRepaint();

    protected abstract void setPanel();
}
