package partnerCodeInHerePlease;

import simon.ButtonInterfaceNikita;
import simon.MoveInterfaceNikita;

public class Move implements MoveInterfaceNikita {
	
	private ButtonInterfaceNikita b;

	public Move(ButtonInterfaceNikita b) {
		this.b = b;
	}

	public ButtonInterfaceNikita getButton() {
		return b;
	}
}
