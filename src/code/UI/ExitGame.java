package code.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Engine.SaveMaker;
import code.UI.Screens;

//class needed to close the game
public class ExitGame implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		SaveMaker.SaveData();
		System.exit(0);
	}
}// end of ExitGame