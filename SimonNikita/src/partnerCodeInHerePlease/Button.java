package partnerCodeInHerePlease;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;
import simon.ButtonInterfaceNikita;

public class Button extends Component implements ButtonInterfaceNikita {

	public Button() {
		super(0, 0, 50, 50);
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		return (getX() < x && x < getX()+getWidth() && getY() < y && y < getY()+getHeight());
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

}
