package tk.ju57u5v.game;

import tk.ju57u5v.engine.Game;

public class GameRunner extends tk.ju57u5v.engine.GameRunner {

	public GameRunner() {
		super();
	}
	
	@Override
	public void work() {
		//System.out.println(Game.getWindow().isFullscreen());
		doKeys();
	}
	
	private void doKeys() {
		if (Game.getBindHandler().bindActive("+left")) {
			Game.getKamera().setX(Game.getKamera().getX()-5);
		}
		if (Game.getBindHandler().bindActive("+right")) {
			Game.getKamera().setX(Game.getKamera().getX()+5);
		}
		if (Game.getBindHandler().bindActive("+up")) {
			Game.getKamera().setY(Game.getKamera().getY()-5);
		}
		if (Game.getBindHandler().bindActive("+down")) {
			Game.getKamera().setY(Game.getKamera().getY()+5);
		}
		
	}
}
