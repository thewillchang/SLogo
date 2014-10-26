package turtle;
import java.awt.Dimension;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * turtle image abstract superclass for the Group representing the turtle
 * @author Jonathan Tseng
 *
 */
public abstract class TurtleImage extends Group {
	protected final static Color ourSelectedColor = Color.GOLD;
	
	protected static Dimension ourSize;
	protected boolean myIsSelected;
	
	public TurtleImage() {
		this.setOnMouseClicked(event->toggleSelection());
	}
	
	public boolean isSelected() {
		return myIsSelected;
	}
	
	public static void setSize(Dimension size) {
		ourSize = size;
	}
	
	public void toggleSelection() {
		myIsSelected = !myIsSelected;
		selectedChanged();
	}
	
	public void setSelection(boolean isSelected) {
		myIsSelected = !isSelected;
		toggleSelection();
	}
	
	protected abstract void selectedChanged();
	
	public abstract double getRadius();
	
	public void updateVisible(boolean visible) {
		this.setVisible(visible);
	}
	
}