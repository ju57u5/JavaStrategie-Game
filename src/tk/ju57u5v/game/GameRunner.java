package tk.ju57u5v.game;

import tk.ju57u5v.engine.Game;
import tk.ju57u5v.engine.TwoDMath;
import tk.ju57u5v.engine.components.Entity;
import tk.ju57u5v.engine.components.Vec2;
import tk.ju57u5v.game.gui.UnitAuswahl;

public class GameRunner extends tk.ju57u5v.engine.GameRunner {

	private Vec2 startPos = new Vec2(0, 0);
	private Vec2 endPos = new Vec2(0, 0);
	private UnitAuswahl unitAuswahl = new UnitAuswahl();
	private Vec2 ecke = new Vec2(0, 0);
	private Vec2 dimensions = new Vec2(0, 0);

	/**
	 * Player Object des Spiels
	 */
	protected Player player = new Player();
	
	public GameRunner() {
		super();
	}

	@Override
	public void tick() {
		doKeys();
		doMouse();
	}

	private void doMouse() {

		// Start von Click oder Drag leftMouse
		if (this.startPos.isNullVec() && Game.getBindHandler().isMouseButtonDown(1)) {
			this.startPos = Game.getBindHandler().getMousePosition();
			//Um ein aufblinkendes Rechteck zu verhindern
			this.endPos = new Vec2(this.startPos);
			createRect();
			this.unitAuswahl.setRender(true);
		}

		// Während Click oder Draw
		else if (Game.getBindHandler().isMouseButtonDown(1)) {
			this.endPos = Game.getBindHandler().getMousePosition();
			createRect();
		}

		// Ende von Click oder Drag leftMouse
		else if (!this.startPos.isNullVec() && !Game.getBindHandler().isMouseButtonDown(1)) {
			this.endPos = Game.getBindHandler().getMousePosition();
			
			createRect();
			// Click
			if (this.startPos.equals(this.endPos)) {
				findUnit();
				findHouse();
			} else {
				findUnits();
				findHouses();
			}
			this.startPos.x = 0;
			this.startPos.y = 0;
			this.unitAuswahl.setRender(false);
			//Kein Drag mehr zeichnen
			createRect();
		} 
		
		//Links Click
		else if (Game.getBindHandler().isMouseButtonDown(3)) {
			Vec2 pos = Game.getBindHandler().getMousePosition();
			pos = Game.getKamera().toRealPosition(pos);
			pos = TwoDMath.toCartPosition(pos);
			this.player.activeGroup.moveTo(pos.getX(), pos.getY());
		}
	}

	private void createRect() {
		Vec2 first = new Vec2(Math.min(this.startPos.x, this.endPos.x), Math.min(this.startPos.y, this.endPos.y));
		Vec2 second = new Vec2(Math.max(this.startPos.x, this.endPos.x), Math.max(this.startPos.y, this.endPos.y));

		this.ecke = new Vec2(first);
		this.dimensions = second.minus(first);
		
		this.unitAuswahl.setPosition(this.ecke);
		this.unitAuswahl.setDimension(this.dimensions);
	}

	private void findHouses() {
		
	}

	private void findHouse() {
		
	}

	private void findUnit() {
		for (int c = 0; c < Game.getRenderer().getEntities().size(); c++) {
			Entity e = Game.getRenderer().getEntities().get(c);
			if (TwoDMath.isRectInRect(e.getRelativIsoX(), e.getRelativIsoY(), e.getWidth(), e.getHeight(), ecke.getX(), ecke.getY(), dimensions.getX(), dimensions.getY()) && e instanceof Unit) {
				player.activeGroup.addUnit((Unit) e);
			}
		}
	}

	private void findUnits() {
		for (int c = 0; c < Game.getRenderer().getEntities().size(); c++) {
			Entity e = Game.getRenderer().getEntities().get(c);
			if (TwoDMath.isRectInRect(e.getRelativIsoX(), e.getRelativIsoY(), e.getWidth(), e.getHeight(), ecke.getX(), ecke.getY(), dimensions.getX(), dimensions.getY()) && e instanceof Unit) {
				player.activeGroup.addUnit((Unit) e);
			}
		}
	}

	private void doKeys() {
		if (Game.getBindHandler().bindActive("+left")) {
			Game.getKamera().setX(Game.getKamera().getX() - 5);
		}
		if (Game.getBindHandler().bindActive("+right")) {
			Game.getKamera().setX(Game.getKamera().getX() + 5);
		}
		if (Game.getBindHandler().bindActive("+up")) {
			Game.getKamera().setY(Game.getKamera().getY() - 5);
		}
		if (Game.getBindHandler().bindActive("+down")) {
			Game.getKamera().setY(Game.getKamera().getY() + 5);
		}
	}
}
