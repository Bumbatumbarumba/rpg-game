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
		try {
			JFrame test = new JFrame("test");
			test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			test.setSize(1000, 1000);
			test.setLocationRelativeTo(null);
			test.setResizable(false);
			
			Player play = new Player(200, 200, 0, 0, "src/images/player.png");
			
			test.add(play);
			
			//NOTE TO SELF: ALWAYS MAKE THE JFRAME VISIBLE LAST!!!!
			test.setVisible(true);
		} catch (IOException noImg){
			System.out.println("image not found");
		}
	}//end of main
}//end of Main
