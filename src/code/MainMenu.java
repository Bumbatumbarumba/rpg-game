/* Created by Bartosz Kosakowski
 * April 20th, 2018
 * Stores stuff related to creating the main menu and its functionality
 */
package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//CHANGE THE TEXTURES OF ALL OF THE BUTTONS, BACKGROUND, TITLE, ETC
@SuppressWarnings("serial")
public class MainMenu extends JPanel{
	private JFrame menuWindow = new JFrame("RPG Game");
	
	private JButton startButton = new JButton("Start Game");
	private JButton controlsButton = new JButton("Controls");
	private JButton exitButton = new JButton("Exit Game");
	
	
	public MainMenu(){
		initScreen();
	}//end of constructor
	
	private void initScreen(){
		this.menuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.menuWindow.setSize(300, 300);
		this.menuWindow.setLocationRelativeTo(null);
		this.menuWindow.setResizable(false);
		this.menuWindow.setVisible(true);
		
		initButtons();
	}
	
	private void initButtons(){
		this.startButton.addActionListener(new StartGame());
		this.exitButton.setBounds(150, 100, 100, 50);
		
		this.exitButton.addActionListener(new ExitGame());
		this.exitButton.setBounds(150, 300, 100, 50);
	}
	
}//end of main menu

//closes the main menu and loads the first area
class StartGame implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Screens.changeVisiblePlayArea(0);
	}
}// end of StartGame

//used to create and show the control screen
class ControlsMenu implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e){
		//make this open up a window showing the controls
	}
}//end of ControlsMenu