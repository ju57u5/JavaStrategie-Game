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
import tk.ju57u5v.engine.gui.GuiElement;
import tk.ju57u5v.engine.world.Tile;

public class MiniMap extends GuiElement {

	BufferedImage map;

	public MiniMap(Game game, BufferedImage map) {
		super(game);
		this.map = map;
		setPosition(800, 500);
		setWidth(map.getWidth());
		setHeight(map.getHeight());
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

		// Es wird ziehmlich aufwendig berechnet wo die Position der Kamera ist.
		// War langes getüftel. Nur verändern wenn nötig :D
		g.fillRect(xpos / Tile.TILEWIDTH + getX() + game.getTileManager().getTileWidth(), ypos / Tile.TILEHEIGHT + getY() + ((int) (0.6 * 400 / Tile.TILEHEIGHT)), width, height);
	}

	public void saveMap() {
		try {
			ImageIO.write(map, "png", new File(game.getResourceManager().getBasePath(), "map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onClick (int x, int y) {
		int xpos = (x-game.getTileManager().getTileWidth())*Tile.TILEWIDTH;
		int ypos = (y-game.getTileManager().getTileHeight() - ((int) (0.6 * 400 / Tile.TILEHEIGHT))+getY())*Tile.TILEHEIGHT;
		game.getKamera().setPosition(xpos-game.getKamera().getWidth()/2, ypos-game.getKamera().getHeight()/2);
	}
}
