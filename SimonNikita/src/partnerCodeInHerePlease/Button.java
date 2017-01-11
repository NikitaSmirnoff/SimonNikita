package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Action;
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

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAction(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub
		
	}

}
