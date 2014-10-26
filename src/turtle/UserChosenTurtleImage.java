package turtle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * turtle image to represent imageview for image loaded by user
 * @author Jonathan Tseng
 *
 */
public class UserChosenTurtleImage extends TurtleImage {

	private ImageView myImageView;
	private Rectangle myBorder;
	private final static double myBorderWidth = 5;
	
	public UserChosenTurtleImage(Image image) {
		super();
		createImageView(image);
		getChildren().addAll(myBorder, myImageView);
		this.setTranslateX(-1 * (ourSize.getWidth() / 2 + myBorderWidth));
		this.setTranslateY(-1 * (ourSize.getHeight() / 2 + myBorderWidth));
	}
	
	private void createImageView(Image image) {
		myImageView = new ImageView(image);
		createBorder();
		myImageView.setTranslateX(myBorderWidth);
		myImageView.setTranslateY(myBorderWidth);
	}

	private void createBorder() {
		myBorder = new Rectangle(ourSize.getHeight() + 2 * myBorderWidth, ourSize.getWidth() + 2 * myBorderWidth);
		myBorder.setFill(Color.TRANSPARENT);
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
		return (ourSize.getHeight() / 2 + myBorderWidth) * Math.sqrt(2) * 1.2;
	}

}
