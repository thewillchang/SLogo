package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serialiser {
	
	
	//public Serialiser(MainModel model){
	public static void main(String [] args)
	   {
		MainModel myModel = new MainModel("English");
		myModel.addTurtle();
	
	
	//private void serialise(MainModel model){
		try
	      {
	         FileOutputStream fileOut = new FileOutputStream("src/resources/savedstates/savedmodel.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(myModel);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in ");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}

}
