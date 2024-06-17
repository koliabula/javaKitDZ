package ClientServerGUI.server;

import ClientServerGUI.client.ClientController;

import java.util.ArrayList;
import java.util.List;

public class ServerController {
    private List<ClientController> clientGUIList;
    private boolean work ;
    private ServerView serverView;
    private ServerLog serverLog;



    public boolean serverStart() {
        if(!work) {
            work = true;
            serverView.showMessage("Сервер запущен!");
            clientGUIList = new ArrayList<>();
            return true;
        }
        serverView.showMessage("Сервер уже был запущен!");
        return false;
    }
    public boolean serverStop() {
        if(work) {
            work = false;
            serverView.showMessage("Сервер остановлен!");
            while (!clientGUIList.isEmpty()){
                disconnectUser(clientGUIList.get(clientGUIList.size()-1));
            }
            return true;
        }
        serverView.showMessage("Сервер уже был остановлен!");
        return false;
    }

    public void setServerView(ServerView serverView) {
        this.serverView = serverView;
    }
    public void setServerLog(ServerLog serverLog) {
        this.serverLog = serverLog;
    }


    public void disconnectUser(ClientController clientController) {
        clientGUIList.remove(clientController);
        if(clientController != null){
            clientController.disconnectedFromServer();
            serverView.disconnect(clientController.getName());
        }

    }

    public boolean connectUser(ClientController clientController) {
        if(!work) return false;
        clientGUIList.add(clientController);
        serverView.connect(clientController.getName());
        return true;

    }

    public String getHistory() {
        return serverLog.readLog();
    }

    public void message(String text) {
        if (!work){
            return;
        }
        serverView.showMessage(text);
        answerAll(text);
        serverLog.saveInLog(text);
    }

    private void answerAll(String text){
        for (ClientController clientGUI: clientGUIList){
            clientGUI.answerFromServer(text);;
        }
    }
}
