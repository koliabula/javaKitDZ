package ClientServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Client extends JFrame {
    private static final int WIDTH = 350;
    private static final int HEIGHT = 300;
    private Server server;
    private boolean connect;
    private String userName;
    JTextArea textArea;
    JButton btnLogin, btnSend;
    JTextField textFieldIp, textFieldPort,
            textFieldLogin, textFieldMessage;
    JPasswordField passwordFieldPassword;
    JPanel panBottom, panTop;

    Client(Server server) {
        this.server = server;

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(server);
        setTitle("ChatClient");
        setResizable(false);

        textFieldIp = new JTextField("127.0.0.1", 10);
//        textFieldIp.setToolTipText("127.0.0.1");
        textFieldPort = new JTextField("8080", 10);
//        textFieldPort.setToolTipText("8080");
        textFieldLogin = new JTextField("Марк", 10);
        passwordFieldPassword =new JPasswordField(10);
        passwordFieldPassword.setText("qwertyuiop");
        passwordFieldPassword.setEchoChar('*');
        textFieldMessage = new JTextField("Привет!!!", 35);

        textArea = new JTextArea();
        btnLogin = new JButton("Login");
        btnSend = new JButton("Send");

        panTop = new JPanel(new GridLayout(2, 3));
        panTop.add(textFieldIp);
        panTop.add(textFieldPort);
        panTop.add (new JPanel());
        panTop.add(textFieldLogin);
        panTop.add(passwordFieldPassword);
        panTop.add(btnLogin);

        panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(textFieldMessage);
        panBottom.add(btnSend);

        textArea.setEditable(false);

        add(panTop, BorderLayout.NORTH);
        add(textArea);
        add(panBottom, BorderLayout.SOUTH);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });

        setVisible(true);
    }

    private void connectToServer() {
        if (server.connectUser(this)) {
            downloadLog("Вы успешно подключились!\n");
            panTop.setVisible(false);
            connect = true;
            userName = textFieldLogin.getText();
            String log = server.getLog();
            if (log != null)   downloadLog(log);
        } else downloadLog("Подключение не удалось");
    }

    private void downloadLog(String sText) {
        textArea.append(sText + "\n");
    }

    public void disconnectFromServer() {
        if (connect) {
            panTop.setVisible(true);
            connect = false;
            server.disconnectUser(this);
            downloadLog("Вы были отключены от сервера!");
        }
    }

    public void message() {
        if (connect) {
            String text = textFieldMessage.getText();
            if (!text.equals("")) {
                server.message(userName + ": " + text);
                textFieldMessage.setText("");
            }
        } else {
            downloadLog("Нет подключения к серверу");
        }
    }
    public void answer(String sText) {
        downloadLog(sText);
    }
}
