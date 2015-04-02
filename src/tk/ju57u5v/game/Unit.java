package tk.ju57u5v.game;

import tk.ju57u5v.engine.components.Entity;

public class Unit extends Entity{
	
	private int speed=1;
	private int health=10;
	private int damage=1;
	private int attackSpeed=1;
	private boolean alive=false;
	
	public Unit() {
		super();
	}
	
	public void setHealth(int health) {
		this.health=health;
	}
	
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	public void setDamage(int damage) {
		this.damage=damage;
	}
	
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed=attackSpeed;
	}

	public int getSpeed() {
		return this.speed;
	}

	public int getHealth() {
		return this.health;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getAttackSpeed() {
		return this.attackSpeed;
	}
	
	public void moveTo(int x, int y) {
		this.moveTo(x, y, this.speed);
	}
}
