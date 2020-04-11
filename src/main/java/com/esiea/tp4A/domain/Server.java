package com.esiea.tp4A.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private RoversServer roversServer;
    public Server (int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.roversServer = null;
    }
    public void setRoversServer(RoversServer roversServer) {
        this.roversServer = roversServer;
    }
    public void start () {
        if (this.roversServer == null) return;
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
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Request.request(writer, reader, this.roversServer);
        socket.close();
    }
}
