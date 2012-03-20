/**
 * ---------------------------------------------------------------------------
 * File name: DungeonTest.java<br/>
 * Project name: quasiZork<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 15, 2012<br/>
 * Date of Last Modification: Mar 15, 2012
 * ---------------------------------------------------------------------------
 */

package test;

import core.Command;
import core.Dungeon;


/**
 * Tests the dungeon class.<br>
 *
 * <hr>
 * Date created: Mar 15, 2012<br>
 * Date last modified: Mar 15, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class DungeonTest
{

	/**
	 * Driver for the DungeonTest class. <br>        
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
		Dungeon dungeon = new Dungeon();
		System.out.println(dungeon);
		
		System.out.println("Entering Dungeon");
		dungeon.enterDungeon( );
		System.out.println(dungeon);
		
		System.out.println("Moving player to second room");
		dungeon.movePlayer(Command.GO_EAST);
		System.out.println(dungeon);
		
		System.out.println("Moving player to exit");
		
		System.out.println(dungeon);

	}

}
