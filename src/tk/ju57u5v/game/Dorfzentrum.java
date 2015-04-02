package tk.ju57u5v.game;

import java.awt.Graphics2D;
import tk.ju57u5v.engine.Game;

public class Dorfzentrum extends Unit {

	public Dorfzentrum() {
		super();

		initialise();
		getSavedAnimation("walk", "dorfzentrum_walk");
		getSavedAnimation("stand", "dorfzentrum_stand");
		this.animationManager.selectAnimation("walk");
		Game.getResourceManager().setDimensionsFromResource("unit", this);
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(Game.getResourceManager().getResource("unit"), getRelativIsoX(), getRelativIsoY(), null);
	}

	@Override
	public void update() {
		if (isMoving()) {
			this.animationManager.selectAnimation("walk");
		} else {
			this.animationManager.selectAnimation("stand");
		}
	}
}
