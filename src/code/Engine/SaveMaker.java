package code.Engine;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import code.UI.Screens;

/* Created by Bartosz Kosakowski
 * 08/18/2018
 * Creates a save file by pulling some data (not sure what)
 * --> PLAYER LOCATION FOR SURE
 * --> WHICH SCREEN THE PLAYER IS IN
 * --> PLAYER'S INVENTORY CONTENTS
 * --> THINK OF OTHER STUFF
 */
public class SaveMaker {
	public static void SaveData() {
		//iterate through all PlayAreas and check which is visible, meaning
		//that the player is in that area
		for (int i = 0; i < Screens.GetPlayAreas().length; i++){
			if (Screens.GetPlayAreas()[i].isVisible()){
				//when we find the visible area, we write it to a savefile of the specified name
				try (Writer writer = new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(Screens.GetCurrentSaveFileName()), "utf-8"))) {
			   writer.write("something");
			   writer.write("something");
				}catch (Exception e){
					//pass
				}
			}
		}
		
	}//end of SaveData
}//end of SaveMaker
