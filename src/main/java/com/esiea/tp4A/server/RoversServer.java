package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.domain.Rover;

import java.util.*;

public interface RoversServer {
     Rover getRover(String player);
     void setRover(String player);
     ArrayList<Rover> getMapRover(int x, int y);
     String getStatus(String player);
     ArrayList<Position> getObstacle(int x, int y);
     boolean containRover(String player);
}
