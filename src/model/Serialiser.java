package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import turtle.SerialisableTurtle;
import turtle.Turtle;
/**
 *Serialises the model to allow user to save a workspace for later retrieval
 * 
 * @author Tanaka Jimha
 *
 */


public class Serialiser {

	private SerialisableModel sModel;
	private List<Turtle> myTurtles;
	private List<SerialisableTurtle> mySerialisableTurtles = new ArrayList<SerialisableTurtle>();

	public void serialise(MainModel myModel, File file){
		try
		{	
			myTurtles = myModel.getTurtles();
			for(Turtle turtle : myTurtles){
				mySerialisableTurtles.add(new SerialisableTurtle(turtle));
			}
			sModel = new SerialisableModel(myModel);
			sModel.setMySerialisableTurtles(mySerialisableTurtles);
			
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(sModel);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + file.getName());
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}


}


