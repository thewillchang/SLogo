package turtle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class UserChosenTurtleImage extends TurtleImage {

	private ImageView myImageView;
	private Rectangle myBorder;
	private final static double myBorderWidth = 5;
	
	public UserChosenTurtleImage(Image image) {
		super();
		createImageView(image);
		getChildren().addAll(myBorder, myImageView);
	}
	
	private void createImageView(Image image) {
		myImageView = new ImageView(image);
		createBorder();
		myImageView.setTranslateX(myBorderWidth);
		myImageView.setTranslateY(myBorderWidth);
	}

	private void createBorder() {
		myBorder = new Rectangle(myImageView.getFitHeight() + 2 * myBorderWidth, myImageView.getFitWidth() + 2 * myBorderWidth);
	}
	
	@Override
	public void colorTurtle(Color color) {
		
	}

	@Override
	protected void selectedChanged() {
		if (myIsSelected) {
			myBorder.setFill(ourSelectedColor);
		} else {
			myBorder.setFill(Color.TRANSPARENT);
		}
	}

	@Override
	public double getRadius() {
		return ourSize.getHeight() / 2;
	}

}
