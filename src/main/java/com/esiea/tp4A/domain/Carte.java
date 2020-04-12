package com.esiea.tp4A.domain;

import java.util.*;

public class Carte implements PlanetMap {
	
	private ArrayList<Position> obstacle;	
	private final int taille[] = new int[2];
	
	public Carte(int x, int y) {
		taille[0] = x;
		taille[1] = y;
		InitObstacle();
	}

	private HashSet<int[]> InitCoor(int lim1,int lim2,Random random) {
		HashSet<int []> tmp = new HashSet<int[]>();
		for(int i=0;i<Math.round(taille[0]*taille[1]*15/100);i++) {
			int coor[] = {random.nextInt(lim1)-Math.round(lim1/2),random.nextInt(lim2)-Math.round(lim2/2)};
			tmp.add(coor);}
		return tmp;
	}
	public Set<Position> obstaclePositions() {
		Random random = new Random();
		Set<Position> obstacle = new HashSet<Position>();
		ArrayList<int []> coor = new ArrayList<int []>(InitCoor(taille[0],taille[1],random));
		for(int i=0;i<coor.size();i++) obstacle.add(Position.of(coor.get(i)[0],coor.get(i)[1],Direction.NORTH));
		return obstacle;
	}
	
	private void InitObstacle() {
		obstacle = new ArrayList<Position>(obstaclePositions());
	}
	
	public int getTailleY() {
		return taille[1];
	}
	
	public int getTailleX() {
		return taille[0];
	}
	
	public boolean valid(int x, int y) {
		for(int i=0;i<obstacle.size();i++) {
			if(obstacle.get(i).getX() == x && obstacle.get(i).getY() == y) return false;
		}
		return true;
	}
	
	public void destroy(int x, int y) {
		for(int i=0;i<obstacle.size();i++) {
			if(obstacle.get(i).getX() == x && obstacle.get(i).getY() == y) obstacle.remove(i);
		}
	}
	
	public ArrayList<Position> getObstacle() {
		return obstacle;
	}
}
