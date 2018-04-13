package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//static class that contains all of the screens and stuff required to run the game
@SuppressWarnings("serial")
public class Screens extends JPanel{
	private static PlayArea area1;
	private static PlayArea area2;
	
	public static void runScreens(){
		initPlayAreas();
		area1.changeVis(true);
	}
	
	public static void initPlayAreas(){
		area1 = new PlayArea(200,200, 500, 500);
		area2 = new PlayArea(200,200, 500, 1000);
	}//end of initPlayAreas
	
	
}//end of Screens

//screens where actual gameplay occurs (ie, not menus)
@SuppressWarnings("serial")
class PlayArea extends JPanel implements ActionListener, KeyListener{
	private JFrame playArea = new JFrame("RPG Game");
	private Timer t = new Timer(10, this);
	private Player player = new Player(100, 100, 0, 0);
	
	//the x and y are the starting location of the player so that
	//when we create new screens we can easily position the player
	public PlayArea(int x, int y, int w, int h){
		//let's us do stuff with keyboard input or something lol
		this.playArea.addKeyListener(this);
		this.playArea.setFocusable(true);
		
		//start timer to respond to keyboard input
		t.start();
		
		//creates the play area
		this.playArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.playArea.setSize(w, h);
		this.playArea.setLocationRelativeTo(null);
		this.playArea.setResizable(false);
		
		//creates an instance of player
		this.playArea.add(this.player);
		
		//NOTE TO SELF: ALWAYS MAKE THE JFRAME VISIBLE LAST!!!!
		//default will be false
		this.playArea.setVisible(false);
	}//end of constructor
	
	//change the visibility of the play area as needed
	public void changeVis(boolean val){
		this.playArea.setVisible(val);
	}
	
	//change the location of the player
	public void changePlayerLocation(int x, int y){
		this.player.setXpos(x);
		this.player.setYpos(y);
	}
	
	//updates the player location every tick and repaints the frame
	@Override
	public void actionPerformed(ActionEvent e) {
		this.player.playerTick();
		this.playArea.repaint();
	}
	
	//checks for which keys are pressed and performs the according action
	//w, a, s, d = move character up, left, down, right (respectively)
	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()){
		case KeyEvent.VK_W:
			this.player.setDy(-2);
			break;
		case KeyEvent.VK_S:
			this.player.setDy(2);
			break;
		case KeyEvent.VK_A:
			this.player.setDx(-2);
			break;
		case KeyEvent.VK_D:
			this.player.setDx(2);
			break;	
		case KeyEvent.VK_J:
			System.out.println("test");
			break;
		}
	}
	
	//when a key is released, an action is performed; basically the
	//opposite of above
	@Override
	public void keyReleased(KeyEvent k) {
		switch (k.getKeyCode()){
		case KeyEvent.VK_W:
			this.player.setDy(0);
			break;
		case KeyEvent.VK_S:
			this.player.setDy(0);
			break;
		case KeyEvent.VK_A:
			this.player.setDx(0);
			break;
		case KeyEvent.VK_D:
			this.player.setDx(0);
			break;		
		}	
	}

	@Override
	public void keyTyped(KeyEvent k) {
		//prolly won't need this
	}
}//end of PlayArea class

//window that will come up and display the user's inventory 
@SuppressWarnings("serial")
class InventoryScreen extends JPanel implements KeyListener{
	private JFrame playerInv = new JFrame("Inventory");
	public InventoryScreen(){
		
	}//end of constructor
	
	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()){
		case KeyEvent.VK_W:
			
			break;	
		}	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}//end of InventoryScreen class