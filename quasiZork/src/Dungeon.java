/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java<br/>
 * Project name: 1260-088-PROJECT4-MiddaughStephen<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Stephen Middaugh, middaughs@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260<br/>
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
 * @author Stephen Middaugh
 */
import java.util.Random;
public class Dungeon
{
	private int playerLocation;
	private Room[] rooms;
	
	
	public Dungeon()
	{
		Random rand = new Random();
		rooms = new Room[rand.nextInt(6) + 5];
	}
	
	public void populateDungeon()
	{
		Random rand = new Random();
		
		for (int i = 1; i < rooms.length; i++ )
		{
			if (rand.nextInt (2) == 1)
			{	
				rooms[i].setMonster(new Monster());
			}
		}
		
		rooms[rand.nextInt(9)].setWeapon(null);
		
	}
}
