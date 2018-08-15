/* Created by Bartosz Kosakowski
 * April 9th, 2018
 * Represents the character that the player will have control over
 * 
 * IMPLEMENT KEYPRESS STUFF: move left, right, up, down, open inventory,
 * pause game (STOPS ALL ACTIVITY; OR MAYBE NOT SO THAT IT'S MORE CHALLENGING
 * FOR THE PLAYER LOL), use item (equip health item, magic item, useable item) 
 */
package code.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Player extends Character{
	
	private int dx, dy;
	
	public Player(int x, int y, int dx, int dy){
		setXpos(x);
		setYpos(y);
		this.dx = dx;
		this.dy = dy;
		initImg();
	}
	
	//initializes the image to represent the player by grabbing the img from images/
	private void initImg(){
		try {
			setCharimg(ImageIO.read(new File("src/images/player.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//updates the player's position by dx and dy every call
	public void playerTick(){
		setXpos(getXpos()+dx);
		setYpos(getYpos()+dy);
	}
	
	//paints the player
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(getCharimg(), getXpos(), getYpos(), this);
	}
	
	//change the dx and dy of the player
	public void setDx(int dx){
		this.dx = dx;
	}
	public void setDy(int dy){
		this.dy = dy;
	}
}//end of Player
