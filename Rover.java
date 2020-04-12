package com.esiea.tp4A.domain;

public class Rover implements Position,MarsRover {
	
	private Position Coor;
	private Carte map;
	private final int range;
	private final String name;
	private boolean vie = true;
	public Rover(Carte map, int range, String name) {
		Coor = MarsRover.super.move("Init");
		this.range = range;
		this.map = map;
		this.name = name;
	}
	public int getX() {
		return Coor.getX();	}
	public int getY() {
		return Coor.getY();	}
	public Direction getDirection() {
		return Coor.getDirection();	}	
	private void cercle() {
		if(getY() > Math.round(map.getTailleY()/2)) Coor = Position.of(getX(),-Math.round(map.getTailleY()/2)+1,getDirection());
		if(getY() < -Math.round(map.getTailleY()/2)+1) Coor = Position.of(getX(),Math.round(map.getTailleY()/2),getDirection());
		if(getX() > Math.round(map.getTailleX()/2)) Coor = Position.of(-Math.round(map.getTailleX()/2)+1,getY(),getDirection());
		if(getX() < -Math.round(map.getTailleX()/2)+1) Coor = Position.of(Math.round(map.getTailleX()/2),getY(),getDirection());	}
}
