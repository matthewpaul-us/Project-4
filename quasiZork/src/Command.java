/**
 * ---------------------------------------------------------------------------
 * File name: Commands.java<br/>
 * Project name: 1260-088-Project4-PaulMatthew<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public enum Command
{
	ERROR,
	GO_WEST,
	GO_EAST;
	
	/**
	 * Maps an integer to a Command. Command returned is based on ordinal value <br>        
	 *
	 * <hr>
	 * Date created: Feb 4, 2012 <br>
	 * Date last modified: Feb 4, 2012 <br>
	 *
	 * <hr>
	 * @param integer
	 * @return MenuChoice
	 */
	public static Command convert(int integer)
	{
		for(Command choice: Command.values( ))
		{
			if(integer == choice.ordinal( ))
				return choice;
		}
		
//		If this part of code is reached, then the integer doesnt have a value
//		and null is returned
		return null;
	}

}
