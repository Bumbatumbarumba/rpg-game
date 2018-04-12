package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Screens extends JPanel{
	public static void initPlayAreas(){
		PlayArea area1 = new PlayArea(200,200, 1000, 1000);
		System.out.println("area generated");
		try {
			int counter = 5;
			System.out.println("waiting 5 second");
			while (counter > 0){
				System.out.println(counter);
				--counter;
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("making area visible");
		area1.changeVis(true);
	}
}//end of Screens


@SuppressWarnings("serial")
class PlayArea extends JPanel implements ActionListener{
	private JFrame test = new JFrame("test");
	private Timer t = new Timer(10, this);
	
	//the x and y are the starting location of the player so that
	//when we create new screens we can easily position the player
	public PlayArea(int x, int y, int w, int h){
		
		//creates the play area
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(w, h);
		test.setLocationRelativeTo(null);
		test.setResizable(false);
		
		//creates an instance of player
		Player player;
		try {
			player = new Player(x, x, 0, 0, "src/images/player.png");
			test.add(player);
		} catch (IOException e) {
			//only thrown if the game can't find the player image for whatever reason
			System.out.println("couldn't find no gosh darn image file");
		}
		
		//NOTE TO SELF: ALWAYS MAKE THE JFRAME VISIBLE LAST!!!!
		//default will be false
		test.setVisible(false);
	}//end of constructor
	
	//change the visibility of the play area as needed
	public void changeVis(boolean val){
		this.test.setVisible(val);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}//end of PlayArea class