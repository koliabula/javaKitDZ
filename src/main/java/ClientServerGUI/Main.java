package ClientServerGUI;


//Реализовать клиент-серверное приложение. Начало его можно увидеть в презентации к первому уроку,
//а можно ориентироваться на скриншоты.
//Результат можно увидеть на скриншотах, которые также можно найти в материалах к уроку

//Клиентское приложение должно отправлять сообщения из текстового поля сообщения в серверное
// приложение по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;

//Продублировать импровизированный лог (историю) чата в файле;

//При запуске клиента чата заполнять поле истории из файла, если он существует.
// Обратите внимание, что чаще всего история сообщений хранится на сервере
// и заполнение истории чата лучше делать при соединении с сервером, а не при открытии окна клиента.


import ClientServerGUI.client.*;
import ClientServerGUI.server.*;

public class Main {
    public static void main(String[] args) {
        //создание объектов сервера и создание связи между ними
        ServerGUI serverWindow = new ServerGUI();
        ServerController serverController = new ServerController();
        ServerFile serverFile = new ServerFile();
        serverController.setServerView(serverWindow);
        serverController.setServerLog(serverFile);
        serverWindow.setServerController(serverController);

        //создание объектов клиента1 и создание связи между ними
        ClientGUI clientGUI1 = new ClientGUI();
        ClientController clientController1 = new ClientController();
        clientController1.setClientView(clientGUI1);
        clientGUI1.setClient(clientController1);
        clientController1.setServer(serverController);

        //создание объектов клиента2 и создание связи между ними
        ClientGUI clientGUI2 = new ClientGUI();
        ClientController clientController2 = new ClientController();
        clientController2.setClientView(clientGUI2);
        clientGUI2.setClient(clientController2);
        clientController2.setServer(serverController);

    }

}
