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
 * Specialized word that handles drawing and copying. <br>
 *
 * <hr>
 * Date created: Apr 19, 2012<br>
 * Date last modified: Apr 19, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class LaserWord extends Word
{
	
	
//////////////////
//
//FIELDS
//
//////////////////

//	the image that holds the word image file
	File laserWordFile = new File("resources/laserShip.gif");
	
	
//////////////////
//
//CONSTRUCTORS
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
	 * @param word String that is the word
	 * @param x the x-location of the word
	 * @param y the y-location of the word
	 */
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
	
	
//////////////////
//
//METHODS
//
//////////////////
	
	
	
	/**
	 * Draw the word to the screen. <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @param g the Graphics object to be drawn to.
	 * @see core.Word#drawWord(java.awt.Graphics)
	 */
	@Override
	public void drawWord(Graphics g)
	{
//		get the text of the word
		String text = String.valueOf(characters);
		FontMetrics metrics = g.getFontMetrics();
		
//		draw the spaceship in around the coordinates
		g.drawImage(wordImage, locX - wordImage.getWidth( ) / 2, locY - wordImage.getHeight( ) / 2, null);
		
//		draw the text of the word in the center of the ship
		g.setColor(Color.RED);
		Rectangle2D rect = metrics.getStringBounds(text, g);
		int wordX = (int) (locX - rect.getCenterX( ));
		int wordY = (int) (locY - rect.getCenterY( ));
		
		g.drawString(String.valueOf(characters), wordX , wordY);
		
//		draw the typed characters in blue above the whole word 
		g.setColor(Color.BLUE);
		g.drawString(getClearedString( ), wordX, wordY - 13);
	}
	
	/**
	 * Copy method for LaserWord. Needed to handle
	 * polymorphic copies. <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @return a LaserWord that is a copy of the calling instance.
	 * @see core.Word#copy()
	 */
	@Override
	public Word copy()
	{
		Word copy = new LaserWord(String.valueOf(this.characters), this.locX, this.locY);
		
		
		return copy;
	}
	
	
	

}
