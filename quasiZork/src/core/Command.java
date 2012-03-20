package core;


/**
 * The commands that are returned from the text processor.<br>
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
	EXIT,
	GO_NORTH,
	GO_EAST,
	GO_SOUTH,
	GO_WEST;
	
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
