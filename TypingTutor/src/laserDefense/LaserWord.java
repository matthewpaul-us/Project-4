/**
 * ---------------------------------------------------------------------------
 * File name: LaserWord.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 19, 2012<br/>
 * Date of Last Modification: Apr 19, 2012
 * ---------------------------------------------------------------------------
 */

package laserDefense;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import core.Word;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 19, 2012<br>
 * Date last modified: Apr 19, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class LaserWord extends Word
{

	File laserWordFile = new File("resources/laserShip.gif");
	
	public LaserWord(String word, int x, int y)
	{
		super(word, x, y);
		try
		{
			loadImage(laserWordFile);
		}
		catch (IOException e)
		{
			System.out.println("Error loading laserWord image file. " + e.getMessage( ));
		}
	}
	
	@Override
	public void drawWord(Graphics g)
	{
		String text = String.valueOf(characters);
		FontMetrics metrics = g.getFontMetrics();
		g.drawImage(wordImage, locX - wordImage.getWidth( ) / 2, locY - wordImage.getHeight( ) / 2, null);
		
		g.setColor(Color.RED);
		Rectangle2D rect = metrics.getStringBounds(text, g);
		int wordX = (int) (locX - rect.getCenterX( ));
		int wordY = (int) (locY - rect.getCenterY( ));
		
		g.drawString(String.valueOf(characters), wordX , wordY);
		
		g.setColor(Color.BLUE);
		g.drawString(getClearedString( ), wordX, wordY - 13);
	}
	
	@Override
	public Word copy()
	{
		Word copy = new LaserWord(String.valueOf(this.characters), this.locX, this.locY);
		
		
		return copy;
	}
	
	
	

}
