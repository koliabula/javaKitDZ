package ClientServerGUI.server;

public interface ServerView {
    void showMessage(String message);
    void disconnect(String name);
    void connect(String name);
}
