/**
 * ---------------------------------------------------------------------------
 * File name: LaserCanvas.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 19, 2012<br/>
 * Date of Last Modification: Apr 19, 2012
 * ---------------------------------------------------------------------------
 */

package laserDefense;

import front.TutorCanvas;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 19, 2012<br>
 * Date last modified: Apr 19, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class LaserCanvas extends TutorCanvas
{
	
//////////////////
//
//FIELDS
//
//////////////////
	
	private static final long	serialVersionUID	= 1L;

	
//////////////////
//
//CONSTRUCTORS
//
//////////////////
	
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 */
	public LaserCanvas()
	{
		super();
		
		game = new LaserTutor();
		
		game.initialize( );
	}
	
//////////////////
//
//METHODS
//
//////////////////
	
	/**
	 * Resets the game and initializes it. <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 * @see front.TutorCanvas#reset()
	 */
	@Override
	public void reset()
	{
		game = new LaserTutor( );
		game.initialize( );
	}

}
