package tk.ju57u5v.game;

import tk.ju57u5v.engine.Game;
import tk.ju57u5v.engine.components.Vec2;
import tk.ju57u5v.game.gui.UnitAuswahl;

public class GameRunner extends tk.ju57u5v.engine.GameRunner {

	private Vec2 startPos = new Vec2(0, 0);
	private Vec2 endPos = new Vec2(0, 0);
	private UnitAuswahl unitAuswahl = new UnitAuswahl();
	private Vec2 ecke = new Vec2(0,0);
	private Vec2 dimensions = new Vec2(0,0);
	
	public GameRunner() {
		super();
	}
	
	@Override
	public void work() {
		doKeys();
		doMouse();
	}
	
	private void doMouse() {
		//Start von Click oder Drag leftMouse
		if (this.startPos.isNullVec() && Game.getBindHandler().isMouseButtonDown(1)) {
			System.out.println("test");
			this.startPos = Game.getBindHandler().getMousePosition();
		}
		
		//Während Click oder Draw
		if (Game.getBindHandler().isMouseButtonDown(1)) {
			this.endPos = Game.getBindHandler().getMousePosition();
			findRect();
			//System.out.println(ecke+" "+dimensions);
			this.unitAuswahl.setPosition(this.ecke);
			this.unitAuswahl.setDimension(this.dimensions);
		}
		
		//Ende von Click oder Drag leftMouse
		if (!this.startPos.isNullVec() && !Game.getBindHandler().isMouseButtonDown(1)) {
			//System.out.println(startPos);
			//System.out.println(!startPos.isNullVec() && !Game.getBindHandler().isMouseButtonDown(1));
			//System.out.println("ende");
			this.endPos = Game.getBindHandler().getMousePosition();
			//Reset
			//TODO geht auch net -.-
			//startPos.x=0.0;
			//startPos.y=0.0;
			
			//Click
			if (this.startPos.equals(this.endPos)) {
				findUnit(this.startPos);
				findHouse(this.startPos);
			} else {
				findUnits(this.startPos, this.endPos);
				findHouses(this.startPos, this.endPos);
			}
			this.startPos = new Vec2(0, 0);
		}
	}
	
	private void findRect() {
		System.out.println(this.startPos+" "+this.endPos);
		Vec2 first = new Vec2(Math.min(this.startPos.x, this.endPos.x), Math.min(this.startPos.y, this.endPos.y));
		Vec2 second = new Vec2(Math.max(this.startPos.x, this.endPos.x), Math.max(this.startPos.y, this.endPos.y));
		
		this.ecke = first;
		this.dimensions = second.minus(first);
	}

	private void findHouses(Vec2 startPos, Vec2 endPos) {
		
	}

	private void findHouse(Vec2 startPos) {
		
	}

	private void findUnit(Vec2 startPos) {
		
	}

	private void findUnits(Vec2 startPos, Vec2 endPos) {
		
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
