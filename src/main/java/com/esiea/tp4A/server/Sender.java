package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.*;

import java.io.PrintWriter;
import java.util.*;

public class Sender {
    public static void bad (PrintWriter writer, String code) {
        String message = "HTTP/1.0 " + code + "\n\n";
        send(writer, message);
    }
    public static void good (PrintWriter writer, String player, GestionRovers roverServer, int laserRange) {
        Rover rover = roverServer.getRover(player);
        String message = "HTTP/1.0 200 OK\nContent-Type: application/json\n\n";
        message += "{\"player\":{\"name\":\"" + player + "\",\"status\":\"" + roverServer.getStatus(player) +  "\",\"position\":" + position(rover) + ",\"laser-range\":" + laserRange + "},\"local-map\":{\"obstacle\":" + obstacle(roverServer,rover) +",\"players\":" + players(roverServer, rover) + "}}";;
        send(writer, message);
    }

    private static void send(PrintWriter writer, String message) {
        writer.print(message);
        writer.flush();
    }
}
