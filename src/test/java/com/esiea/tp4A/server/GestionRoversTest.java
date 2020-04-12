package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.Carte;
import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.domain.Rover;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionRoversTest {
    private Carte carte = new Carte(30,30);
    private ArrayList<Position> obstacles = carte.getObstacle();
    private GestionRovers gestionRovers = new GestionRovers(carte, 5);
    @Test
    void getRover() {
    }
    @Test
    void setRover() {
        gestionRovers.setRover("toto1");
        gestionRovers.setRover("tata1");
        Rover toto = gestionRovers.getRover("toto1");
        Rover tata = gestionRovers.getRover("tata1");
        assertEquals("toto1", toto.getName());
        tata.initCoor(toto.getX()-1, toto.getY());
        tata.move("r");
        tata.move("s");
        System.out.println(toto);
        assertFalse(toto.getLive());
        assertEquals("Mort", gestionRovers.getStatus("toto1"));
        assertEquals("En vie", gestionRovers.getStatus("tata1"));
    }
    @Test
    void getMapRover() {
        gestionRovers.setRover("toto1");
        gestionRovers.setRover("tata1");
        ArrayList<Rover> rov = new ArrayList<Rover>();
        rov.add(gestionRovers.getRover("toto1"));
        rov.add(gestionRovers.getRover("tata1"));
        assertIterableEquals(rov, gestionRovers.getMapRover(0,0));
    }

    @Test
    void getObstacle() {
        assertIterableEquals(carte.getObstacle(), gestionRovers.getObstacle(0,0));
    }

    @Test
    void containRover() {
        assertFalse(gestionRovers.containRover("toto2"));
    }
}
