package ClientServerGUI.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//класс требуется разделить на GUI, controller и repository (смотри схему проекта)
public class ServerGUI extends JFrame implements ServerView {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private JButton btnStart, btnStop;
    private JTextArea log;
    private ServerController serverController;
    private ServerFile serverFile;




    public ServerGUI(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverStart();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.serverStop();
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }


    private void appendLog(String text){
        log.append(text + "\n");
    }

    @Override
    public void showMessage(String message) {
        appendLog(message);
    }

    @Override
    public void disconnect(String name) {
        appendLog("Пользователь " + name + " отключился");
    }

    @Override
    public void connect(String name) {
        appendLog("Пользователь " + name + " подключился");

    }

    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
    }

    private void serverStart(){
        serverController.serverStart();

    }
}