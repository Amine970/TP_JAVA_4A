package com.esiea.tp4A.server;

import java.util.*;
import com.esiea.tp4A.domain.*;

public class GestionRovers implements RoversServer {
	protected static ArrayList<Rover> Liste = new ArrayList<Rover>();
	private Carte map;
	private final int laserRange;
	public GestionRovers(Carte map, int laserRange) {
		this.map = map;
		this.laserRange = laserRange;
	}
	public Rover getRover(String player) {
		for(int i=0;i<Liste.size();i++) if(Liste.get(i).getName().equals(player)) return Liste.get(i);
		return null;
	}
	public void setRover(String player) {
		GenerateRover rov = new GenerateRover(map, Liste);
		Liste.add(rov.genStart(laserRange,player));	
	}

	public boolean containRover(String player) {
		for(int i=0;i<Liste.size();i++) if(Liste.get(i).getName().equals(player)) return true;
		return false;
	}

}
