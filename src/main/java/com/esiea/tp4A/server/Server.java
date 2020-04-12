package com.esiea.tp4A.server;

import java.io.*;
import com.esiea.tp4A.domain.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;
    private final GestionRovers roversServer;
    private Carte map = null;
    private final int laserRange;
    public Server (int port, int tailleX, int tailleY, int laserRange) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.laserRange = laserRange;
        this.map = new Carte(tailleX,tailleY);
        this.roversServer = new GestionRovers(this.map,this.laserRange);
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
        Request.request(writer, reader, this.roversServer, laserRange);
        socket.close();
    }
}
