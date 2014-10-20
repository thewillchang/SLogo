package viewcontroller.commands;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Variable2 {
	
	private final SimpleStringProperty myVariableName;
	private final SimpleDoubleProperty myVariableValue;
	
	public Variable2(String name, double value) {
		myVariableName = new SimpleStringProperty(name);
		myVariableValue = new SimpleDoubleProperty(value);
	}

    public String getVariableName() {
        return myVariableName.get();
    }

    public void setVariableName(String name) {
        myVariableName.set(name);
    }

    public double getVariableValue() {
        return myVariableValue.get();
    }

    public void setLastName(double value) {
        myVariableValue.set(value);
    }
	
}
