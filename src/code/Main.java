/* Created by Bartosz Kosakowski
 * April 9th, 2018
 * Main class to run the game or whatever lol
 */
package code;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame test = new JFrame("test");
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
		test.setSize(500, 500);
		test.setLocationRelativeTo(null);
		test.setResizable(false);
		
		Player play = new Player(200, 200, 0, 0, "src/images/player.png");
		JLabel lbl = new JLabel(new ImageIcon("../src/images/player.png"));
		lbl.setVisible(true);
		lbl.setLocation(50, 50);
		
		test.add(play);
		test.add(lbl);
	}//end of main
}//end of Main
