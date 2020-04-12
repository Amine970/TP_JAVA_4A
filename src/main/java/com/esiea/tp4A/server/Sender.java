package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.;

import java.io.PrintWriter;
import java.util.;

public class Sender {
    public static void bad (PrintWriter writer, String code) {
        String message = "HTTP/1.0 " + code + "\n\n";
        send(writer, message);
    }
    public static void good (PrintWriter writer, String player, GestionRovers roverServer, int laserRange) {
        Rover rover = roverServer.getRover(player);
        String message = "HTTP/1.0 200 OK\nContent-Type: application/json\n\n";
        message += "{"player":{"name":"" + player + "","status":"" + roverServer.getStatus(player) +  "","position":" + position(rover) + ","laser-range":" + laserRange + "},"local-map":{"obstacle":" + obstacle(roverServer,rover) +","players":" + players(roverServer, rover) + "}}";;
        send(writer, message);
    }
    private static String players(GestionRovers roversServer, Rover rover) {
        ArrayList<Rover> rovers = roversServer.getMapRover(rover.getX(),rover.getY());
        return players(rovers, 0, rovers.size()-1);
    }
    private static String players(ArrayList<Rover> rovers, int increment, int size) {
        String message = "";
        for (Rover rov : rovers) {
            message += "{"name":"" + rov.getName() + "","x":" + rov.getX() + ","y":" + rov.getY() + "}";
            if(increment != size) message += ",";
        }
        return "[" + message + "]";
    }

    private static String position(Rover rover) {
        return position(rover.getX(),rover.getY(),rover.getDirection().name());
    }
    private static String position(int x, int y, String direction) {
        return "{"x":"+x+","y":"+y+","direction":""+direction+""}";
    }
    private static void send(PrintWriter writer, String message) {
        writer.print(message);
        writer.flush();
    }
}
