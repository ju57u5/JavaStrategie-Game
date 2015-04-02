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
		if (startPos.isNullVec() && Game.getBindHandler().isMouseButtonDown(1)) {
			startPos = Game.getBindHandler().getMousePosition();
		}
		
		//Während Click oder Draw
		if (Game.getBindHandler().isMouseButtonDown(1)) {
			findRect();
			unitAuswahl.setPosition(ecke);
			unitAuswahl.setDimension(dimensions);
		}
		
		//Ende von Click oder Drag leftMouse
		if (!startPos.isNullVec() && !Game.getBindHandler().isMouseButtonDown(1)) {
			//System.out.println(startPos);
			//System.out.println(!startPos.isNullVec() && !Game.getBindHandler().isMouseButtonDown(1));
			//System.out.println("ende");
			endPos = Game.getBindHandler().getMousePosition();
			//Reset
			//TODO geht auch net -.-
			//startPos.x=0.0;
			//startPos.y=0.0;
			startPos = new Vec2(0, 0);
			
			//Click
			if (startPos.equals(endPos)) {
				findUnit(startPos);
				findHouse(startPos);
			} else {
				findUnits(startPos, endPos);
				findHouses(startPos, endPos);
			}
		}
	}
	
	private void findRect() {
		Vec2 first = new Vec2(0, 0);
		first.x = startPos.x < endPos.x ? startPos.x : endPos.x;
		first.y = startPos.y < endPos.y ? startPos.y : endPos.y;
		
		Vec2 second = new Vec2(0, 0);
		second.x = startPos.x >= endPos.x ? startPos.x : endPos.x;
		second.y = startPos.y >= endPos.y ? endPos.x : endPos.y;
		
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
