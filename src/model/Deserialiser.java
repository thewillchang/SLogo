package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import turtle.SerialisableTurtle;
import turtle.Turtle;
/**
 *Deserialises the model to allow user to load a ser file of a previously stored workspace with 
 *saved state
 * 
 * @author Tanaka Jimha
 */

public class Deserialiser
{
	private SerialisableModel sModel;
	private MainModel myModel;
	private List<Turtle> myTurtles = new ArrayList<Turtle>();
	private List<SerialisableTurtle> mySerialisableTurtles;


	public Deserialiser(){
		sModel = null;
		myModel = null;
	}

	public MainModel deserialise(FileInputStream fileIn){
		try
		{
			ObjectInputStream in = new ObjectInputStream(fileIn);
			sModel = (SerialisableModel) in.readObject();
			mySerialisableTurtles = sModel.getMySerialisableTurtles();
			
			for(SerialisableTurtle sTurtle : mySerialisableTurtles){
				System.out.println(sTurtle.getTranslateX());
				Turtle turtle = new Turtle(sTurtle.getMyId(), sTurtle.getTranslateX(), sTurtle.getTranslateY(), sTurtle.getRotate(), sTurtle.isSelected(),
						sTurtle.getImageFile(), sTurtle.getPenColour(), sTurtle.getIsPenDown() );
				
				//turtle.getPen().setDrawnLines(sTurtle.getLines());
				myTurtles.add(turtle);
				
			}
			
			in.close();
			fileIn.close();
			System.out.println("Desrialisation complete");
			myModel = new MainModel(sModel.getMyLanguage(), sModel.getMyCommandHistoryModel(), sModel.getMyUserDefinedMethodsModel(), sModel.getMyUserDefinedVariablesModel(), sModel.getBackGroundColorName(), myTurtles );


		}catch(IOException i)
		{
			i.printStackTrace();
			return null;
		}catch(ClassNotFoundException c)
		{
			System.out.println("MainModel class not found");
			c.printStackTrace();
			return null;
		}

		return myModel;
	}

}