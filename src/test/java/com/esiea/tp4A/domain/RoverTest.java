package com.esiea.tp4A.domain;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
class RoverTest {
    private Carte carte = new Carte(30,30);
    private ArrayList<Position> obstacles = carte.getObstacle();
    private Rover rover = new Rover(carte, 1, "toto");
    private Position obstacle = obstacles.get(0);
    @Test
    void getX() {
        assertEquals(0, rover.getX());
    }
    @Test
    void getY() {
        assertEquals(0, rover.getY());
    }
    @Test
    void getDirection() {
        assertEquals(Direction.NORTH, rover.getDirection());
    }
    @Test
    void move() {
        rover.initCoor(13,10);
        rover.move("sf");
        assertEquals(11, rover.getY());
        rover.move("srsrsrsrs");
        int nbObstacles = obstacles.size();
        System.out.println("position obstacle " + obstacle.getX() + " " + obstacle.getY() + " nbObstacles : " + obstacles.size());
        rover.initCoor(obstacle.getX(),obstacle.getY() - 1);
        System.out.println("position rover " + rover.getX() + " " + rover.getY());
        rover.move("s");
        assertTrue( obstacles.size() < nbObstacles);
        //System.out.println("nbObstacles : " + obstacles.size());
    }
    @Test
    void getName() {
        assertEquals("toto", rover.getName());
    }
    @Test
    void getLive() {
        assertTrue(rover.getLive());
    }
    @Test
    void initCoor() {
        rover.initCoor(5,5);
        assertEquals(5, rover.getX());
        assertEquals(5, rover.getY());
    }
    @Test
    void mort() {
        rover.mort();
        assertFalse(rover.getLive());
    }
}
