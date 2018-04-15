package code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//window that will come up and display the user's inventory
@SuppressWarnings("serial")
class InventoryScreen extends JPanel implements KeyListener {
	private JFrame invScreen = new JFrame("Inventory");

	public InventoryScreen() {
		// does some keylistener stuff or whatever
		this.invScreen.addKeyListener(this);
		this.invScreen.setFocusable(true);

		// creates the inventory screen
		this.invScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.invScreen.setSize(200, 300);
		this.invScreen.setLocationRelativeTo(null);
		this.invScreen.setResizable(false);
		this.invScreen.setVisible(true);
	}// end of constructor

	// when the user presses the I key on their keyboard, the
	// inventory menu closes
	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()) {
		case KeyEvent.VK_I:
			this.invScreen.dispose();
			break;
		}
	}

	// can't remove due to interfaces
	@Override
	public void keyReleased(KeyEvent arg0) {
		// probably not needed
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// probably not needed
	}
}// end of InventoryScreen class
