package com.esiea.tp4A.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Request {
    public static void request (PrintWriter writer, BufferedReader reader, GestionRovers roversServer, int laserRange) throws IOException {
        String receive = reader.readLine();
        if(receive == null) return;
        String []string = receive.split(" ");
        receive(writer, roversServer, string[0],string[1].split("/"), laserRange);
    }
    private static void receive(PrintWriter printWriter, GestionRovers roversServer, String type,String[] link, int laserRange) {
        if (type.equals("POST") && link.length == 4 && link[0].equals("") && link[1].equals("api") && link[2].equals("player")) post(printWriter, roversServer, link[3], laserRange);
        else if (type.equals("GET") && link.length == 4 && link[0].equals("") && link[1].equals("api") && link[2].equals("player")) get(printWriter, roversServer, link[3], laserRange);
        else if (type.equals("PATCH") && link.length == 5 && link[0].equals("") && link[1].equals("api") && link[2].equals("player")) patch(printWriter, roversServer, link[3], link[4], laserRange);
    }
    private static void post(PrintWriter printWriter, GestionRovers roversServer, String player, int laserRange) {
        if (roversServer.containRover(player)) Sender.bad(printWriter, "409 Conflict");
        else {
            roversServer.setRover(player);
            Sender.good(printWriter,player, roversServer, laserRange);
        }
    }
    private static void get(PrintWriter printWriter, GestionRovers roversServer, String player, int laserRange) {
        if (!roversServer.containRover(player)) Sender.bad(printWriter, "404 Not Found");
        else Sender.good(printWriter,player, roversServer, laserRange);
    }
    private static void patch(PrintWriter printWriter, GestionRovers roversServer, String player,String commande, int laserRange) {
        if (!roversServer.containRover(player)) Sender.bad(printWriter, "404 Not Found");
        else {
            roversServer.getRover(player).move(commande);
            Sender.good(printWriter,player,roversServer, laserRange);
        }
    }
}
