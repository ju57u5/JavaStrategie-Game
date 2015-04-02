package tk.ju57u5v.game;

import tk.ju57u5v.engine.components.GameObject;

public class Building extends GameObject{

	private int health=10;
	private int level=1;
	private int size=1;
	private String sprite = "";
	
	public Building() {
		super();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void createUnit(int id) {
		
	}
	
	public void setLevel(int level) {
		this.level=level;
	}
	
}
