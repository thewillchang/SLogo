package viewcontroller.turtlegrid;

import viewcontroller.SLogoFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * container holding a label and a node
 * @author Jonathan Tseng
 *
 */
public class SLogoLabeledContainer extends HBox {

	protected SLogoLabeledContainer(String text) {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(5));
		this.setSpacing(5);
		this.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(5), Insets.EMPTY)));
		Label label = new Label(text);
		label.setFont(new SLogoFont().createLabeledContainerFont());
		this.getChildren().add(label);
	}
	
	protected void addNode(Node node) {
		this.getChildren().add(node);
	}

}
