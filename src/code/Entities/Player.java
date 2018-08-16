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
	private int rollSpeed = 3;
	private boolean playerRolled = false;
	
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
	
	//change the dx and dy of the player when moving normally 
	//(ie, pressing w, a, s, d)
	//neg dx = a
	//pos dx = d
	//neg dy = w
	//pos dy = s
	public void setDx(int dx){
		this.dx = dx;
	}
	public void setDy(int dy){
		this.dy = dy;
	}
	
	public void modifyRollSpeed(int mod){
		this.rollSpeed += mod;
	}
	
	public int getRollSpeed(){
		return this.rollSpeed;
	}
	//allows the player to perform a roll
	//what this means is that they can't take damage for half a second
	//
	//CURRENTLY ONLY FLINGS THE PLAYER FORWARD FOR HALF A SECOND, DOES
	//NOT GRANT ANY IMMUNITY
	public void Roll(){
		//first we check if the player rolled recently; if they have not,
		//then they are allowed to roll again, otherwise they cannot
		if (!this.playerRolled){
			//then we check which direction the player is walking so that 
			//they are boosted in that direction
			if (this.dx != 0 || this.dy != 0){
				if (this.dx > 0){
					this.dx += this.rollSpeed;
				}
				if (this.dx < 0){
					this.dx -= this.rollSpeed;
				}
				if (this.dy > 0){
					this.dy += this.rollSpeed;
				}
				if (this.dy < 0){
					this.dy -= this.rollSpeed;
				}
			}
			//MAYBE MAKE IT SO THAT THE PLAYER ROLLS TOWARDS POSITIVE
			//dy IF THEY ARE STANDING STILL AND THEY ROLL?
			/*else{
				this.dy = this.rollSpeed;
			}*/
		}
	}
	
	//timer so that the player has a cool down period between rolling
	//is 3 seconds good enough? I dunno lol
	public void playerPerformedRolled(){
		this.playerRolled = true;
		System.out.println("eee");
		System.out.println("eee");
		try{
			Thread.sleep(3000);
		}
		catch (Exception e){
			//pass
		}
		System.out.println("eee");
		this.playerRolled = false;
	}
}//end of Player
