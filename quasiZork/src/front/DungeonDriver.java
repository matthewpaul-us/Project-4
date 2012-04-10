/**
 * ---------------------------------------------------------------------------
go  * File name: DungeonDriver.java<br/>
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
import core.NoPathException;
import core.Player;
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
//	The title to show the players on start-up
	private final static String[] TITLE = {"            ---Zorkesque---",
				    					   "A Victorian-era replica of an even older game.",
				    					   "You wake up to find yourself in a dank dungeon."};
	
//	the help to show the player on start-up
	private final static String[] HELP = {"     HELP",
										  "Zorkesque is a text based random dungeon crawler that pits players against",
										  "monsters in a FIGHT TO THE DEATH! The map shows the dungeon, as well as where",
										  "you can go.",
										  "",
										  "     |_P_o_____> <___8_____> <___°_W_M_>",
										  "     ^ ^ ^     ^ ^   ^           ^ ^ ^",
										  "     | | |     | |   Doors N/S   | | Monster",
										  "     | | Door S| Door W          | Weapon",
										  "     | Player  Door E            Door N",
										  "     Wall",
										  "",
										  "To do something, type the action you want. For example, to go south, type",
										  "\"Go South\", \"Travel e\", or if you want to exit, \"exit.\""};
	
//	the starting health of the player
	private static final double	STARTING_HEALTH	= 100;

//	the default height of the dungeon space
	private static final int	DEFAULT_HEIGHT	= 5;

//	the default width of the dungeon space
	private static final int	DEFAULT_WIDTH	= 10;

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
//		generate a new dungeon with the default width and height
		dungeon = new Dungeon(DEFAULT_HEIGHT, DEFAULT_WIDTH, 0);
		Command lastCommand = null;
//		Display title to user
		displayTitle();
		String name = getPlayerName();
		
//		Put the player into the dungeon
		dungeon.enterDungeon(new Player(name, STARTING_HEALTH) );
//		WHILE player doesn't want to exit program
		while (lastCommand != Command.EXIT && dungeon.isPlayerAlive())
		{
//			display the map and stats to the user
			displayHud();
//			get input from user and process it
			lastCommand = TextProcessor.process(getUserInput());
//			act on user input
			performCommand(lastCommand);
//			wait for the player to read result
			waitForUser();
		}
//		ask if user wants to play again
		System.out.println("Thanks for playing Zerkesque!");
	}
	

	/**
	 * Collects the player's name from the user. If user just presses enter,
	 * return the default name "player". <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 * @return the name of the player
	 */
	private static String getPlayerName()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What would you like your character's name to be? ");
		
		String name = keyboard.nextLine();
		return (name.trim( ).length( ) == 0? "Player" : name);
	}

	/**
	 * calls a method based on the command received. <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 * @param lastCommand the command from the processed user input
	 */
	private static void performCommand(Command lastCommand)
	{
//		in all of these commands, if there is no door, it will catch the noPathException and print an error message
		switch (lastCommand)
		{
			case GO_NORTH:
				try
				{
					System.out.println(dungeon.movePlayer(lastCommand));
				}
				catch (NoPathException e)
				{
					System.out.println("There is no door in the north wall!");
				}
				break;
			case GO_EAST:
				try
				{
					System.out.println(dungeon.movePlayer(lastCommand));
				}
				catch (NoPathException e)
				{
					System.out.println("There is no door in the east wall!");
				}
				break;
			case GO_SOUTH:
				try
				{
					System.out.println(dungeon.movePlayer(lastCommand));
				}
				catch (NoPathException e)
				{
					System.out.println("There is no door in the south wall!");
				}
				break;
			case GO_WEST:
				try
				{
					System.out.println(dungeon. movePlayer(lastCommand));
				}
				catch (NoPathException e)
				{
					System.out.println("There is no door in the west wall!");
				}
				break;
//			if the user wants to exit, do nothing. The while loop will take care of that
			case EXIT:
				break;
//			if the command is an error, print an error message
			case ERROR:
				System.out.println("I'm sorry, I don't know what you want to do. Please try again.");
//			Should never reach this point. If it does, there has been a serious error.
			default:
				break;
		}
	}

	/**
	 * Returns a unmodified string with the user's input. <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 * @return the user's input
	 */
	private static String getUserInput()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What would you like to do?");
		return keyboard.nextLine( );
	}

	/**
	 * Displays the map and the player status to the player. <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 */
	private static void displayHud()
	{
		System.out.println(dungeon.getDungeonString( ));
		System.out.println(dungeon.getPlayerStatusString( ));
	}

	/**
	 * Displays the title and then the help messages <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 */
	private static void displayTitle()
	{
		for (String text: TITLE)
		{
			System.out.println(text);
		}
		
		for (String text: HELP)
		{
			System.out.println(text);
		}
	}
	
	/**
	 * Waits for the user to hit enter. <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 */
	private static void waitForUser()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("(Press Enter)");
		keyboard.nextLine( );
	}
}
