package code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//static class that contains all of the screens and stuff required to run the game
@SuppressWarnings("serial")
public class Screens extends JPanel {
	// ares where the user can interact - POSSIBLY MAKE INTO ARRAYLIST
	private static PlayArea area1;
	private static PlayArea area2;

	// used to keep track of the player inventory
	private static ArrayList<Item> playerItems = new ArrayList<Item>();

	public static void runScreens() {
		initPlayAreas();
		area2.changeVis(true);
		area1.changeVis(true);
	}

	public static void initPlayAreas() {
		area1 = new PlayArea(200, 200, 500, 500);
		area2 = new PlayArea(200, 200, 750, 750);
	}// end of initPlayAreas

	//
	public static void updateInventory(Item item) {
		if (playerItems.contains(item)) {
			playerItems.get(playerItems.indexOf(item)).increaseQuantity(item.getQuantity());
		} else {
			playerItems.add(item);
		}
	}// end of updateInventory

}// end of Screens