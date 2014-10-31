// This entire file is part of my masterpiece.
// Abhishek Balakrishnan
package unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import viewcontroller.MainViewController;
import viewcontroller.Workspace;
import viewcontroller.commands.CommandWindowContainerViewController;

public class CommandPromptTextTest {

	@Test
	public void testTransferOfString() {
		Workspace workspace = new Workspace("English");
		MainViewController mvc = workspace.getViewController();
		CommandWindowContainerViewController cwcvc = mvc
				.getCommandWindowContainer();
		String test = "Hope this shows up";
		cwcvc.moveCommandTextToPromptWindow(test);
		assertEquals(test, cwcvc.getCommandPrompt().getCommandPromptText());
	}
}
