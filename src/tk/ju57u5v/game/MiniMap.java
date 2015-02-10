package tk.ju57u5v.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.ju57u5v.engine.Game;
import tk.ju57u5v.engine.GameObject;
import tk.ju57u5v.engine.Kamera;
import tk.ju57u5v.engine.world.Tile;

public class MiniMap extends GameObject {

	BufferedImage map;

	public MiniMap(Game game, BufferedImage map) {
		super(game);
		this.map = map;
		setPosition(-10000, -10000);
		setWidth(100000);
		setHeight(100000);
		initialise();
	}

	@Override
	public void render (Graphics2D g) {
		g.drawImage(map, 0, 0, null);
		g.setColor(new Color(0f, 0.255f, 0.255f, 0.5f));
		
		int x = game.getKamera().getX()/Tile.TILEWIDTH;
		int y = game.getKamera().getY()/Tile.TILEHEIGHT;
		int width = game.getKamera().getWidth()/Tile.TILEWIDTH;
		int height = game.getKamera().getHeight()/Tile.TILEHEIGHT;

		g.fillRect(x, y, width, height);
	}
	
	public void saveMap() {
		try {
			ImageIO.write(map, "png", new File(game.getResourceManager().getBasePath(), "map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
