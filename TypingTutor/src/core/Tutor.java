/**
 * ---------------------------------------------------------------------------
 * File name: Tutor.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 16, 2012<br/>
 * Date of Last Modification: Apr 16, 2012
 * ---------------------------------------------------------------------------
 */

package core;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Contains the code to handle the collection of words<br>
 *
 * <hr>
 * Date created: Apr 16, 2012<br>
 * Date last modified: Apr 16, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class Tutor
{
	private static final int	DEFAULT_LIVES_LEFT	= 3;

	private static final int	DEFAULT_ERRORS	= 0;

	private static final int 	DEFAULT_SCORE = 0;

	private static final int	CORRECT_WORD_SCORE	= 100;

//	a list of words that are on the screen
	private ArrayList<Word> wordsOnScreen,
	
//	a list of words that have the valid inputs. These are the ones that can be typed, given what was typed before
							acceptableWords,
							
//	the list of words that have been successfully cleared
							clearedWords;
	
//	the number of times a word can reach the end without being typed. After each word, it is decremented. When it's less than 1, game over
	private int livesLeft;
	
	private int score;
	
//	the number of incorrectly typed characters
	private int errors;
	
//	the buffer containing the typed characters
	private StringBuffer buffer;
	
	
	/**
	 * Full Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 * @param wordsOnScreen - an arrayList containing the words that are currently on the screen
	 * @param acceptableWords - an arrayList containing the words that are still acceptable
	 * @param clearedWords - an arrayList containing the words that have been cleared
	 * @param livesLeft - the number of times a word can reach the end point before game over
	 * @param errors - the number of times the player has made an error
	 */
	public Tutor(ArrayList<Word> wordsOnScreen,
	             ArrayList<Word> acceptableWords,
	             ArrayList<Word> clearedWords,
	             int livesLeft,
	             int errors,
	             StringBuffer buffer)
	{
		this.wordsOnScreen = new ArrayList<Word>(wordsOnScreen);
		this.acceptableWords = new ArrayList<Word>(acceptableWords);
		this.clearedWords = new ArrayList<Word>(clearedWords);
		
		this.livesLeft = livesLeft;
		this.errors = errors;
		
		this.buffer = new StringBuffer(buffer);
	}
	
	/**
	 * No-Arg Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 */
	public Tutor()
	{
		this(new ArrayList<Word>(), 
			new ArrayList<Word>(), 
			new ArrayList<Word>(),
			DEFAULT_LIVES_LEFT,
			DEFAULT_ERRORS,
			new StringBuffer(""));
	}
	
	public void processCharacter(KeyEvent key)
	{
		char character = key.getKeyChar( );
		
		boolean characterFound = false;
		
		for (int c = 0; c < acceptableWords.size( ); c++)
		{
			if (character == acceptableWords.get(c).getNextChar( ))
			{
				score += CORRECT_WORD_SCORE;
				buffer.append(character);
				characterFound = true;
				
				acceptableWords.get(c).advanceCharacter( );
				
				if(acceptableWords.get(c).isCleared( ))
				{
					wordsOnScreen.remove(acceptableWords.get(c));
					clearedWords.add(acceptableWords.get(c));
					acceptableWords.remove(c);
					
					acceptableWords = new ArrayList<Word>(wordsOnScreen);
				}
			}
			else
			{
				acceptableWords.get(c).reset( );
				acceptableWords.remove(c);
			}
		}
		
		if(!characterFound)
		{
			errors++;
		}
	}
	
	/**
	 * Draws the game. Meant to be overridded by the child class. <br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 * @param g The graphics object to be written to
	 * @param deltaTime The time elapsed since the last frame
	 */
	public void drawGame(Graphics g)
	{
		
	}
	
	/**
	 * Updates the game. Meant to be overridden. <br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 * @param deltaTime The time elapsed since the last frame
	 */
	public void update(int deltaTime)
	{
		
	}
	
	/**
	 * Method that informs the user that he has failed. Meant to be overridden. <br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 */
	public void gameOver()
	{
		
	}
	
	/**
	 * Initializes the game. Meant to be overridden. <br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 */
	public void initialize()
	{
		
	}
	
	
}
