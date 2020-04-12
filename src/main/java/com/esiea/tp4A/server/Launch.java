package com.esiea.tp4A.server;

import java.io.IOException;
import java.util.Random;

public class Launch {
	private static int choixTaille[] = {100,300,600};
	private static int choixRange[] = {5,30,1000};
    public static void main (String []args) throws IOException {
    	Random random = new Random();
    	int i = random.nextInt(3);
    	int j = random.nextInt(3);
        Server serveur = new Server(8086, choixTaille[i],choixTaille[i],choixRange[j]);
        serveur.start();
    }
}
