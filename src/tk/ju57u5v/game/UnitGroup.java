package tk.ju57u5v.game;

import java.util.ArrayList;

public class UnitGroup {

	ArrayList<Unit> units = new ArrayList<Unit>();

	public void addUnit(Unit u) {
		this.units.add(u);
	}

	public void moveTo(int x, int y) {
		for (int c = 0; c < this.units.size(); c++) {
			this.units.get(c).moveTo(x, y);
		}
	}
	
	public void clear () {
		this.units = new ArrayList<Unit>();
	}
}
