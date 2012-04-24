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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


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
//////////////////
//
//FIELDS
//
//////////////////
	
//	the collection of characters that make up the word
	protected char[] characters;
	
//	the number of characters that has been typed
	protected int charactersCleared;
	
//	whether or not the word has already been typed
	protected boolean cleared;
	
//	the picture that represents the word
	protected BufferedImage wordImage = null;
	
//	the coordinates of the word on the canvas
	protected int locX,
				  locY;
	
	
//////////////////
//
//CONSTRUCTORS
//
//////////////////
	
	
	
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
			this.characters[c] = Character.toLowerCase(characters[c]);
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
		this(word.toLowerCase( ).toCharArray( ));
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
	public Word(String word, int x, int y)
	{
//		call the String constructor
		this(word.toCharArray( ));
		
		locX = x;
		locY = y;

	}
	
	
//////////////////
//
//METHODS
//
//////////////////
	
	
	/**
	 * Copy method to perform a polymorphically correct deep copy. <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @return A Word object that is a copy of the calling object.
	 */
	public Word copy()
	{
		Word copy = new Word(this.getCharacters( ));
//		call the character array constructor
		
//		copy the number of the characters cleared
		copy.charactersCleared = this.charactersCleared;
		
//		copy the cleared attribute
		copy.cleared = this.cleared;
		
//		copy the image attached to the word
		if (this.wordImage != null)
			copy.wordImage = this.wordImage;
		else
			copy.wordImage = null;
		
//		copy the coordinates of the image
		copy.locX = this.locX;
		copy.locY = this.locY;
		return copy;
	}
	
	/**
	 * @return wordImage
	 */
	public BufferedImage getWordImage()
	{
		return wordImage;
	}

	/**
	 * @param wordImage the wordImage to set
	 */
	public void setWordImage(BufferedImage wordImage)
	{
		this.wordImage = wordImage;
	}

	/**
	 * @param characters the characters to set
	 */
	public void setCharacters(char [ ] characters)
	{
		this.characters = characters;
	}

	/**
	 * @param charactersCleared the charactersCleared to set
	 */
	public void setCharactersCleared(int charactersCleared)
	{
		this.charactersCleared = charactersCleared;
	}

	/**
	 * @param cleared the cleared to set
	 */
	public void setCleared(boolean cleared)
	{
		this.cleared = cleared;
	}

	/**
	 * @param locX the locX to set
	 */
	public void setLocX(int locX)
	{
		this.locX = locX;
	}
	
	/**
	 * Getter for X-coordinate <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getLocX()
	{
		return locX;
	}
	
	/**
	 * @param locY the locY to set
	 */
	public void setLocY(int locY)
	{
		this.locY = locY;
	}

	/**
	 * Getter for Y-coordinate <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int getLocY()
	{
		return locY;
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
	
	/**
	 * Returns a string with the letters that have been cleared so far. <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @return A String with cleared letters.
	 */
	public String getClearedString()
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

	
	/**
	 * Moves the word to the specified location <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @param locX int that contains the x location of the word, in pixels
	 * @param locY int that contains the y location of the word, in pixels
	 */
	public void move(int locX, int locY)
	{
		this.locX = locX;
		this.locY = locY;
	}
	
	/**
	 * Adds the specified offset to the word <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @param offX the offset in the X axis, in pixels
	 * @param offY the offset in the Y axis, in pixels
	 */
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
	@Override
	public String toString()
	{
		return "Word: \"" + String.valueOf(characters) + " (" + locX + ", " + locY + ")" + "\tLength: " + characters.length + 
						"\tCharacters Cleared: " + charactersCleared + "\tNext Character: " + 
						getNextChar( ) + "\tWord Cleared: " + cleared + " Image: " + wordImage;
	}
}
