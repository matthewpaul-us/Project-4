/**
 * ---------------------------------------------------------------------------
 * File name: WordPool.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 16, 2012<br/>
 * Date of Last Modification: Apr 16, 2012
 * ---------------------------------------------------------------------------
 */

package core;

import java.util.LinkedList;
import java.util.Queue;


/**
 * A collection of words that are held. To be given out to the Tutor class at
 *  predetermined intervals<br>
 *
 * <hr>
 * Date created: Apr 16, 2012<br>
 * Date last modified: Apr 16, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class WordPool
{
	
	
//////////////////
//
//FIELDS
//
//////////////////
	
	
//	a first-in-first-out queue of the words in the pool. Can be replaced with an arrayList if need be
	private Queue<Word> queue;
	
	
//////////////////
//
//CONSTRUCTORS
//
//////////////////


	/**
	 * Constructor. Places word array into queue in the order of the array. <br>        
	 *
	 * <hr>
	 * Date created: Apr 16, 2012 <br>
	 * Date last modified: Apr 16, 2012 <br>
	 *
	 * <hr>
	 * @param words Array of words to be inserted
	 */
	public WordPool(Word[] words)
	{
		queue = new LinkedList<Word>();
		
		for (int c = 0; c < words.length; c++)
		{
			queue.add(words[c].copy( ));
		}
	}
	
	
	/**
	 * No-Arg Constructor. Creates an empty word pool. <br>        
	 *
	 * <hr>
	 * Date created: Apr 16, 2012 <br>
	 * Date last modified: Apr 16, 2012 <br>
	 *
	 * <hr>
	 */
	public WordPool()
	{
		queue = new LinkedList<Word>();
	}
	
	
//////////////////
//
//FIELDS
//
//////////////////

	
	/**
	 * Adds a word to the end of the queue. <br>        
	 *
	 * <hr>
	 * Date created: Apr 16, 2012 <br>
	 * Date last modified: Apr 16, 2012 <br>
	 *
	 * <hr>
	 * @param word Word object to be added.
	 */
	public void addWord(Word word)
	{
		queue.add(word.copy( ));
	}
	
	/**
	 * Retrieves the next word in the pool. <br>        
	 *
	 * <hr>
	 * Date created: Apr 16, 2012 <br>
	 * Date last modified: Apr 16, 2012 <br>
	 *
	 * <hr>
	 * @return The next word object
	 */
	public Word getNextWord()
	{
		return queue.poll( ).copy( );
	}
	
	/**
	 * Returns whether or not there are more words left in the pool. <br>        
	 *
	 * <hr>
	 * Date created: Apr 16, 2012 <br>
	 * Date last modified: Apr 16, 2012 <br>
	 *
	 * <hr>
	 * @return Boolean indicating presence of words. True means there is at least one word in the queue.
	 */
	public boolean hasMoreWords()
	{
		return !queue.isEmpty( );
	}

}
