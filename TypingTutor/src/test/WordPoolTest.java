/**
 * ---------------------------------------------------------------------------
 * File name: WordPoolTest.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 19, 2012<br/>
 * Date of Last Modification: Apr 19, 2012
 * ---------------------------------------------------------------------------
 */

package test;

import java.io.IOException;
import core.FileOperator;
import core.Word;
import core.WordPool;


/**
 * Tests the WordPool Class<br>
 *
 * <hr>
 * Date created: Apr 19, 2012<br>
 * Date last modified: Apr 19, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class WordPoolTest
{

	/**
	 * Main method <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param args - not used
	 */

	public static void main(String [ ] args)
	{
		FileOperator file = new FileOperator( );
		
		String [ ] lines = null;
		
		try
		{
			lines = file.read(FileOperator.WORD_FILE);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Word[] words = new Word[lines.length];
		
		for (int c = 0; c < words.length; c++)
		{
			words[c] = new Word(lines[c]);
		}
		
		WordPool pool = new WordPool(words);		
		
		System.out.println("WordPool empty state:" + pool.hasMoreWords( ));
		
		while(pool.hasMoreWords( ))
		{
			System.out.println("Fetching word from pool: " + pool.getNextWord( ));
			try
			{
				Thread.sleep(700);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Finished with wordPool");
	}

}
