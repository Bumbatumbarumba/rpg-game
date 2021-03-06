/* Created by Bartosz Kosakowski
 * April 9th, 2018
 * Abstract class that has generic things that are mutual
 * between all characters, such as position, health, armor, etc
 * 
 * NOTE: any obstacle such as a wall, is essentially also a 
 * character, it's just that it does not do anything and 
 * cannot take damage
 */

package code.Entities;

import java.awt.Image;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public abstract class Character extends JComponent{
	private int maxhealthpoints; // the max hp available to a character
	private int currenthealthpoints; // the current hp of the character
	private int armor; // armor is used to determine resulting attack dmg (dmg - armor = loss in hp)
	private int maxmanapoints;
	private int currentmanapoints; // the current mp of the character
	private int xpos;
	private int ypos;
	private int attackdmg; // how much BASE damage a character does 
	private Image charimg; // the image used to show the character
	private int charRadius = 32; //since each character image will be 64x64

	// getters and setters for each character attribute

	// maxhealthpoints
	public int getHealthpoints() {
		return maxhealthpoints;
	}
	public void setHealthpoints(int maxhealthpoints) {
		this.maxhealthpoints = maxhealthpoints;
	}

	// currenthealthpoints
	public int getCurrentHP() {
		return currenthealthpoints;
	}
	public void setCurrentHp(int currenthealthpoints) {
		this.currenthealthpoints = currenthealthpoints;
	}
	
	// armor
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}

	// maxmanapoints
	public int getManapoints() {
		return maxmanapoints;
	}
	public void setManapoints(int maxmanapoints) {
		this.maxmanapoints = maxmanapoints;
	}

	// currenthealthpoints
	public int getCurrentMP() {
		return currentmanapoints;
	}
	public void setCurrentMP(int currentmanapoints) {
		this.currentmanapoints = currentmanapoints;
	}

	// xpos
	public int getXpos() {
		return xpos;
	}
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	// ypos
	public int getYpos() {
		return ypos;
	}
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	
	// attackdmg
	public int getAttackdmg() {
		return attackdmg;
	}
	public void setAttackdmg(int attackdmg) {
		this.attackdmg = attackdmg;
	}
	
	// charimg
	public Image getCharimg() {
		return charimg;
	}
	public void setCharimg(Image charimg) {
		this.charimg = charimg;
	}

	// check if the character is dead
	public boolean isDead() {
		if (this.maxhealthpoints == 0)
			return true;
		else
			return false;
	}//end of isDead

	// replenish health points; if the current health is greater than the max,
	// we set the current health to max
	public void replenishHealthPoints(int healValue){
		this.currenthealthpoints += healValue;
		if (this.currenthealthpoints > this.maxhealthpoints)
			this.currenthealthpoints = this.maxhealthpoints;
	}//end of replenishHealthPoints
	
	// replenish health points; if the current health is greater than the max,
	// we set the current health to max
	public void replenishManaPoints(int manaValue){
		this.currentmanapoints += manaValue;
		if (this.currentmanapoints > this.maxmanapoints)
			this.currentmanapoints = this.maxmanapoints;
	}//end of replenishManaPoints
	
	
	public boolean checkCollision(Character[] obstacleList){
		boolean hasCollided = false;
		
		for (int i = 0; i < obstacleList.length; i++){
			//see notebook for solution here
		}
		return hasCollided;
	}
}//end of Character
