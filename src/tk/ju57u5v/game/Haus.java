package tk.ju57u5v.game;

import java.awt.Graphics2D;

import tk.ju57u5v.engine.Game;
import tk.ju57u5v.engine.GameObject;

public class Haus extends GameObject{

	public Haus(Game game) {
		super(game);
		
		initialise();
		animationManager.selectAnimation("walk");
		game.getResourceManager().setDimensionsFromResource("block", this);
	}
	
	@Override
	public void render (Graphics2D g) {
			//g.drawImage( game.getResourceManager().getResource(getAnimationQuery()), getRelativX(), getRelativY(), null);
			g.drawImage( game.getResourceManager().getResource("block"),getRelativIsoX(), getRelativIsoY(), null);
	}
}
