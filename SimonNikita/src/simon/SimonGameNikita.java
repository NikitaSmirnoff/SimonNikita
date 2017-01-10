package simon;

import gui.GUIApplication;
import gui.screens.MovementScreen;

public class SimonGameNikita extends GUIApplication {

	public static SimonGameNikita game;
	public static SimonScreenNikita simonScreen;
	
	public SimonGameNikita(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		simonScreen = new MovementScreen(getWidth(), getHeight());
		setScreen(simonScreen);

	}
	
	public static void main(String[] args) {
		game = new SimonGameNikita(800,600);
		Thread app = new Thread(game);
		app.start();
	}

}
