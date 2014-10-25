package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Deserialiser
{
	public static void main(String [] args)
	{
		SerialisableModel sModel = null;
		MainModel myModel = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("src/resources/savedstates/savedmodel.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			sModel = (SerialisableModel) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Desrialisation complete");
			myModel = new MainModel(sModel.getMyLanguage(), sModel.getMyCommandHistoryModel(), sModel.getMyUserDefinedMethodsModel(), sModel.getMyUserDefinedVariablesModel(), sModel.getBackGroundColorName());




		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("MainModel class not found");
			c.printStackTrace();
			return;
		}

	}
}