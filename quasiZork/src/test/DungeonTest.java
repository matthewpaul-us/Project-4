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
import core.NoPathException;
import core.Player;


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
	static public int[][] heatMap;

	/**
	 * Driver for the DungeonTest class. <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @param args
	 * @throws NoPathException 
	 */

	public static void main(String [ ] args) throws NoPathException
	{
//		Dungeon dungeon = new Dungeon(true);
//		System.out.println(dungeon.getDungeonString( ));
//		
//		System.out.println("Entering Dungeon");
//		dungeon.enterDungeon(new Player() );
//		System.out.println(dungeon.getDungeonString( ));
//		
//		System.out.println("Moving player to east room");
//		dungeon.movePlayer(Command.GO_EAST);
//		System.out.println(dungeon.getDungeonString( ));
//
//
//		System.out.println(dungeon);
		
		Dungeon dungeon = null;
		
		dungeon = new Dungeon(5, 10, 0);

		System.out.println(dungeon.getDungeonString( ));

	}

}
