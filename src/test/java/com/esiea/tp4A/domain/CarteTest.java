package com.esiea.tp4A.domain;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
class CarteTest {
    private Carte carte = new Carte(30,30);
    private ArrayList<Position> obstacles = carte.getObstacle();
    private Position obstacle = obstacles.get(0);
    @Test
    void obstaclePositions() {
        assertTrue(obstacles.size() <= Math.round(carte.getTailleX()*carte.getTailleY()*15/100));
    }
    @Test
    void getTailleY() {
        assertEquals( carte.getTailleX(),30);
    }
    @Test
    void getTailleX() { assertEquals( carte.getTailleY(),30); }
    @Test
    void valid() {
        assertFalse(carte.valid(obstacle.getX(), obstacle.getY()));
        for(int i = -14; i < 14; i++)
            if(!obstacles.contains(Position.of(0, i, Direction.NORTH))) {
                assertTrue(carte.valid(0, i));
                System.out.println(i);
                break;
            }
    }
    @Test
    void destroy() {
        int nbObstacles = obstacles.size();
        carte.destroy(obstacle.getX(), obstacle.getY());
        assertTrue( obstacles.size() < nbObstacles);
        //assertEquals(nbObstacles - 1, obstacles.size());
    }
}
