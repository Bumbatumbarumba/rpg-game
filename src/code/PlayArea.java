package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
class PlayArea extends JPanel implements ActionListener, KeyListener {
	private JFrame playArea = new JFrame("RPG Game");
	private Timer t = new Timer(10, this);
	private Player player = new Player(200, 200, 0, 0);
	private boolean[] canMove = {true, true, true, true};

	// the x and y are the starting location of the player so that
	// when we create new screens we can easily position the player
	public PlayArea(int x, int y, int w, int h) {
		// let's us do stuff with keyboard input or something lol
		this.playArea.addKeyListener(this);
		this.playArea.setFocusable(true);

		// start timer to respond to keyboard input
		t.start();
		
		// creates the play area
		//
		//NOTE: change EXIT_ON_CLOSE to be DO_NOTHING_ON_CLOSE when done!!
		//
		this.playArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.playArea.setSize(w, h);
		this.playArea.setLocationRelativeTo(null);
		this.playArea.setResizable(false);

		// creates an instance of player
		this.playArea.add(this.player);

		// NOTE TO SELF: ALWAYS MAKE THE JFRAME VISIBLE LAST!!!!
		// default will be false
		this.playArea.setVisible(false);
	}// end of constructor

	// change the visibility of the play area as needed
	public void changeVis(boolean val) {
		this.playArea.setVisible(val);
	}

	// change the location of the player
	public void changePlayerLocation(int x, int y) {
		this.player.setXpos(x);
		this.player.setYpos(y);
	}

	// updates the player location every tick and repaints the frame
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		//check if the player can move to a valid location
		//if they can move up
		if (this.player.getYpos() > 0)
			this.canMove[0] = true;
		else
			this.canMove[0] = false;
		//if they can move down
		if (this.player.getYpos() < this.playArea.getHeight())
			this.canMove[1] = true;
		else
			this.canMove[1] = false;
		//if they can move left
		if (this.player.getXpos() > 0)
			this.canMove[2] = true;
		else
			this.canMove[2] = false;
		//if they can move right
		if (this.player.getXpos() < this.playArea.getWidth())
			this.canMove[3] = true;
		else
			this.canMove[3] = false;
		*/
		this.player.playerTick();
		this.playArea.repaint();
	}

	// checks for which keys are pressed and performs the according action
	// w, a, s, d = move character up, left, down, right (respectively)
	// i = open inventory
	// esc = open pause menu
	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()) {
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
		case KeyEvent.VK_I:
			InventoryScreen playerInv = new InventoryScreen();
			break;
		case KeyEvent.VK_ESCAPE:
			EscapeMenu escapeMenu = new EscapeMenu();
			break;
		}
	}

	// when a key is released, an action is performed; basically the
	// opposite of above
	@Override
	public void keyReleased(KeyEvent k) {
		switch (k.getKeyCode()) {
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
		// prolly won't need this
	}
}// end of PlayArea class
