package code;

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
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public Image getImg(){
		return this.itemimg;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
}//end of Item class
