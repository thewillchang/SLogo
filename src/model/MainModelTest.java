package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import interpreter.result.SLogoResult;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import javafx.scene.paint.Color;

import org.junit.Test;

import turtle.DefaultTurtleImage;
import turtle.Turtle;
import turtle.TurtleHistory;
import turtle.TurtleImage;
import turtle.TurtleViewController;
import turtle.draw.Pen;
import viewcontroller.MainModelObserver;
import viewcontroller.MainViewController;

/**
 * Class to test the MainModel of the program 
 * @author Tanaka Jimha
 *
 */

public class MainModelTest {

	/*@BeforeClass
	public static void beforeClass() {
		MainModel model = new MainModel("English");
	}*/

	/**
	 *Method which uses reflection to access the private fields in the classes I'm testing.
	 *
	 */
	private Object getField( Object instance, String name ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Class c = instance.getClass();

		// Retrieve field with the specified nam
		Field f = c.getDeclaredField( name );


		f.setAccessible( true );

		return f.get( instance );
	}

	/**
	 *Testing the change of turtle images from the default image
	 *
	 */

	@Test
	public void changeTurtleImageTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MainModel model = new MainModel("English");
		model.addTurtle();

		try {
			File file = new File("src/resources/savedstates/test_image.jpg");
			model.changeTurtleImages(file);
			List<Turtle> turtles = (List<Turtle>) getField(model, "myTurtles");

			for(Turtle turtle: turtles){
				TurtleViewController tvc = (TurtleViewController) getField(turtle, "myTurtleViewController");
				TurtleImage myImage = (TurtleImage) getField(tvc, "myTurtleImage");
				TurtleImage defaultImage = new DefaultTurtleImage();
				assertTrue(myImage != defaultImage);
			}


		}
		catch (NullPointerException e) {
			fail("Test Image Not Found");
		}

	}

	//Test for the updating of the turtles' pens
	@Test
	public void updatePenTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MainModel model = new MainModel("English");
		model.addTurtle();
		List<Turtle> turtles = (List<Turtle>) getField(model, "myTurtles");

		for(Turtle turtle: turtles){
			Pen myPen = (Pen) getField(turtle, "myPen");
			assertTrue(myPen != null);
		}

	}

	//test for updating the turtle pen colour
	@Test
	public void updatePenColorTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MainModel model = new MainModel("English");
		model.addTurtle();
		model.updatePenColor(Color.RED);
		List<Turtle> turtles = (List<Turtle>) getField(model, "myTurtles");

		for(Turtle turtle: turtles){
			Pen myPen = (Pen) getField(turtle, "myPen");
			assertEquals(myPen.getColor(), Color.RED);
		}

	}

	//test for adding turtles into the main model
	@Test
	public void addTurtleTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MainModel model = new MainModel("English");
		model.addTurtle();
		List<Turtle> turtles = (List<Turtle>) getField(model, "myTurtles");
		assertTrue(turtles != null);

	}

	//Test for successful interpretation of an SLogo Command
	@Test
	public void interpretSlogoResultTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MainModel model = new MainModel("English");
		model.interpretSLogoCommand("forward 70");
		SLogoResult result  = (SLogoResult) getField(model, "mySLogoResult");
		assertTrue(result.getValue() == 70);

	}

	//Test  to check that the model is updated, and retains history
	@Test
	public void updateModelTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MainModel model = new MainModel("English");
		model.interpretSLogoCommand("forward 100");
		List<Turtle> turtles = (List<Turtle>) getField(model, "myTurtles");
		for(Turtle turtle: turtles){
			TurtleHistory turtleHistory = (TurtleHistory) getField(model, "myTurtleHistory");
			assertTrue(turtleHistory != null);
		}

	}

	//test for the successful attachment of a new Observer to watch the MainModel
	@Test
	public void attachObserverTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MainModel model = new MainModel("English");
		MainViewController mvc1 = new MainViewController(model);
		MainModelObserver observer = (MainModelObserver)mvc1;
		model.attachObserver(observer);
		List<MainModelObserver> observers = (List<MainModelObserver>) getField(model, "myObservers");
		assertEquals(observers.get(0), observer);

	}

	//test for successful notification of observers upon change of state of the model
	@Test
	public void notifyObserversTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MainModel model = new MainModel("English");
		MainViewController mvc1 = new MainViewController(model);
		MainModelObserver observer = (MainModelObserver)mvc1;
		model.attachObserver(observer);

		List<MainModelObserver> myObservers = (List<MainModelObserver>) getField(model, "myObservers");
		MainViewController mvc2 = (MainViewController) myObservers.get(0);
		assertEquals(mvc1, mvc2);

	}


}
