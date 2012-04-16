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
//	a list of words that are on the screen
	private ArrayList<Word> wordsOnScreen = new ArrayList<Word>();
	
//	a list of words that have the valid inputs. These are the ones that can be typed, given what was typed before
	private ArrayList<Word> acceptableWords = new ArrayList<Word>(),
							
//	the list of words that have been successfully cleared
							clearedWords = new ArrayList<Word>();
	
//	the number of times a word can reach the end without being typed. After each word, it is decremented. When it's less than 1, game over
	private int livesLeft = 3;
	
//	the number of incorrectly typed characters
	private int errors = 0;
	
	

}
