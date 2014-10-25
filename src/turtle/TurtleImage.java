package turtle;

import java.awt.Dimension;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import transitionstate.TransitionState.VisibleChange;

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
	
	public abstract void colorTurtle(Color color);

	public void toggleSelection() {
		myIsSelected = !myIsSelected;
		selectedChanged();
	}
	
	protected abstract void selectedChanged();
	
	public abstract double getRadius();
	
	public void updateVisible(VisibleChange visibleChange) {
		if (visibleChange.equals(VisibleChange.CHANGE_INVISIBLE)) {
			this.setVisible(false);
		} else if (visibleChange.equals(VisibleChange.CHANGE_VISIBLE)) {
			this.setVisible(true);
		}
	}
	
}
