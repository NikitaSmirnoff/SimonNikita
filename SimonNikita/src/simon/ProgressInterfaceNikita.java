package simon;

import gui6.components.Visible;

public interface ProgressInterfaceNikita extends Visible{

	void setRound(int roundNumber);

	void setSequenceLength(int size);

	/**
	 * changes display for when game has ended
	 */
	void gameOver();

}