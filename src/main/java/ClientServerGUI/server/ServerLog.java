package ClientServerGUI.server;

public interface ServerLog {
    void saveInLog(String text);

    String readLog();
}
