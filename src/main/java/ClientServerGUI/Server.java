package ClientServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Server extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 350;
    public static final String PATH = "src/main/resources/log.txt";
    List<Client> clientList;
    JButton btnStart, btnStop;
    JTextArea textArea;
    boolean serverWork;

    Server(){
        clientList = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Server");
        setResizable(false);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);

        add(textArea);
        add(panBottom, BorderLayout.SOUTH);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWork){
                    dowlandLog("Сервер уже был запущен");
                } else {
                    serverWork = true;
                    dowlandLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!serverWork){
                    dowlandLog("Сервер уже был остановлен");
                } else {
                    serverWork = false;
                    while (!clientList.isEmpty()){
                        disconnectUser(clientList.get(clientList.size()-1));
                    }
                    dowlandLog("Сервер остановлен!");
                }
            }
        });
        setVisible(true);

    }


    public boolean connectUser(Client client){
        if (!serverWork){
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnectFromServer();
        }
    }

    public void message(String sText){
        if (!serverWork){
            return;
        }
        sText += "";
        dowlandLog(sText);
        answerAll(sText);
        writeLog(sText);
    }
    private void answerAll(String sText){
        for (Client client: clientList){
            client.answer(sText);
        }
    }

    public String getLog() {
        return readLog();
    }
    private void writeLog(String sText){
        try (FileWriter writer = new FileWriter(PATH, true)){
            writer.write(sText);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void dowlandLog(String sText){
        textArea.append(sText + "\n");
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean startStopServer(){

        return true;
    }
}
