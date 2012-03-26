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

package core;

import java.util.StringTokenizer;

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
											 "Move",
											 "G"};
	
	private static final String[] westArray = {"West",
											   "W",
											   "Left",
											   "L"};
	
	private static final String[] eastArray = {"East",
											   "E",
											   "Right",
											   "R"};
	
	private static final String[] northArray = {"North",
		   									   "N",
											   "Up",
											   "U"};
	
	private static final String[] southArray = {"South",
		   									   "S",
											   "Down",
											   "D"};
	
	private static final String[] exitArray = {"Exit",
												"Close",
												"Quit",
												"Q"};
	/**
	 * Processes a string input to standardize the inputs. <br>        
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
//		if the input is not just whitespace
		if (input.length( )!= 0 && input.split(" ").length != 0)
		{
//			prepare the tokenizer to parse the string input by the default (a space)
			StringTokenizer strTokenizer = new StringTokenizer(input);

//			create array to store the parsed input
			String[] inputArray = new String[strTokenizer.countTokens( )];

//			copy the parsed input into the array
			for (int c = 0; c < inputArray.length && strTokenizer.hasMoreTokens( ); c++)
			{
				inputArray[c] = strTokenizer.nextToken( );
			}

//			check to see if it was a go command
			boolean isGoCommand = isInGoArray(inputArray[0]);

//			if it was, check if the direction was valid
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

//				if not a valid direction, return error
				else
					return Command.ERROR;
			}
			
//			if it wasn't a go command, is it an exit command
			else if (isInExitArray(inputArray[0]))
			{	
				return Command.EXIT;
			}	
		}
		
//		if the input is only whitespace return an error Command
		return Command.ERROR;
	}
	
	/**
	 * Checks to see if the string is a synonym for exit. <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 * @param input
	 * @return
	 */
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
