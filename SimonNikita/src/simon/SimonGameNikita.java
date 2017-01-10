package simon;

import gui.GUIApplication;

public class SimonGameNikita extends GUIApplication {

	public SimonGameNikita(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenNikita s = new SimonScreenNikita(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		SimonGameNikita game = new SimonGameNikita(800, 500);
		Thread app = new Thread(game);
		app.start();
	}

}
