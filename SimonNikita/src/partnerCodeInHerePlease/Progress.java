package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui6.components.Component;
import simon.ProgressInterfaceNikita;

public class Progress extends Component implements ProgressInterfaceNikita {

	private String round;
	private String sequence;
	private boolean isGameOver;

	public Progress() {
		super(30, 30, 120, 50);
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(isGameOver){
			g.setColor(Color.white);
			g.fillRect(0, 0, 120, 50);
			g.setColor(Color.black);
			String go = "GAME OVER!";
			g.drawString(go, (120 - fm.stringWidth(go))/2, 20);
			g.drawString(sequence, (120 - fm.stringWidth(sequence))/2, 40);
		}else{
			g.setColor(Color.white);
			g.fillRect(0, 0, 120, 50);
			g.setColor(Color.black);
			g.drawRect(0, 0, 120-1, 50-1);
			if(round !=null && sequence != null){
				g.drawString(round, (120 - fm.stringWidth(round))/2, 20);
				g.drawString(sequence, (120 - fm.stringWidth(sequence))/2, 40);
			}
		}
	}

	public void setRound(int roundNumber) {
		round = "Round "+roundNumber;
		update();
	}

	public void gameOver() {
		isGameOver = true;
		update();
	}

	@Override
	public void setSequenceLength(int size) {
		sequence = "Sequence length "+size;
		update();
	}
}
