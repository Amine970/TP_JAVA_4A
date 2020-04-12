package com.esiea.tp4A.domain;
import com.esiea.tp4A.server.*;

public class Tir extends GestionRovers{
	private final Direction dir;
	private final int x;
	private final int y;
	private Carte map;
	public Tir(Carte map, int x, int y, Direction dir, int range) {
		super(map, range);
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.map = map;
		tir(range);	}
	private void tir(int range) {
		if(dir == Direction.NORTH) tir_N(range);
		else if(dir == Direction.SOUTH) tir_S(range);
		else if(dir == Direction.EAST) tir_E(range);
		else if(dir == Direction.WEST) tir_W(range);
	}
	private boolean execTir(int x, int y) {
		x = cercleX(x); y = cercleY(y);
		if(!map.valid(x,y)) {
			map.destroy(x,y);
			return true;}
		return false;
	}
	private void tir_N(int range) {
		for(int i=1;i<=range;i++) if(execTir(x,y+i) || kill(x,y+i)) break;	}
	private void tir_W(int range) {
		for(int i=1;i<=range;i++) if(execTir(x-i,y) || kill(x-i,y)) break;	}
	private void tir_S(int range) {
		for(int i=1;i<=range;i++) if(execTir(x,y-i) || kill(x,y-i)) break;	}
	private void tir_E(int range) {
		for(int i=1;i<=range;i++) if(execTir(x+i,y) || kill(x+i,y)) break;	}
	private boolean kill(int x, int y) {
		x = cercleX(x); y = cercleY(y);
		for(int i=0;i<Liste.size();i++) if(Liste.get(i).getX() == x && Liste.get(i).getY() == y) {
			Liste.get(i).mort();
			return true;}
		return false;
	}
	private int cercleX(int x) {
		if(x > Math.round(map.getTailleX()/2)) return -Math.round(map.getTailleX()/2)+1;
		if(x < -Math.round(map.getTailleX()/2)+1) return Math.round(map.getTailleX()/2);	
		return x;}
	private int cercleY(int y) {
		if(y > Math.round(map.getTailleY()/2)) return -Math.round(map.getTailleY()/2)+1;
		if(y < -Math.round(map.getTailleY()/2)+1) return Math.round(map.getTailleY()/2);
		return y;}
}
