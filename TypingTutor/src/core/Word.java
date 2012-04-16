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
		this.characters = new char[characters.length];
		
		for (int c = 0; c < this.characters.length; c++)
		{
			this.characters[c] = characters[c];
		}
		
		charactersCleared = 0;
		if (characters.length == 0)
			cleared = true;
		else
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
		this(word.toCharArray( ));
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
		this(word.getCharacters( ));
		
		this.charactersCleared = word.getCharactersCleared( );
		this.cleared = word.isCleared( );
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
	 * Returns the next character that can be typed. <br>        
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
		if (characters.length == 0 || cleared)
			return '~';
		else
			return characters[charactersCleared];
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
	public String toString()
	{
		return "Word: \"" + String.valueOf(characters) + "\"\tLength: " + characters.length + 
						"\tCharacters Cleared: " + charactersCleared + "\tNext Character: " + 
						getNextChar( ) + "\tWord Cleared: " + cleared;
	}
}
