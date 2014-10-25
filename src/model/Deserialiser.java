package model;

import interpreter.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Deserialiser
{
   public static void main(String [] args)
   {
      MainModel model = null;
      try
      {
         FileInputStream fileIn = new FileInputStream("src/resources/savedstates/savedmodel.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         model = (MainModel) in.readObject();
         in.close();
         fileIn.close();
         System.out.println("Desrialisation complete");
         
         
         model.setmyInterpreter();
         
        
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