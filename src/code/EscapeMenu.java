package code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//menu that appears when the user presses the escape menu
@SuppressWarnings("serial")
class EscapeMenu extends JPanel implements KeyListener {
	private JFrame escMenu = new JFrame("Paused");
	//exit button ADD MORE BUTTONS
	private JButton exitButton = new JButton("Exit");
	
	public EscapeMenu() {
		// does some keylistener stuff or whatever
		this.escMenu.addKeyListener(this);
		this.escMenu.setFocusable(true);

		// creates the inventory screen
		this.escMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.escMenu.setSize(300, 300);
		this.escMenu.setLocationRelativeTo(null);
		this.escMenu.setResizable(false);
		this.escMenu.setLayout(new FlowLayout(FlowLayout.CENTER));  
		
		//adds exit game button
		exitButton.addActionListener(new ExitGame());
		exitButton.setBounds(150, 150, 100, 50);
		this.escMenu.add(exitButton);
		
		this.escMenu.setVisible(true);
	}

	// when the escape key is pressed, the escape menu closes
	@Override
	public void keyPressed(KeyEvent k) {
		switch (k.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			this.escMenu.dispose();
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
}// end of EscapeMenu class

//class needed to close the game
class ExitGame implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}// end of NoPop
