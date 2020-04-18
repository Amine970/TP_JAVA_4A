package com.esiea.tp4A.server;

import java.io.IOException;
import java.util.Random;

public class Launch {
    public static void main (String []args) throws IOException {
        int choixTaille[] = {100,300,600};
        int choixRange[] = {5,30,1000};
    	Random random = new Random();
    	int i = random.nextInt(3);
    	int j = random.nextInt(3);
        Server serveur = new Server(8080, choixTaille[i],choixTaille[i],choixRange[j]);
        serveur.start();
    }
}
