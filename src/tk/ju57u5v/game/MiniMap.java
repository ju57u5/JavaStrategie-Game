package tk.ju57u5v.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.ju57u5v.engine.Game;
import tk.ju57u5v.engine.GameObject;
import tk.ju57u5v.engine.Kamera;
import tk.ju57u5v.engine.TwoDMath;
import tk.ju57u5v.engine.world.Tile;

public class MiniMap extends GameObject {

	BufferedImage map;

	public MiniMap(Game game, BufferedImage map) {
		super(game);
		this.map = map;
		// rotate();
		setPosition(-10000, -10000);
		setWidth(100000);
		setHeight(100000);
		initialise();
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(map, 800, 500, null);
		g.setColor(new Color(0f, 0.255f, 0.255f, 0.5f));

		int xpos = game.getKamera().getX();
		int ypos = game.getKamera().getY();
		int width = game.getKamera().getWidth() / Tile.TILEWIDTH;
		int height = game.getKamera().getHeight() / Tile.TILEHEIGHT;

		int x = TwoDMath.toCartX(xpos, ypos) / Tile.TILEWIDTH + 800;
		int y = TwoDMath.toCartY(xpos, ypos) / Tile.TILEHEIGHT + 500;
		/*
		 * AffineTransform old = g.getTransform(); g.rotate(Math.toRadians(-45),
		 * x, y); //g.fillRect(x, y+height/2, width, height); g.fillRect(x, y,
		 * width, height); g.setTransform(old);
		 */
		// Es wird ziehmlich aufwendig berechnet wo die Position der Kamera ist.
		// War langes getüftel. Nur verändern wenn nötig :D
		g.fillRect(xpos / Tile.TILEWIDTH + 800 + game.getTileManager().getTileWidth(), ypos / Tile.TILEHEIGHT + 500 + ((int) (0.6 * 400 / Tile.TILEWIDTH)), width, height);
	}

	public void saveMap() {
		try {
			ImageIO.write(map, "png", new File(game.getResourceManager().getBasePath(), "map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
