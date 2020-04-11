package com.esiea.tp4A.domain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    public Server (int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        Thread thread = new Thread(() -> boucle());
        thread.start();
    }
    private void boucle() {
        while(true) {
            try {
                client(this.serverSocket.accept());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void client(Socket socket) throws IOException {
      System.out.println("Un nouveau client s'est connécté");
      socket.close();
    }
}
