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
	//the start menu of the game
	private static MainMenu startScreen;
	
	// ares where the user can interact - POSSIBLY MAKE INTO ARRAYLIST
	private static PlayArea[] playAreas = new PlayArea[10];

	// used to keep track of the player inventory
	private static ArrayList<Item> playerItems = new ArrayList<Item>();
	
	public static void runScreens() {
		initPlayAreas();
		startScreen = new MainMenu();
	}

	private static void initPlayAreas() {
		playAreas[0] = new PlayArea(200, 200, 750, 750);
		playAreas[1] = new PlayArea(200, 200, 750, 750);
		playAreas[2] = new PlayArea(200, 200, 750, 750);
		playAreas[3] = new PlayArea(200, 200, 750, 750);
		playAreas[4] = new PlayArea(200, 200, 750, 750);
		playAreas[5] = new PlayArea(200, 200, 750, 750);
		playAreas[6] = new PlayArea(200, 200, 750, 750);
		playAreas[7] = new PlayArea(200, 200, 750, 750);
		playAreas[8] = new PlayArea(200, 200, 750, 750);
		playAreas[9] = new PlayArea(200, 200, 750, 750);
	}// end of initPlayAreas

	//if the item exists in the player inventory, we update its quantity,
	//otherwise we add it as a new item
	public static void updateInventory(Item item) {
		if (playerItems.contains(item)) {
			playerItems.get(playerItems.indexOf(item)).increaseQuantity(item.getQuantity());
		} else {
			playerItems.add(item);
		}
	}// end of updateInventory
	
	public static void changeVisiblePlayArea(int screen){
		for (int i = 0; i < playAreas.length; i++){
			playAreas[i].changeVis(false);
		}
		playAreas[screen].changeVis(true);
	}
	
	public static MainMenu getStartScreen(){
		return startScreen;
	}
}// end of Screens