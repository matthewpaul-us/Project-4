package core;

import java.util.StringTokenizer;

/**
 * ---------------------------------------------------------------------------
 * File name: TextProcessor.java<br/>
 * Project name: 1260-088-Project4-PaulMatthew<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * Handles all the text processing for the Zork game.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class TextProcessor
{
	private static final String[] goArray = {"Go",
											 "Travel",
											 "Move"};
	
	private static final String[] westArray = {"West",
											   "W",
											   "Left"};
	
	private static final String[] eastArray = {"East",
											   "E",
											   "Right"};
	
	private static final String[] northArray = {"North",
		   									   "N",
											   "Up"};
	
	private static final String[] southArray = {"South",
		   									   "S",
											   "Down"};
	
	private static final String[] exitArray = {"Exit",
												"Close",
												"Quit"};
	/**
	 * Processes a string input to standardize the directions. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param input
	 * @return
	 */
	public static Command process(String input)
	{
		StringTokenizer strTokenizer = new StringTokenizer(input);
		
		String[] inputArray = new String[strTokenizer.countTokens( )];
		
		for (int c = 0; c < inputArray.length && strTokenizer.hasMoreTokens( ); c++)
		{
			inputArray[c] = strTokenizer.nextToken( );
		}
		
		boolean isGoCommand = isInGoArray(inputArray[0]);
		
		if (isGoCommand)
		{
			if (isInNorthArray(inputArray[1]))
				return Command.GO_NORTH;
			else if (isInEastArray(inputArray[1]))
				return Command.GO_EAST;
			else if (isInSouthArray(inputArray[1]))
				return Command.GO_SOUTH;
			else if (isInWestArray(inputArray[1]))
				return Command.GO_WEST;
			
			else
				return Command.ERROR;
		}
		else if (isInExitArray(inputArray[0]))
			return Command.EXIT;
		
		return Command.ERROR;
	}
	
	public static boolean isInExitArray(String input)
	{
		for (String text: exitArray)
		{
			if (input.equalsIgnoreCase(text))
				return true;
		}
		
		return false;
	}

	/**
	 * Checks to see if the string is a synonym for go. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param input
	 * @return true if it is a go synonym
	 */
	public static boolean isInGoArray(String input)
	{
		for (String text: goArray)
		{
			if (input.equalsIgnoreCase(text))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the string is a synonym for north. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param input
	 * @return true if it is a north synonym
	 */
	public static boolean isInNorthArray(String input)
	{
		for (String text: northArray)
		{
			if (input.equalsIgnoreCase(text))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the string is a synonym for east. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param input
	 * @return true if it is a east synonym
	 */
	public static boolean isInEastArray(String input)
	{
		for (String text: eastArray)
		{
			if (input.equalsIgnoreCase(text))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the string is a synonym for west. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param input
	 * @return true if it is a west synonym
	 */
	public static boolean isInSouthArray(String input)
	{
		for (String text: southArray)
		{
			if (input.equalsIgnoreCase(text))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the string is a synonym for west. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param input
	 * @return true if it is a west synonym
	 */
	public static boolean isInWestArray(String input)
	{
		for (String text: westArray)
		{
			if (input.equalsIgnoreCase(text))
				return true;
		}
		
		return false;
	}
	
	
}
