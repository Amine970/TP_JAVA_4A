package com.esiea.tp4A.domain;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
class MoveTest {
    private Carte carte = new Carte(30,30);
    private Move move = new Move(carte, Direction.NORTH, 5, 5);
    private ArrayList<Position> obstacles = carte.getObstacle();
    private Position obstacle = obstacles.get(0);
    @Test
    void go() {
        obstacles.clear();
        //move north
        System.out.println(move.getX() + "," + move.getY() + "," + move.getDirection());
        move.go('f');
        assertEquals(6, move.getY());
        move.go('b');
        assertEquals(5, move.getY());
        move.go('l');
        move.go('f');
        //System.out.println(move.getX() + "," + move.getY() + "," + move.getDirection());
        assertEquals(Direction.WEST, move.getDirection());
        assertEquals(4, move.getX());
        move.go('r');
        move.go('r');
        move.go('r');
        move.go('l');
        move.go('r');
        assertEquals(Direction.SOUTH, move.getDirection());
        move.go('f');
        move.go('r');
        move.go('l');
        move.go('l');
        move.go('l');
        assertEquals(4, move.getY());
    }

    @Test
    void recherche_collision_vs_joueur() {
    }

    @Test
    void setX() {
    }

    @Test
    void setY() {
    }

    @Test
    void setDirection() {
    }
}