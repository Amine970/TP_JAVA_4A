package com.esiea.tp4A.server;

import java.util.*;
import com.esiea.tp4A.domain.*;

public class GestionRovers implements RoversServer {
    /* Cette variable est static car elle correspond à la liste des rovers, hors la classe GestionRovers est instanciée 
    au lancement du serveur et également par les classes Move et Tir qui héritent de celle-ci 
    afin de pouvoir récupérer la liste des Rovers pour déterminer si un tir en rencontre un ou si un mouvement 
    va enclencher une collision avec un autre rover. Il est donc important que la liste des Rovers soit la même 
    pour toutes les différentes instanciations de la classe GestionRovers d'où la variable static */
	protected static ArrayList<Rover> Liste = new ArrayList<Rover>();
    /* Cette variable n'est pas final car elle correspond à la carte des obstacles et elle est amenée à évoluer 
    en fonction des actions des joueurs (utilisation du laser du rover) */
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
	public ArrayList<Rover> getMapRover(int x, int y) {
		ArrayList<Rover> Rov = new ArrayList<Rover>();
		for(int i=0;i<Liste.size();i++) if(Math.abs(Liste.get(i).getX()-x) <= 30 && Math.abs(Liste.get(i).getY()-y) <= 30) Rov.add(Liste.get(i));
		return Rov;
	}
	public String getStatus(String player) {
		Rover tmp = getRover(player);
		if(tmp.getLive()) return "En vie";
		return "Mort";
	}

	public ArrayList<Position> getObstacle(int x, int y) {
		ArrayList<Position> obstacle = map.getObstacle();
		ArrayList<Position> radar = new ArrayList<Position>();
		for(int i=0;i<obstacle.size();i++) if(Math.abs(obstacle.get(i).getX()-x) <= 30 && Math.abs(obstacle.get(i).getY()-y) <= 30) radar.add(obstacle.get(i));
		return radar;
	}
	public boolean containRover(String player) {
		for(int i=0;i<Liste.size();i++) if(Liste.get(i).getName().equals(player)) return true;
		return false;
	}

}

