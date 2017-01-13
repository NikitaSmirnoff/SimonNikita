package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import gui6.components.Action;
import gui6.components.Component;
import simon.ButtonInterfaceNikita;

public class Button extends Component implements ButtonInterfaceNikita {

	private Action action;
	private Color c;
	private boolean isHighlighted;
	private String name;
	private int x;
	private int y;
	private Color displayColor;

	public Button() {
		super(0, 0, 50, 50);
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+25), 2)+Math.pow(y-(getY()+25), 2));
		return distance < 25;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(displayColor != null) {
			g.setColor(displayColor);
		}
		else {
			g.setColor(Color.gray);
		}
		g.fillRect(0, 0, 50, 50);
		g.setColor(Color.black);
		g.drawRect(0, 0, 50-1, 50-1);
	}

	@Override
	public void setColor(Color color) {
		this.c = color;
		displayColor = c;
		update();
	}

	@Override
	public void highlight() {
		if(c != null){
			displayColor = c;
		}
		isHighlighted = true;
		update();
	}

	@Override
	public void dim() {
		displayColor = Color.white;
		isHighlighted = false;
		update();
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void setName(String string) {
		this.name = string;
	}
}
