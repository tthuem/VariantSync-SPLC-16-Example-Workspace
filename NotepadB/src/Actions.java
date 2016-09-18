
//import the packages for using the classes in them into this class
import java.io.*; 
import java.util.*; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.filechooser.*; 
public 
class  Actions {
	
	Notepad n;

	 //for using the object in the Notepad.java

	public Actions(Notepad n){
		this.n = n;
	}

	
	public void exit(){
		System.exit(0);
	}

	
	/**
	 *@see ABOUT.JAVA
	 *it's a Message Dialog to show the information about this program
	 */
	public void about(){
		JOptionPane.showMessageDialog(null, new About(),"About Notepad",JOptionPane.PLAIN_MESSAGE);
	}

	
	//to cut the selected text
	public void cut(){
		n.getTextComponent().cut();
	}

	
	//to copy the selected text
	public void copy(){
		n.getTextComponent().copy();
	}

	
	//to paste the selected text
	public void paste(){
		n.getTextComponent().paste();
	}

	
	//to select all the text
	public void selectAll(){
		n.getTextComponent().selectAll();
	}

	
	//declaration of the private variables used in the program
	private String findWord;

	 //for searching & finding the word
	private int findIndex = -1;

	
	//this is a method for searching the input text from the text area
	public void find(){
		try{
			int index;
			findWord = JOptionPane.showInputDialog("Type the word to find");
			findIndex = n.getTextComponent().getText().indexOf(findWord);
			if (findIndex == -1) {
				JOptionPane.showMessageDialog(null,"Word not found!","No match",JOptionPane.WARNING_MESSAGE);
			} else {
				selectFound();
			}
		} catch (Exception ex) { }
	}

	
	public void findNext() {
		if (findIndex == -1) return;
		findIndex = n.getTextComponent().getText().indexOf(findWord, findIndex+1);
		if (findIndex == -1) {
			JOptionPane.showMessageDialog(null,"Search wrapped!","Search wrapped",JOptionPane.WARNING_MESSAGE);
			findIndex = n.getTextComponent().getText().indexOf(findWord);
		}
		if (findIndex != -1) selectFound();
	}

	
	private void selectFound() {
		n.getTextComponent().grabFocus();
		n.getTextComponent().select(findIndex, findIndex + findWord.length());
	}

	
	/**
	 *THIS FROM SUN WEBSITE (@Print.java)
	 *if we want to print the text, we can do this by print method
	 */
	public void print(){
		//import printer class
		Print.printComponent(n.getTextComponent());
	}


}
