package tk.ju57u5v.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import tk.ju57u5v.engine.Entity;
import tk.ju57u5v.engine.Game;
import tk.ju57u5v.engine.TwoDMath;

public class StrategieGame extends Game implements MouseWheelListener, tk.ju57u5v.engine.input.MouseListener {

	Dorfzentrum dorfzentrum;

	public StrategieGame() {
		super();
		config();
		initalizeGame();
		
		dorfzentrum = new Dorfzentrum(this);
		dorfzentrum.setPosition(100, 100);
		Dorfzentrum dorfzentrum2 = new Dorfzentrum(this);
		dorfzentrum2.setPosition(300, 300);
	}

	public static void main(String[] args) {
		new StrategieGame();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		kamera.setWidth(kamera.getWidth() - e.getWheelRotation() * 10);
		kamera.setHeight(kamera.getHeight() - e.getWheelRotation() * 10);
	}

	@Override
	public void mousedrag(int startx, int starty, int endx, int endy, MouseEvent event) {
		int firstx = startx < endx ? startx : endx;
		int firsty = starty < endy ? starty : endy;
		int secondx = startx >= endx ? startx : endx;
		int secondy = starty >= endy ? starty : endy;
		
		if ((startx != endx || starty != endy)) //Wenn kein drag erfolgt ist cleare
			((Player) player).activeGroup.clear();

		for (int c = 0; c < gameRunner.getRenderer().getEntities().size(); c++) {
			Entity e = gameRunner.getRenderer().getEntities().get(c);
			if (TwoDMath.isRectInRect(e.getX(), e.getY(), e.getWidth(), e.getHeight(), kamera.toRealX(firstx), kamera.toRealY(firsty), secondx - firstx, secondy - firsty) && e instanceof Unit) {
				((Player) player).activeGroup.addUnit((Unit) e);
			}
		}
	}

	@Override
	public void mouseclick(int x, int y, MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			((Player) player).activeGroup.clear();
		} else {
			((Player) player).activeGroup.moveTo(kamera.toRealX(e.getX()), kamera.toRealY(e.getY()));
		}
	}
	
	public void config() {
		gameRunner = new GameRunner(this);
		player = new Player();
		window.addMouseWheelListener(this);
		mouseHandler.addMouseListener(this);
		mouseHandler.setRightDrag(false);
		mouseHandler.setDrawDrag(true);
	}

}
