package com.esiea.tp4A.domain;
import com.esiea.tp4A.server.GestionRovers;

public class Move extends GestionRovers {
	private final Carte map;
	private Direction dir;
	private int x;
	private int y;
	public Move(Carte map, Direction direction, int x, int y) {
		super(map,0);
		this.map = map;
		this.dir = direction;
		this.x = x;
		this.y = y; }
	private void move_N(char com) {
		if(com == 'f' && recherche_collision_vs_joueur(x,y+1)&& map.valid(x,y+1)) y += 1;
		else if(com == 'b' && recherche_collision_vs_joueur(x,y-1)&& map.valid(x,y-1)) y -= 1;
		else if(com == 'l') dir = Direction.WEST;
		else if(com == 'r') dir = Direction.EAST;}
	private void move_W(char com) {
		if(com == 'f' && recherche_collision_vs_joueur(x+1,y)&& map.valid(x-1,y)) x -= 1;
		else if(com == 'b' && recherche_collision_vs_joueur(x-1,y)&& map.valid(x+1,y)) x += 1;
		else if(com == 'l') dir = Direction.SOUTH;
		else if(com == 'r') dir = Direction.NORTH;}
	private void move_S(char com) {
		if(com == 'f' && recherche_collision_vs_joueur(x,y-1)&& map.valid(x,y-1)) y -= 1;
		else if(com == 'b' && recherche_collision_vs_joueur(x,y+1)&& map.valid(x,y+1)) y += 1;
		else if(com == 'r') dir = Direction.WEST;
		else if(com == 'l') dir = Direction.EAST;}
	private void move_E(char com) {
		if(com == 'f' && recherche_collision_vs_joueur(x-1,y)&& map.valid(x+1,y)) x += 1;
		else if(com == 'b' && recherche_collision_vs_joueur(x+1,y)&& map.valid(x-1,y)) x -= 1;
		else if(com == 'r') dir = Direction.SOUTH;
		else if(com == 'l') dir = Direction.NORTH;}
	public void go(char com) {
		if(dir == Direction.NORTH) move_N(com);
		else if(dir == Direction.SOUTH) move_S(com);
		else if(dir == Direction.EAST) move_E(com);
		else if(dir == Direction.WEST) move_W(com);}
	public boolean recherche_collision_vs_joueur(int x, int y) {
		for(int i=0;i<Liste.size();i++) if(Liste.get(i).getX() == x && Liste.get(i).getY() == y) return false;
		return true;
	}
	public int getX() {
		return x;}
	public int getY() {
		return y;}
	public Direction getDirection() {
		return dir;}
}
