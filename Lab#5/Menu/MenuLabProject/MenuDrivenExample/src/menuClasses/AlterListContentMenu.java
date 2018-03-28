package menuClasses;
import java.util.ArrayList;

public class AlterListContentMenu extends Menu {

	private static AlterListContentMenu ALCM = new AlterListContentMenu (); 

	private AlterListContentMenu(){
		super(); 
		String title;  
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Alter Content on Lists"; 
		options.add(new Option("Add a New Value to a List", new AddToListAction()));//1
		options.add(new Option("Delete Position from a List", new DeleteFromListAction()));//2 
		options.add(new Option("Show Content of a List", new ShowListAction())); //3 
		options.add(Option.EXIT); //4

		super.InitializeMenu(title, options); 
		
	}
	
	public static AlterListContentMenu getAlterListContentMenu() { 
		return ALCM; 
	}
}
