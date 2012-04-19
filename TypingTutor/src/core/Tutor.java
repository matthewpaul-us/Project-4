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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import front.Gui;
import front.TutorGui;


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
	
//	the wordpool from which the game draws its words
	private WordPool pool;
	
	
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
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 * @param array a String array containing the starting words
	 */
	public Tutor(String[] array)
	{
		this(new ArrayList<Word>(), 
			new ArrayList<Word>(), 
			new ArrayList<Word>(),
			DEFAULT_LIVES_LEFT,
			DEFAULT_ERRORS,
			new StringBuffer(""));
		
		ArrayList<Word> list = new ArrayList<Word>();
		
		for (String word: array)
		{
			list.add(new Word(word, true));
		}
		
		this.wordsOnScreen = list;
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
	
	/**
	 * Processes the character that the user has typed. <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 * @param key a KeyEvent generated by the keyboard
	 */
	public void processCharacter(KeyEvent key)
	{
//		get the character from the KeyEvent
		char character = key.getKeyChar( );
		
//		assume the character was not found
		boolean characterFound = false;
		
//		stick the character into the buffer
		buffer.append(character);
		
//		for every word in the acceptable word list
		for (int c = 0; c < acceptableWords.size( ); c++)
		{
//			if the character equals the next character in the word from the list
			if (character == acceptableWords.get(c).getNextChar( ))
			{
//				the character has been found
				characterFound = true;
				
//				Tell the word that they have had a correct character typed, so move pointer up one character
				acceptableWords.get(c).advanceCharacter( );
				
//				if the character typed finished the word
				if(acceptableWords.get(c).isCleared( ))
				{
//					add the correct amount to the score
					score += CORRECT_WORD_SCORE;
					
//					remove the word from the words on the screen
					wordsOnScreen.remove(acceptableWords.get(c));
					
//					add the word to the list of cleared words
					clearedWords.add(acceptableWords.get(c));
					
//					remove the word from the list of acceptable words
					acceptableWords.remove(c);
					
//					set the acceptable words to all the words on the screen
					acceptableWords = new ArrayList<Word>(wordsOnScreen);
					
//					for every word in the acceptable word list
					for (Word word: acceptableWords)
					{
//						reset the word's pointer back to 0
						word.reset( );
					}
					
//					clear the buffer
					buffer.delete(0, buffer.length( ));
				}
			}
		}
		
//		if, by the end of the loop, the character was not found
		if(!characterFound)
		{
//			increment error
			errors++;
			
//			delete the wrong key from the buffer
			buffer.deleteCharAt(buffer.length( ) - 1);
		}
		
//		for every word in the acceptable word list
		for (int i = 0; i < acceptableWords.size( ); i++)
		{
//			if the word's already typed characters does not equal what's in the buffer
			if (!acceptableWords.get(i).getClearedChars( ).equals(buffer.toString( )))
			{
//				remove the word from the list of acceptable words
				acceptableWords.remove(i);
//				decrement the iterating variable to keep subscripts in the correct place
				i--;
			}
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
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(frameCount), Gui.WIDTH / 2, Gui.HEIGHT / 2);
		
		StringBuffer output = new StringBuffer("");
		
		for (Word word: wordsOnScreen)
		{
			word.drawWord(g);
		}
		
		for (Word word: acceptableWords)
		{
			output.append(String.valueOf(word.getCharacters( )) + " ");
		}
		
		
		g.drawString("Score: " +String.valueOf(score) + " Errors: " + String.valueOf(errors) +
			" Lives Left: " + String.valueOf(livesLeft), 10, Gui.HEIGHT - 20);
		g.drawString(output.toString( ), 10, Gui.HEIGHT - 10);
		g.drawString(buffer.toString( ), 10, Gui.HEIGHT);
	}
	
	int frameCount;
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
		frameCount++;
		
		for (int c = 0; c < wordsOnScreen.size( ); c++)
		{
			if (frameCount % 4 == 0)
				wordsOnScreen.get(c).offset(0, 1);
			
			if (wordsOnScreen.get(c).getLocY( ) > TutorGui.HEIGHT)
			{
				wordsOnScreen.remove(c);
				livesLeft--;
			}
		}
		
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
		acceptableWords = new ArrayList <Word>(wordsOnScreen);		
	}
	
	
}
