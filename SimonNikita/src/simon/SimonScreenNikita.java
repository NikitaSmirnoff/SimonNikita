package simon;

import java.awt.TextField;
import java.util.ArrayList;

import gui.screens.ClickableScreen;

public class SimonScreenNikita extends ClickableScreen implements Runnable {
	
	public static TextField text;
	public static ButtonInterfaceNikita[] button;
	public static ProgressInterfaceNikita progress;
	public static ArrayList<MoveInterfaceNikita> array;
	
	public int roundNumber;
	public boolean acceptingInput;
	public int sequenceIndex;
	public int lastSelectedButton;

	public SimonScreenNikita(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	public void initAllObjects (List<Visible> viewObjects){
		addButtons()
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterface>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

}
