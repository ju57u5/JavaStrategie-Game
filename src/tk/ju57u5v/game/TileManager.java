package tk.ju57u5v.game;

import java.awt.Color;
import java.awt.Graphics2D;

import tk.ju57u5v.engine.Game;
import tk.ju57u5v.engine.TwoDMath;
import tk.ju57u5v.engine.world.Tile;


public class TileManager extends tk.ju57u5v.engine.world.TileManager{

	public TileManager(Game game, int width, int height) {
		super(game, width, height);
	}
	
	@Override
	public void handleHeight(int x,int y, float height, Graphics2D g) {
		Tile tile;
		if (Math.abs(height)<0.6) {
			tile = new Tile(game, 3);
			placeTile(tile, x, y);
			tile.setZ((int) (0.6*400));

			g.setColor(Color.BLUE);
		} else if (Math.abs(height)<0.63){
			tile = new Tile(game, 2);
			placeTile(tile, x, y);

			g.setColor(Color.YELLOW);
			tile.setZ((int) (height*400));
		}else if (Math.abs(height)>0.8){
			tile = new Tile(game, 1);
			placeTile(tile, x, y);
			tile.setZ((int) (height*400));

			g.setColor(Color.LIGHT_GRAY);
		} else {
			tile = new Tile(game, 0);
			placeTile(tile, x, y);
			tile.setZ((int) (height*400));

			g.setColor(Color.GREEN);
		}
		g.drawRect(TwoDMath.toIsoX(x, y)+getTiles().length, TwoDMath.toIsoY(x, y), 1, 1);
	}

}
