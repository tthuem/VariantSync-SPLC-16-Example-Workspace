
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

	
	public Actions  (Notepad n){
		this.n = n;
	
		fontWindow = new Fonts(n);
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

	
	private Fonts fontWindow;

	
	/**
	 *@see FONTS.JAVA
	 *this is a font class which is for changing the font, style & size
	 */
	public void font(){
		fontWindow.setVisible(true); //setting the visible is true
		fontWindow.pack(); //pack the panel
	}

	
	//for wraping the line & wraping the style word
	public void lineWrap(){
		if(n.getLineWrap().isSelected()){
			/**
			 *make the line wrap & wrap style word is true
			 *when the line wrap is selected
			 */
			n.getTextArea().setLineWrap(true);
			n.getTextArea().setWrapStyleWord(true);
		} else {
			/**
			 *make the line wrap & wrap style word is false
			 *when the line wrap isn't selected
			 */
			n.getTextArea().setLineWrap(false);
			n.getTextArea().setWrapStyleWord(false);
		}
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
