package simon;

import java.awt.Color;

import gui6.components.Action;
import gui6.components.Clickable;

public interface ButtonInterfaceNikita extends Clickable{

	void setColor(Color color);

	void highlight();

	void dim();

	void setAction(Action action);
	
	void setName(String name);

	void setX(int i);

	void setY(int i);
}
