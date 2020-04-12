package com.esiea.tp4A.server;

import java.io.IOException;
import java.util.Random;

public class Launch {
    public static void main (String []args) throws IOException {
    	Random random = new Random();
        Server serveur = new Server(8086, 10,10,2);
        serveur.start();
    }
}
