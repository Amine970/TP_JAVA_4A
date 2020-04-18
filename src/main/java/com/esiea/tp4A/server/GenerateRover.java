package com.esiea.tp4A.server;

import java.util.ArrayList;
import java.util.Random;
import com.esiea.tp4A.domain.*;
public class GenerateRover {
	
	private final Carte map;
    /* Cette variable n'est pas final car elle correspond à la liste des rovers déjà présents sur le serveur
    et qu'elle va évoluer avec l'ajout d'un rover supplémentaire */
	private ArrayList<Rover> Liste = null;
	
	public GenerateRover(Carte map, ArrayList<Rover> Liste) {
		this.map = map;
		this.Liste = Liste;
	}
	
	private boolean testPos(int x, int y) {
		if(map.valid(x,y)) {for(int i=0;i<Liste.size();i++) {if(Liste.get(i).getX()==x && Liste.get(i).getY()==y && Liste.size() > 0) return false;}}
		else return false;
		return true;
	}
	
	private int[] genPos(int []coor, Random random) {
		do {
			coor[0] = random.nextInt(map.getTailleX()/2)-1;
			coor[1] = random.nextInt(map.getTailleY()/2)-1;
		} while(!testPos(coor[0],coor[1]));
		return coor;
	}
	
	public Rover genStart(int laserRange, String player) {
		Random random = new Random();
		int []coor = new int[2];
		coor = genPos(coor, random);
		Rover tmp = new Rover(map,laserRange,player);
		tmp.initCoor(coor[0],coor[1]);
		return tmp;
	}
}
