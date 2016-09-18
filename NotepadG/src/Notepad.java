
/**
 *This is a JAVA program for writing, opening, saving, editing the documents,
 *has the ability to copy, cut, paste & select all text in the JTextArea,
 *has @see ExampleFileFilter class (From SUN -http://java.sun.com-) for filter the file
 *has a print class (from AarbTeam2000 -http://wwww.arabteam2000.com-) for printing the documents
 */

/**
 *@King Fahd University of Petroleum and Minerals (KFUPM)
 *@auther: Al-Thubaiti Salah
 *@ICS201 PROJECT
 *@JAVA Notepad (JNotepad)
 *@version# 2.0
 */

//import the packages for using the classes in them into the program
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.event.*; 
import javax.swing.text.*; 
public 
class  Notepad  extends JFrame {
	
	//for using the methods in these classes
	public Actions actions = new Actions(this);

	

	protected JMenuBar buildMenuBar() {
		JMenuBar Menubar = new JMenuBar();
		JMenu fileMenu = buildFileMenu();
		if (fileMenu.getItemCount() > 0) fileMenu.addSeparator();
		JMenuItem exitMenuItem   = new JMenuItem("Exit");
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
		exitMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.exit();
			}
		});
		fileMenu.add(exitMenuItem); //, new ImageIcon(this.getClass().getResource("images/exit.gif"))));  -- exit.gif missing
		Menubar.add(fileMenu);
		JMenu editMenu = buildEditMenu();
		if (editMenu.getItemCount() > 0) Menubar.add(editMenu);
		JMenu formatMenu = buildFormatMenu();
		if (formatMenu.getItemCount() > 0) Menubar.add(formatMenu);
		Menubar.add(buildHelpMenu());
		return Menubar;
	}

	
	protected JMenu buildFileMenu() {
		JMenu fileMenu   = new JMenu("File");
		fileMenu.setMnemonic('f');
		return fileMenu;
	}

	
	protected JMenu buildEditMenu() {
		JMenu editMenu   = new JMenu("Edit");
		editMenu.setMnemonic('e');
		return editMenu;
	}

	
	 private JMenu  buildFormatMenu__wrappee__Base  () {
		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('o');
		return formatMenu;
	}

	
	protected JMenu buildFormatMenu() {
		JMenu formatMenu = buildFormatMenu__wrappee__Base();
		if (formatMenu.getItemCount() > 0) formatMenu.addSeparator();
		lineWrapMenuItem = new JCheckBoxMenuItem("Line Wrap");
		lineWrapMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.lineWrap();
			}
		});
		formatMenu.add(lineWrapMenuItem);
		JMenuItem fontMenuItem = new JMenuItem("Font", new ImageIcon(this.getClass().getResource("images/font.gif")));
		fontMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.font();
			}
		});
		formatMenu.add(fontMenuItem);
		return formatMenu;
	}

	
	protected JMenu buildHelpMenu() {
		JMenu helpMenu   = new JMenu("Help");
		helpMenu.setMnemonic('h');
		JMenuItem aboutMenuItem = new JMenuItem("About Notepad", new ImageIcon(this.getClass().getResource("images/about.gif")));
		aboutMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.about();
			}
		});
		helpMenu.add(aboutMenuItem);
		return helpMenu;
	}

	
	 private JToolBar  buildToolBar__wrappee__Base  () {
		JToolBar toolBar = new JToolBar("Tool Bar");
		return toolBar;
	}

	
	protected JToolBar buildToolBar() {
		JToolBar toolBar = buildToolBar__wrappee__Base();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton fontButton  = new JButton(new ImageIcon(this.getClass().getResource("images/font.gif")));
		fontButton.setToolTipText("Font");
		fontButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.font();
			}
		});
		toolBar.add(fontButton);
		return toolBar;
	}

	
	public Notepad  () {
		super();
		//set the title for Notepad and set the size for it.
		setTitle("Untitled - JAVA Notepad");
		setSize(800,300);

		/**
		 *setting the default close operation to false and
		 *using own action (exitMenuItem action @Actions.java)
		 */
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				actions.exit();
			}
		});
	
		Container cp = getContentPane();
		textArea = new JTextArea();
		textArea.setLineWrap(false);
		textArea.setWrapStyleWord(false);
		cp.add(textArea);
		cp.add(new JScrollPane(textArea));
	
		//get the graphical user interface components display area
		setJMenuBar(buildMenuBar());
	}

	
	//Main Method
	public static void main(String[] args){
		new Notepad().show();
	}

	
	//declaration of the private variables used in the program
	//create the text area
	private JTextArea textArea;

	
	public JTextArea getTextArea() {
		return textArea;
	}

	
	public JTextComponent getTextComponent() {
		return textArea;
	}

	
	private JCheckBoxMenuItem lineWrapMenuItem;

	
	//for using lineWrap & textArea @Actions.java
	public JCheckBoxMenuItem getLineWrap(){
		return lineWrapMenuItem;
	}


}
