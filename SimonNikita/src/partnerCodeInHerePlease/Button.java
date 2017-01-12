package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.Component;
import simon.ButtonInterfaceNikita;

public class Button extends Component implements ButtonInterfaceNikita {

	private Action action;
	private Color c;
	private boolean isHighlighted;
	private String name;
	private int x;
	private int y;

	public Button() {
		super(0, 0, 50, 50);
	}

	public void act() {
		action.act();
	}

	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+25), 2)+Math.pow(y-(getY()+25), 2));
		return distance < 25;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(c != null) {
			g.setColor(c);
		}
		else g.setColor(Color.gray);
		g.fillOval(0, 0, 50, 50);
		g.setColor(Color.black);
		g.drawOval(0, 0, 49, 49);
		if(isHighlighted){
			g.setColor(Color.white);
			Polygon p = new Polygon();
			int s = (int)(31.25);
			int t = (int)(10)+4;
			p.addPoint(s-4, t-4);
			p.addPoint(s+7, t-2);
			p.addPoint(s+10, t);
			p.addPoint(s+14, t+10);
			p.addPoint(s+12, t+14);
			p.addPoint(s+8, t+3);
			g.fill(p);
		}
	}

	public void setColor(Color color) {
		c = color;
		update();
	}

	public void highlight() {
		if(c != null){
			isHighlighted = true;
			update();
		}
	}

	public void dim() {
		c = Color.gray;
		isHighlighted = false;
		update();
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setX(int i) {
		this.x = i;
	}

	public void setY(int i) {
		this.y = i;
	}
}
