package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * Serialises the main model, and Writes to a .ser file to allow storing of state
 *
 * @author Tanaka Jimha
 *
 */
public class Serialiser {
    private SerialisableModel sModel;

    public void serialise (MainModel myModel, File file) {
        try
        {
            sModel = new SerialisableModel(myModel);
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sModel);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + file.getName());
        }
        catch (IOException i)
        {
            System.out.println("Serialisation Error");
        }
    }
}
