/**
 * ---------------------------------------------------------------------------
 * File name: Word.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 15, 2012<br/>
 * Date of Last Modification: Apr 15, 2012
 * ---------------------------------------------------------------------------
 */

package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import front.TutorGui;


/**
 * Represents a word for a typing tutor game<br>
 *
 * <hr>
 * Date created: Apr 15, 2012<br>
 * Date last modified: Apr 15, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class Word
{
	
//	the collection of characters that make up the word
	private char[] characters;
	
//	the number of characters that has been typed
	private int charactersCleared;
	
//	whether or not the word has already been typed
	private boolean cleared;
	
//	the picture that represents the word
	private BufferedImage wordImage = null;
	
//	the coordinates of the word on the canvas
	private int locX,
				locY;
	
	/**
	 * Full Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @param characters An array of characters that together make up the word
	 */
	public Word(char[] characters)
	{
//		initialize the internal characters with the length of the characters
		this.characters = new char[characters.length];
		
//		for all the space in the internal characters array...
		for (int c = 0; c < this.characters.length; c++)
		{
//			copy the character over to the internal array
			this.characters[c] = characters[c];
		}
		
//		set the number of the cleared characters to 0
		charactersCleared = 0;
		
//		if the length of the word is 0...
		if (characters.length == 0)
//			set cleared to true
			cleared = true;
		else
//			set cleared to false
			cleared = false;
	}
	
	/**
	 * String Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @param word A string representing the word
	 */
	public Word(String word)
	{
//		call the array constructor and pass the character array of the string
		this(word.toCharArray( ));
	}
	
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param word A String containing the word
	 * @param randomPlace Boolean indicating a random starting place
	 */
	public Word(String word, boolean randomPlace)
	{
//		call the String constructor
		this(word.toCharArray( ));
		
//		if the starting location needs to be randomized...
		if (randomPlace)
		{
			
			Random r = new Random();
			
//			randomly set the X and Y location
			locX = r.nextInt(TutorGui.WIDTH);
			locY = r.nextInt(TutorGui.HEIGHT);
		}
	}
	
	/**
	 * Copy Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @param word The Word object to copy.
	 */
	public Word(Word word)
	{
//		call the character array constructor
		this(word.getCharacters( ));
		
//		copy the number of the characters cleared
		this.charactersCleared = word.getCharactersCleared( );
		
//		copy the cleared attribute
		this.cleared = word.isCleared( );
		
//		copy the image attached to the word
		if (wordImage != null)
			this.wordImage = copy(word.wordImage);
		else
			this.wordImage = null;
		
//		copy the coordinates of the image
		this.locX = word.locX;
		this.locY = word.locY;
	}
	
	/**
	 * Returns an array containing the characters that make up the word. The array is copy-safe. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @return A safe array of the characters.
	 */
	public char[] getCharacters()
	{
		char[] array = new char[characters.length];
		
		for (int c = 0; c < array.length; c++)
		{
			array[c] = characters[c];
		}
		
		return array;
	}
	
	/**
	 * Returns the number of characters in the word. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @return An integer representing the number of total characters in the word.
	 */
	public int getWordLength()
	{
		return characters.length;
	}
	
	/**
	 * Returns whether or not the word has been cleared. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @return A boolean indicating the cleared state of the word.
	 */
	public boolean isCleared()
	{
		return cleared;
	}
	
	/**
	 * Returns the number of characters cleared. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @return An integer representing the number of characters cleared.
	 */
	public int getCharactersCleared()
	{
		return charactersCleared;
	}
	
	/**
	 * Returns the next character that needs to be typed. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @return A character that is the next valid character.
	 */
	public char getNextChar()
	{
//		if the length of the word is 0 or it is cleared...
		if (characters.length == 0 || cleared)
//			return a sentinal character
			return '~';
		else
//			return the next character that needs to be typed
			return characters[charactersCleared];
	}
	
	public String getClearedChars()
	{
		StringBuffer output = new StringBuffer("");
		
//		for every letter in the characters array and less than the characters already cleared...
		for (int c = 0; c < characters.length && c < charactersCleared; c++)
		{
//			put the letter into the buffer
			output.append(characters[c]);
		}
		
//		return the buffer as a string
		return output.toString( );
	}
	
	/**
	 * Advances the characters that have been typed so far. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 */
	public void advanceCharacter()
	{
		if (charactersCleared < characters.length - 1)
			charactersCleared++;
		else
		{
			if (!cleared)
				charactersCleared++;
			cleared = true;
		}
	}
	
	/**
	 * Resets the word back to the beginning. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 */
	public void reset()
	{
		cleared = false;
		charactersCleared = 0;
	}
	
	/**
	 * Draws a representation of the word on a screen <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @param g The Graphics object to be drawn to
	 */
	public void drawWord(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawString(String.valueOf(characters), locX, locY);
	}
	
	public int getLocX()
	{
		return locX;
	}
	
	public int getLocY()
	{
		return locY;
	}
	
	public void move(int locX, int locY)
	{
		this.locX = locX;
		this.locY = locY;
	}
	
	public void offset(int offX, int offY)
	{
		this.locX += offX;
		this.locY += offY;
	}
	
	/**
	 * Loads an image to be used for the word. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @param imageFile The image to be used for the base word
	 * @throws IOException If the file cannot be read successfully.
	 */
	public void loadImage(File imageFile) throws IOException
	{
		wordImage = ImageIO.read(imageFile);
	}
	
	/**
	 * Performs a deep copy of a buffered image <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param bi The BufferedImage to copy
	 * @return a copy of the BufferedImage
	 */
	static BufferedImage copy(BufferedImage bi) 
	{
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	/**
	 * toString method that displays the word, the characters cleared, and the cleared status. <br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "Word: \"" + String.valueOf(characters) + " (" + locX + ", " + locY + ")" + "\tLength: " + characters.length + 
						"\tCharacters Cleared: " + charactersCleared + "\tNext Character: " + 
						getNextChar( ) + "\tWord Cleared: " + cleared;
	}
}
