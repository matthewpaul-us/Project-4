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

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private static final String	LINES_OF_CODE	= "infinity";

	private static final String	CLASS_NUMBER	= "16";
	
	private static final String	IMAGE_NUMBER	= "4";

	private static final String [ ]	NOTABLES	= {"This was originally a Pool simulator. RIP friction",
												   "The program uses a primitive implementation of multi-threading.",
												   "The class hierarchy was designed to ease future typing game development.",
												   "This program uses a buffer strategy, or Java's implementation of page flipping.",
												   "It also uses a queue wrapped inside the WordPool class."};

	private JPanel panel;
	
	private File iconFile = new File("resources/laserIcon.gif");
	BufferedImage icon;

	private JPanel	notablePanel;
	
	public AboutDialog(Window parent)
	{
		super(parent, "About Laser Defense");
		
		try
		{
			loadIcon();
		}
		catch (IOException e)
		{
			System.out.println("Can't load custom icon! " + e.getMessage( ));
		}
		
		setIconImage(icon);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panel = new JPanel(new GridLayout(3, 0));
		
		JPanel infoPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		infoPanel.setBorder(BorderFactory.createTitledBorder("Information"));
		
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
		
		JPanel statsPanel = new JPanel(new GridLayout(0, 2, 0, 5));
		statsPanel.setBorder(BorderFactory.createTitledBorder("Stats"));
		
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
		
		notablePanel = new JPanel(new GridLayout(0, 1, 0, 5));
		notablePanel.setBorder(BorderFactory.createTitledBorder("Notes"));
		buildNotablePanel(NOTABLES);
		
		panel.add(infoPanel);
		panel.add(statsPanel);
		panel.add(notablePanel);
		
		add(panel);
		pack();
		setVisible(true);
	}
	
	private void buildNotablePanel(String[] array)
	{
		JLabel label = null;
		for (String note: array)
		{
			label = new JLabel(note);
			
			notablePanel.add(label);
		}
	}
	
	private void loadIcon() throws IOException
	{
		icon = ImageIO.read(iconFile);
	}
}
