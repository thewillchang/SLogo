package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serialiser {

	private MainModel myModel;
	private SerialisableModel sModel;

	public Serialiser(MainModel model){
		myModel = model;
		sModel = new SerialisableModel(myModel);
	}

	private void serialise(MainModel myModel){
		try
		{
			FileOutputStream fileOut = new FileOutputStream("src/resources/savedstates/savedmodel.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(sModel);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in ");
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}


}


