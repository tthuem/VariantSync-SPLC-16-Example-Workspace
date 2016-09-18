
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

	
	 private JMenu  buildFileMenu__wrappee__Base  () {
		JMenu fileMenu   = new JMenu("File");
		fileMenu.setMnemonic('f');
		return fileMenu;
	}

	
	protected JMenu buildFileMenu() {
		JMenu fileMenu   = buildFileMenu__wrappee__Base();
		if (fileMenu.getItemCount() > 0) fileMenu.addSeparator();
		JMenuItem printMenuItem  = new JMenuItem("Print", new ImageIcon(this.getClass().getResource("images/print.gif")));
		printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		printMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.print();
			}
		});
		fileMenu.add(printMenuItem);
		return fileMenu;
	}

	
	 private JMenu  buildEditMenu__wrappee__Base  () {
		JMenu editMenu   = new JMenu("Edit");
		editMenu.setMnemonic('e');
		return editMenu;
	}

	
	 private JMenu  buildEditMenu__wrappee__Clipboard  () {
		JMenu editMenu = buildEditMenu__wrappee__Base();
		if (editMenu.getItemCount() > 0) editMenu.addSeparator();
		JMenuItem cutMenuItem  = new JMenuItem("Cut",  new ImageIcon(this.getClass().getResource("images/cut.gif")));
		cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cutMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.cut();
			}
		});
		editMenu.add(cutMenuItem);
		JMenuItem copyMenuItem = new JMenuItem("Copy", new ImageIcon(this.getClass().getResource("images/copy.gif")));
		copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copyMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.copy();
			}
		});
		editMenu.add(copyMenuItem);
		JMenuItem pasteMenuItem= new JMenuItem("Paste",new ImageIcon(this.getClass().getResource("images/paste.gif")));
		pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		pasteMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.paste();
			}
		});
		editMenu.add(pasteMenuItem);
		JMenuItem selectAllMenuItem= new JMenuItem("Select All");
		selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		selectAllMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.selectAll();
			}
		});
		editMenu.add(selectAllMenuItem);
		return editMenu;
	}

	
	protected JMenu buildEditMenu() {
		JMenu editMenu   = buildEditMenu__wrappee__Clipboard();
		if (editMenu.getItemCount() > 0) editMenu.addSeparator();
		JMenuItem findMenuItem = new JMenuItem("Find", new ImageIcon(this.getClass().getResource("images/find.gif")));
		findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		findMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.find();
			}
		});
		editMenu.add(findMenuItem);
		JMenuItem findNextMenuItem = new JMenuItem("Find Next");
		findNextMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		findNextMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.findNext();
			}
		});
		editMenu.add(findNextMenuItem);
		return editMenu;
	}

	
	protected JMenu buildFormatMenu() {
		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('o');
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

	
	 private JToolBar  buildToolBar__wrappee__Clipboard  () {
		JToolBar toolBar = buildToolBar__wrappee__Base();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton cutButton   = new JButton(new ImageIcon(this.getClass().getResource("images/cut.gif")));
		cutButton.setToolTipText("Cut");
		cutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.cut();
			}
		});
		toolBar.add(cutButton);
		JButton copyButton  = new JButton(new ImageIcon(this.getClass().getResource("images/copy.gif")));
		copyButton.setToolTipText("Copy");
		copyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.copy();
			}
		});
		toolBar.add(copyButton);
		JButton pasteButton = new JButton(new ImageIcon(this.getClass().getResource("images/paste.gif")));
		pasteButton.setToolTipText("Paste");
		pasteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.paste();
			}
		});
		toolBar.add(pasteButton);
		return toolBar;
	}

	
	 private JToolBar  buildToolBar__wrappee__Find  () {
		JToolBar toolBar = buildToolBar__wrappee__Clipboard();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton findButton  = new JButton(new ImageIcon(this.getClass().getResource("images/find.gif")));
		findButton.setToolTipText("Find");
		findButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.find();
			}
		});
		toolBar.add(findButton);
		return toolBar;
	}

	
	protected JToolBar buildToolBar() {
		JToolBar toolBar = buildToolBar__wrappee__Find();
		if (toolBar.getComponentCount() > 0) toolBar.addSeparator();
		JButton printButton = new JButton(new ImageIcon(this.getClass().getResource("images/print.gif")));
		printButton.setToolTipText("Print");
		printButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				actions.print();
			}
		});
		toolBar.add(printButton);
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
		textPane = new JTextPane();
		cp.add(textPane);
		cp.add(new JScrollPane(textPane));
	}

	
	//Main Method
	public static void main(String[] args){
		new Notepad().show();
	}

	
	//declaration of the private variables used in the program
	//create the text area
	private JTextPane textPane;

	
	public JTextPane getTextPane() {
		return textPane;
	}

	
	public JTextComponent getTextComponent() {
		return textPane;
	}


}
