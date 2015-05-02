package tk.ju57u5v.game;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import tk.ju57u5v.engine.Game;
import tk.ju57u5v.game.Player;
import tk.ju57u5v.game.gui.MiniMap;
import tk.ju57u5v.engine.TwoDMath;
import tk.ju57u5v.engine.network.Client;
import tk.ju57u5v.engine.network.Server;

public class StrategieGame extends Game implements MouseWheelListener {
	

	public StrategieGame(String[] args) {
		super(args);
		config();
		server = new Server();
		client = new Client();
		
		initalizeGame();
	}

	@Override
	public void startGame() {
		// Prüfe ob eine Config da ist.
		resourceManager.checkConfig();
		super.startGame();
		BufferedImage map = tileManager.generateWorld(Math.round(Math.random() * 100 * Math.random() * 10));
		//BufferedImage map = tileManager.generateWorld2(10);
		new MiniMap(map).saveMap();
		console.getConVarManager().safeVars();
		new Dorfzentrum().setPosition(100, 100);
		//DEBUG:
		/*client.connect("127.0.0.1", 27015);
		client.requestEntityCreate(Dorfzentrum.class);
		client.requestEntityCreate(Dorfzentrum.class);
		client.requestEntityCreate(Dorfzentrum.class);*/
	}
	
	public static void main(String[] args) {
		Game.setName("JavaStrategie");
		StrategieGame.setName("JavaStrategie");
		StrategieGame.build(new StrategieGame(args));
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

	}

	public void config() {
		tileManager = new TileManager(50, 50);
		gameRunner = new GameRunner();
		window.setBackground(Color.black);
		window.addMouseWheelListener(this);
		//window.goFullScreen();
	}

}
