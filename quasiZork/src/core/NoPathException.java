/**
 * ---------------------------------------------------------------------------
 * File name: NoPathException.java<br/>
 * Project name: quasiZork<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Stephen Middaugh, middaughs@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260<br/>
 * Creation Date: Mar 20, 2012<br/>
 * Date of Last Modification: Mar 20, 2012
 * ---------------------------------------------------------------------------
 */

package core;


/**
 * Represents the exception that is thrown when a player tries to go
 * in an invalid direction.<br>
 *
 * <hr>
 * Date created: Mar 20, 2012<br>
 * Date last modified: Mar 20, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */
public class NoPathException extends Exception
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -1254096067550519033L;

	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 */
	public NoPathException ( )
	{
		this("No path in that direction.");
	}

	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @param arg0
	 */
	public NoPathException (String arg0)
	{
		super (arg0);
	}
}
