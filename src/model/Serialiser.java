package model;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class Serialiser {
	private SerialisableModel sModel;
	public void serialise(MainModel myModel, File file){
		try
		{
			sModel = new SerialisableModel(myModel);
			FileOutputStream fileOut = new FileOutputStream(file);
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