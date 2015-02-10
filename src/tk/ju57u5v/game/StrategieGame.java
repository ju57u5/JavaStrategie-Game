package tk.ju57u5v.game;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import tk.ju57u5v.engine.Entity;
import tk.ju57u5v.engine.Game;
import tk.ju57u5v.engine.TwoDMath;
import tk.ju57u5v.engine.netcode.Client;
import tk.ju57u5v.engine.netcode.Server;

public class StrategieGame extends Game implements MouseWheelListener, tk.ju57u5v.engine.input.MouseListener {

	Dorfzentrum dorfzentrum;

	public StrategieGame(String[] args) {
		super(args);
		config();
		server = new Server(this);
		client = new Client(this, "127.0.0.1", 27015);
		initalizeGame();
		BufferedImage map = tileManager.generateWorld(Math.round(Math.random() * 100 * Math.random() * 10));
		new MiniMap(this, map).saveMap();
		new Dorfzentrum(this).setPosition(100, 100);
	}

	public static void main(String[] args) {
		new StrategieGame(args);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// kamera.setWidth(kamera.getWidth() - e.getWheelRotation() * 10);
		// kamera.setHeight(kamera.getHeight() - e.getWheelRotation() * 10);
	}

	@Override
	public void mousedrag(int startx, int starty, int endx, int endy, MouseEvent event) {
		int firstx = startx < endx ? startx : endx;
		int firsty = starty < endy ? starty : endy;
		int secondx = startx >= endx ? startx : endx;
		int secondy = starty >= endy ? starty : endy;

		if ((startx != endx || starty != endy)) // Wenn kein drag erfolgt ist
												// cleare
			((Player) player).activeGroup.clear();

		for (int c = 0; c < gameRunner.getRenderer().getEntities().size(); c++) {
			Entity e = gameRunner.getRenderer().getEntities().get(c);
			if (TwoDMath.isRectInRect(e.getRelativIsoX(), e.getRelativIsoY(), e.getWidth(), e.getHeight(), firstx, firsty, secondx - firstx, secondy - firsty) && e instanceof Unit) {
				((Player) player).activeGroup.addUnit((Unit) e);
			}
		}
	}

	@Override
	public void mouseclick(int x, int y, MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			((Player) player).activeGroup.clear();
		} else {
			int movex = TwoDMath.toCartX(kamera.toRealX(e.getX()), kamera.toRealY(e.getY()));
			int movey = TwoDMath.toCartY(kamera.toRealX(e.getX()), kamera.toRealY(e.getY()));
			((Player) player).activeGroup.moveTo(movex, movey);
		}
	}

	public void config() {
		gameRunner = new GameRunner(this);
		player = new Player();
		window.setBackground(Color.black);
		window.addMouseWheelListener(this);
		mouseHandler.addMouseListener(this);
		mouseHandler.setRightDrag(false);
		mouseHandler.setDrawDrag(true);
	}

}
