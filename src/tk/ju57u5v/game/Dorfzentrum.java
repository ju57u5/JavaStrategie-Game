package tk.ju57u5v.game;

import java.awt.Graphics2D;
import tk.ju57u5v.engine.Game;

public class Dorfzentrum extends Unit {
	
	
	
	public Dorfzentrum(Game game) {
		super(game);
		
		initialise();
		getSavedAnimation("walk","dorfzentrum_walk");
		getSavedAnimation("stand","dorfzentrum_stand");
		animationManager.selectAnimation("walk");
		game.getResourceManager().setDimensionsFromResource("test", this);
	}
	
	@Override
	public void render (Graphics2D g) {
			g.drawImage( game.getResourceManager().getResource("test"),getRelativIsoX(), getRelativIsoY(), null);
	}
	
	@Override
	public void update() {
		if (isMoving()) {
			animationManager.selectAnimation("walk");
		} else {
			animationManager.selectAnimation("stand");
		}
	}
}
