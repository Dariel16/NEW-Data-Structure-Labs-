package menuClasses;

import dataManager.DMComponent;
import ioManagementClasses.IOComponent;

public class DeleteFromListAction implements Action {

	@Override
	public void execute(Object arg) {
		// TODO Auto-generated method stub

		DMComponent dm = (DMComponent) arg; 
		IOComponent io = IOComponent.getComponent(); 
		io.output("\nRemoving a list of Integer values from the system:\n"); 
		String listName = io.getInput("\nEnter name of remove list: ");
		dm.removeList(listName);
	}

}
