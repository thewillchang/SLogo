package viewcontroller.turtlegrid;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import viewcontroller.SLogoFont;


/**
 * container holding a label and a node
 *
 * @author Jonathan Tseng
 *
 */
public class SLogoLabeledContainer extends HBox {

    protected SLogoLabeledContainer (String text) {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5));
        setSpacing(5);
        setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(5),
                                                        Insets.EMPTY)));
        Label label = new Label(text);
        label.setFont(new SLogoFont().createLabeledContainerFont());
        getChildren().add(label);
    }

    protected void addNode (Node node) {
        getChildren().add(node);
    }

}
