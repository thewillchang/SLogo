package turtle;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javafx.scene.shape.Line;

public class SerialisableTurtle implements Serializable{
	
	private static int ourTurtleCount;
	private int myId;
	private double translateX;
	private double translateY;
	private double rotate;
	private boolean isSelected;
	private File imageFile;
	private String penColour;
	private boolean isPenDown;
	private List<Line> lines; 
	//private TurtleViewController myTurtleViewController;
	//private Pen myPen;
	//private TurtleHistory myTurtleHistory;

	public SerialisableTurtle(Turtle turtle) {
		//myTurtleViewController = new TurtleViewController();
		//myPen = new Pen(getTurtle());
		myId = turtle.getId();
		//myTurtleHistory = new TurtleHistory();
		translateX = turtle.getTurtle().getTranslateX();
		translateY = turtle.getTurtle().getTranslateY();
		rotate = turtle.getTurtle().getRotate();
		//isSelected = turtle.getMyTurtleViewController().isSelected();
		//imageFile = turtle.getMyTurtleViewController().getImageFile();
		penColour = turtle.getPen().getColor().toString();
		isPenDown = turtle.getPen().getPenDown();
		lines = turtle.getPen().getDrawnLines();
		
	}

	public static int getOurTurtleCount() {
		return ourTurtleCount;
	}

	public int getMyId() {
		return myId;
	}

	public double getTranslateX() {
		return translateX;
	}

	public double getTranslateY() {
		return translateY;
	}

	public double getRotate() {
		return rotate;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public File getImageFile() {
		return imageFile;
	}

	public String getPenColour() {
		return penColour;
	}
	
	public boolean getIsPenDown() {
		return isPenDown;
	}
	
	public List<Line> getLines() {
		return lines;
	}
}
