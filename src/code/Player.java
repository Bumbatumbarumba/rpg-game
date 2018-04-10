/* Created by Bartosz Kosakowski
 * April 9th, 2018
 * Represents the character that the player will have control over
 * 
 * IMPLEMENT KEYPRESS STUFF: move left, right, up, down, open inventory,
 * pause game (STOPS ALL ACTIVITY; OR MAYBE NOT SO THAT IT'S MORE CHALLENGING
 * FOR THE PLAYER LOL), use item (equip health item, magic item, useable item) 
 */
package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Player extends Character{
	
	private int dx, dy;
	
	public Player(int x, int y, int dx, int dy, String img) throws IOException{
		setXpos(x);
		setYpos(y);
		this.dx = dx;
		this.dy = dy;
		setCharimg(ImageIO.read(new File(img)));
	}
	
	public void playerTick(){
		
	}
	
	//paints the player
	public void paintComponent(Graphics g) {
		//g.drawImage(getCharimg(), getXpos(), getYpos(), this);
		g.setColor(Color.BLACK);
		g.fillRect(getXpos(), getYpos(), 50, 50);
	}
}//end of Player
