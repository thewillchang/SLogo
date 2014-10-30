package application;

import java.util.Collection;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import viewcontroller.SLogoFont;


/**
 * drop down form element
 *
 * @author Jonathan Tseng
 *
 */
public class DropDownFormElement extends ComboBox<String> implements FormElement {

    public DropDownFormElement (Collection<String> choices) {
        setStyle(new SLogoFont().createButtonFontStyle());
        getItems().addAll(choices);
    }

    public void setInitialValue (String choice) {
        getSelectionModel().select(choice);
    }

    @Override
    public Node getNode () {
        return this;
    }

    @Override
    public String getSelectedValue () {
        return getValue();
    }

}
