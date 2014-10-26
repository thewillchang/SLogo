package model;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Deserialiser
{
		private SerialisableModel sModel;
		private MainModel myModel;
		
		public Deserialiser(){
			sModel = null;
			myModel = null;
		}
		
		public MainModel deserialise(FileInputStream fileIn){
			try
			{
				ObjectInputStream in = new ObjectInputStream(fileIn);
				sModel = (SerialisableModel) in.readObject();
				in.close();
				fileIn.close();
				System.out.println("Desrialisation complete");
				myModel = new MainModel(sModel.getMyLanguage(), sModel.getMyCommandHistoryModel(), sModel.getMyUserDefinedMethodsModel(), sModel.getMyUserDefinedVariablesModel(), sModel.getBackGroundColorName());
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