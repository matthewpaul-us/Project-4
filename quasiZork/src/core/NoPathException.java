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
 * Enter type purpose here<br>
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
	public NoPathException (Throwable arg0)
	{
		super (arg0);
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
	 * @param arg1
	 */
	public NoPathException (String arg0, Throwable arg1)
	{
		super (arg0, arg1);
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
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public NoPathException (String arg0, Throwable arg1, boolean arg2, boolean arg3)
	{
		super (arg0, arg1, arg2, arg3);
	}

}
