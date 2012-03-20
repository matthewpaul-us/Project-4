/**
 * ---------------------------------------------------------------------------
 * File name: DungeonDriver.java<br/>
 * Project name: quasiZork<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 15, 2012<br/>
 * Date of Last Modification: Mar 15, 2012
 * ---------------------------------------------------------------------------
 */

package front;

import java.util.Scanner;
import core.Command;
import core.Dungeon;
import core.TextProcessor;


/**
 * The driver for the dungeon class.<br>
 *
 * <hr>
 * Date created: Mar 15, 2012<br>
 * Date last modified: Mar 15, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class DungeonDriver
{
	private final static String[] TITLE = {"            ---Zorkesque---",
				    					   "A Victorian-era replica of an even older game.",
				    					   "You wake up to find yourself in a dank dungeon."};

	private static Dungeon dungeon;
	/**
	 * Main method for the dungeon driver <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @param args
	 */

	public static void main(String [ ] args)
	{
		dungeon = new Dungeon();
		Command lastCommand = null;
//		Display title to user
		displayTitle();
		
//		Put the player into the dungeon
		dungeon.enterDungeon( );
//		WHILE player doesn't want to exit program
		while (lastCommand != Command.EXIT)
		{
//			display the map and stats to the user
			displayHud();
//			get input from user and process it
			lastCommand = TextProcessor.process(getUserInput());
//			act on user input
			performCommand(lastCommand);
		}
//		ask if user wants to play again
		System.out.println("Thanks for playing Zerkesque!");
	}
	
	private static void performCommand(Command lastCommand)
	{
		switch (lastCommand)
		{
			case GO_NORTH:
				dungeon.movePlayer(lastCommand);
				break;
			case GO_EAST:
				dungeon.movePlayer(lastCommand);
				break;
			case GO_SOUTH:
				dungeon.movePlayer(lastCommand);
				break;
			case GO_WEST:
				dungeon. movePlayer(lastCommand);
				break;
			case EXIT:
				break;
			case ERROR:
				System.out.println("I'm sorry, I don't know what you want to do. Please try again.");
			default:
				break;
		}
	}

	private static String getUserInput()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What would you like to do?");
		return keyboard.nextLine( );
	}

	private static void displayHud()
	{
		System.out.println("HUD Stub");
	}

	private static void displayTitle()
	{
		for (String text: TITLE)
		{
			System.out.println(text);
		}
	}
}
