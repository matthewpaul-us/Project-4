/**
 * ---------------------------------------------------------------------------
 * File name: LaserTutor.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 19, 2012<br/>
 * Date of Last Modification: Apr 19, 2012
 * ---------------------------------------------------------------------------
 */

package laserDefense;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;
import javax.imageio.ImageIO;
import core.Tutor;
import core.Word;
import front.Gui;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 19, 2012<br>
 * Date last modified: Apr 19, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class LaserTutor extends Tutor
{
	
	BufferedImage backgroundImage;
	
	File backgroundFile = new File("resources/laserBackground.gif");

	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param wordsOnScreen
	 * @param acceptableWords
	 * @param clearedWords
	 * @param livesLeft
	 * @param errors
	 * @param buffer
	 */
	public LaserTutor(ArrayList <Word> wordsOnScreen,
						ArrayList <Word> acceptableWords,
						ArrayList <Word> clearedWords, int livesLeft,
						int errors, StringBuffer buffer)
	{
		super(wordsOnScreen, acceptableWords, clearedWords, livesLeft, errors,
				buffer);
		try
		{
			loadBackgroundImage(backgroundFile);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.getMessage( );
		}
	}

	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param array
	 */
	public LaserTutor(String [ ] array)
	{
		super(array);

		try
		{
			loadBackgroundImage(backgroundFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 */
	public LaserTutor()
	{
		try
		{
			loadBackgroundImage(backgroundFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void drawGame(Graphics g)
	{
		g.drawImage(backgroundImage, 0, 0, Gui.WIDTH, Gui.HEIGHT, null);
		
	}
	
	@Override
	public void update(int deltaTime)
	{
		
	}
	
	@Override
	public void initialize()
	{
		
	}
	
	@Override
	public void gameOver()
	{
		
	}
	
	public void loadBackgroundImage(File imageFile) throws IOException
	{
		backgroundImage = ImageIO.read(imageFile);
	}

}
