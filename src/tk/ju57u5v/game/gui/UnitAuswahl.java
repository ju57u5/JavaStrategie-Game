package tk.ju57u5v.game.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import tk.ju57u5v.engine.components.Renderable;
import tk.ju57u5v.engine.components.Vec2;
import tk.ju57u5v.engine.gui.GuiElement;

public class UnitAuswahl extends GuiElement{

	private boolean render=false;
	
	public UnitAuswahl() {
		super();
		setPosition(new Vec2(0, 0));
		setDimension(new Vec2(0, 0));
	}

	@Override
	public void render(Graphics2D g) {
		if (render) {
			g.setColor(Color.ORANGE);
			g.drawRect(getX(), getY(), getWidth(), getHeight());
		}
	}

	public void setRender(boolean render) {
		this.render = render;
	}
}
