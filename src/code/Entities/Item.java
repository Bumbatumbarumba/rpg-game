package code.Entities;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item {
	private String name;
	private String description;
	private Image itemimg;
	private int quantity;
	
	public Item(String n, String d, String img, int q){
		this.name = n;
		this.description = d;
		setItemImg(img);
		this.quantity = q;
	}//end of constructor
	
	//set the image for the item instance
	private void setItemImg(String directory){
		try {
			this.itemimg = (ImageIO.read(new File(directory)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//end of setItemImg
	
	//name
	public String getName(){
		return this.name;
	}
	
	//description
	public String getDescription(){
		return this.description;
	}
	
	//image
	public Image getImg(){
		return this.itemimg;
	}
	
	//quantity
	public int getQuantity(){
		return this.quantity;
	}
	public void setQuantity(int amount){
		this.quantity = amount;
	}
	public void decreaseQuantity(int amount){
		this.quantity -= amount;
	}
	public void increaseQuantity(int amount){
		this.quantity += amount;
	}
}//end of Item class
