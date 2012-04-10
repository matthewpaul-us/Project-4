/**
 * ---------------------------------------------------------------------------
 * File name: BallNumber.java<br/>
 * Project name: poolSimulator<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 10, 2012<br/>
 * Date of Last Modification: Apr 10, 2012
 * ---------------------------------------------------------------------------
 */

package core;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 10, 2012<br>
 * Date last modified: Apr 10, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public enum BallNumber
{	CUE,
	ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, 
	EIGHT, 
	NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN;
	
	public boolean isStriped()
	{
		if (ordinal( ) < NINE.ordinal( ))
			return false;
		else
			return true;
	}
}
