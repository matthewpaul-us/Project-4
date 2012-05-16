/**
 * ---------------------------------------------------------------------------
 * File name: AboutDialog.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 20, 2012<br/>
 * Date of Last Modification: Apr 20, 2012
 * ---------------------------------------------------------------------------
 */

package front;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 20, 2012<br>
 * Date last modified: Apr 20, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class AboutDialog extends JDialog
{
	
//////////////////
//
//FIELDS
//
//////////////////

	
//	placed in to avoid warning
	private static final long	serialVersionUID	= 1L;

//	constant to show the lines of code that are in the program
	private static final String	LINES_OF_CODE	= "infinity";

//	constant to show the number of classes that are in the program
	private static final String	CLASS_NUMBER	= "15";
	
//	constant to show the number of images used in the program
	private static final String	IMAGE_NUMBER	= "9";

	private static final String [ ]	HELPS	= {"You have to save earth from the nasty HOSTILE aliens!",
		   									   "To target the aliens with your laser, you must type the words on the aliens' ships.",
		   									   "You cannot let the aliens hit your shield more than three times. Anymore, and earth is no more!",
		   									   "",
		   									   "To change the word file used, click on \"Change File\" in the \"File\" menu.",
		   									   "Good luck and have fun!"};
	
//	constant string array to contain the notable features of the project
	private static final String [ ]	NOTABLES	= {"This was originally a Pool simulator. RIP friction",
												   "The program uses a primitive implementation of multi-threading.",
												   "The class hierarchy was designed to ease future typing game development.",
												   "This program uses a buffer strategy, or Java's implementation of page flipping.",
												   "It also uses a queue wrapped inside the WordPool class."};

//	panel to hold the dialog stuffs
	private JPanel panel;
	
//	file and image that points to the icon image
	private File iconFile = new File("resources/laserIcon.gif");
	BufferedImage icon;

//	the notable panel, so it can be created in its own method
	private JPanel	notablePanel;

	private JPanel	helpPanel;
	
	
//////////////////
//
//CONSTRUCTOR
//
//////////////////


	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @param parent the Window object that is to be the origin.
	 */
	public AboutDialog(Window parent)
	{
//		call the JDialog's constructor and pass the title
		super(parent, "About Laser Defense");
		
//		load the icon image
		try
		{
			loadIcon();
		}
		catch (IOException e)
		{
			System.out.println("Can't load custom icon! " + e.getMessage( ));
		}
		
//		set the icon to the custom icon
		setIconImage(icon);
		
//		set the default to dispose of the window when you click the X
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
//		create a new panel with a gridlayout to store our bordered panels
		panel = new JPanel(new GridLayout(4, 0));
		
//		create the help panel and make its border
		helpPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		helpPanel.setBorder(BorderFactory.createTitledBorder("Help"));
		
//		build the labels and add them to the info panel
		buildHelpPanel();
		
//		create the info panel and make its border
		JPanel infoPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		infoPanel.setBorder(BorderFactory.createTitledBorder("Information"));
		
//		build labels and add them to the info panel
		JLabel nameLabel = new JLabel("Laser Defense");
		JLabel progammedLabel = new JLabel("Progammed By" );
		JLabel matthewLabel = new JLabel("  Matthew Paul");
		JLabel stephenLabel = new JLabel("  Stephen Middaugh");
		JLabel spaceLabel = new JLabel();
		JLabel infoLabel = new JLabel("This was done for a final project in Intro. to Programming II." );
		
		infoPanel.add(nameLabel);
		infoPanel.add(progammedLabel);
		infoPanel.add(stephenLabel);
		infoPanel.add(matthewLabel);
		infoPanel.add(spaceLabel);
		infoPanel.add(infoLabel);
		
//		create the stats panel and a border to go with it
		JPanel statsPanel = new JPanel(new GridLayout(0, 2, 0, 5));
		statsPanel.setBorder(BorderFactory.createTitledBorder("Stats"));
		
//		create all of the labels that adorn the stats panel
		JLabel codeLinesLabel = new JLabel("Lines of code: ");
		JLabel codeNumberLabel = new JLabel(LINES_OF_CODE);
		
		JLabel classLabel = new JLabel("Classes: ");
		JLabel classNumberLabel = new JLabel(CLASS_NUMBER);
		
		JLabel imageLabel = new JLabel("Images: ");
		JLabel imageNumberLabel = new JLabel(IMAGE_NUMBER);
		
		statsPanel.add(classLabel);
		statsPanel.add(classNumberLabel);
		
		statsPanel.add(codeLinesLabel);
		statsPanel.add(codeNumberLabel);
		
		statsPanel.add(imageLabel);
		statsPanel.add(imageNumberLabel);
		
//		create a notable panel and call the buildNotablePanel() method
		notablePanel = new JPanel(new GridLayout(0, 1, 0, 5));
		notablePanel.setBorder(BorderFactory.createTitledBorder("Notes"));
		buildNotablePanel();
		
//		add the four panels to the base panel
		panel.add(helpPanel);
		panel.add(infoPanel);
		panel.add(statsPanel);
		panel.add(notablePanel);
		
//		add the panel, pack it, and then display
		add(panel);
		pack();
		setVisible(true);
	}
	
	
//////////////////
//
//METHODS
//
//////////////////


	
	private void buildHelpPanel()
	{
		JLabel label = null;
		for (String note: HELPS)
		{
			label = new JLabel(note);
			
			helpPanel.add(label);
		}
	}


	/**
	 * Builds the notable panel using an array of strings <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @param array String array containing the words to adorn the panel. Do not add newlines
	 */
	private void buildNotablePanel()
	{
		JLabel label = null;
		for (String note: NOTABLES)
		{
			label = new JLabel(note);
			
			notablePanel.add(label);
		}
	}
	
	/**
	 * Load the custom Icon <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @throws IOException - if the file cannot be successfully read
	 */
	private void loadIcon() throws IOException
	{
		icon = ImageIO.read(iconFile);
	}
}
