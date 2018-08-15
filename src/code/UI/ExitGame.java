package code.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class needed to close the game
public class ExitGame implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}// end of ExitGame