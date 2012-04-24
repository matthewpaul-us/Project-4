/**
 * ---------------------------------------------------------------------------
 * File name: WordTest.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 15, 2012<br/>
 * Date of Last Modification: Apr 15, 2012
 * ---------------------------------------------------------------------------
 */

package test;

import core.Word;


/**
 * Tests the Word class to make sure it words as designed.<br>
 *
 * <hr>
 * Date created: Apr 15, 2012<br>
 * Date last modified: Apr 15, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class WordTest
{

	/**
	 * Main method of the program<br>        
	 *
	 * <hr>
	 * Date created: Apr 15, 2012 <br>
	 * Date last modified: Apr 15, 2012 <br>
	 *
	 * <hr>
	 * @param args not used
	 */

	public static void main(String [ ] args)
	{
		System.out.println("Creating word \"happy\"");
		
		Word happy = new Word("happy");
		
		System.out.println("Printing happy: " + happy);
		
		Word sad = new Word("sad");
		
		System.out.println("Printing sad: " + sad);
		
		Word blankWord = new Word("");
		
		System.out.println("Printing an empty word: " + blankWord);
		
		System.out.println("Advancing on the blank word");
		
		blankWord.advanceCharacter( );
		
		System.out.println("Printing an empty word: " + blankWord);
		
		System.out.println("Advancing on the happy x 3");
		
		for (int c = 0; c < 3; c++)
		{
			happy.advanceCharacter( );
		}
		
		System.out.println("Printing happy: " + happy);
		System.out.println("Next character for happy at position " + happy.getCharactersCleared( ) + ": " + happy.getNextChar( ));
		
		System.out.println("Advancing on the happy x 3");
		
		for (int c = 0; c < 3; c++)
		{
			happy.advanceCharacter( );
		}
		
		System.out.println("Printing happy: " + happy);
		
		System.out.println("Advancing sad until end");
		
		while(!sad.isCleared( ))
			sad.advanceCharacter( );
		
		System.out.println("Printing sad: " + sad);
		
		System.out.println("Testing character advancement\n\n");
		
		Word testWord = new Word("abcdefghij");
		
		while (!testWord.isCleared( ))
		{
			System.out.println(testWord);
			testWord.advanceCharacter( );
		}
		
		System.out.println(testWord);
		
		testWord.advanceCharacter( );
		
		System.out.println(testWord);
		
		System.out.println("Copying testWord");
		
		Word test2 = testWord.copy( );
		
		System.out.println("Origninal: " + testWord);
		System.out.println("Copy: " + test2);
		
		System.out.println("Changing test2");
		test2.reset( );
		
		System.out.println("Origninal: " + testWord);
		System.out.println("Copy: " + test2);
	}

}
