package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui6.ClickableScreen;
import gui6.components.Action;
import gui6.components.TextLabel;
import gui6.components.Visible;
import partnerCodeInHerePlease.Button;
import partnerCodeInHerePlease.Move;
import partnerCodeInHerePlease.Progress;

public class SimonScreenNikita extends ClickableScreen implements Runnable{

	private TextLabel label;
	private ButtonInterfaceNikita[] buttons;
	private ProgressInterfaceNikita progress;
	private ArrayList<MoveInterfaceNikita> sequence; 
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelected;

	public SimonScreenNikita(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber ++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceLength(sequence.size());
		changeText("Simon's turn.");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceNikita b = null;
		for(MoveInterfaceNikita m: sequence){
			if(b!=null){
				b.dim();
			}
			b = m.getButton();
			b.highlight();
			int sleepTime = (int)(2000*(2.0/(roundNumber+2)));
			try {
				Thread.sleep((long)sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Color[] colors = {Color.red, Color.blue, new Color(240,160,70), Color.yellow};
		String[] names = {"RED", "BLUE", "ORANGE", "YELLOW"};
		int buttonCount = 4;
		buttons = new ButtonInterfaceNikita[buttonCount];
		for(int i = 0; i < buttonCount; i++ ){
			buttons[i] = getAButton();
			buttons[i].setName(names[i]);
			buttons[i].setColor(colors[i]);
			buttons[i].setX(100 + (i *50));
			buttons[i].setY(200);
			final ButtonInterfaceNikita b = buttons[i];
			b.dim();
			buttons[i].setAction(new Action() {
				public void act() {
					if(acceptingInput){
						Thread blink = new Thread(new Runnable() {
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(sequence.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}else if(acceptingInput){
							gameOver();
							return;
						}
						if(sequenceIndex == sequence.size()){
							Thread nextRound = new Thread(SimonScreenNikita.this);
							nextRound.start();
						}
					}
				}
			});
			viewObjects.add(buttons[i]);
		}
		progress = getProgress();
		label = new TextLabel(180,30,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceNikita>();
		//add 2 moves to start
		lastSelected = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceNikita randomMove() {
		int select = (int) (Math.random()*buttons.length);
		while(select == lastSelected){
			select = (int) (Math.random()*buttons.length);
		}
		lastSelected = select;
		return new Move(buttons[select]);
	}

	private ProgressInterfaceNikita getProgress() {
		return new Progress();
	}
	
	private void gameOver() {
		progress.gameOver();
	}

	private ButtonInterfaceNikita getAButton() {
		return new Button();
	}

	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
