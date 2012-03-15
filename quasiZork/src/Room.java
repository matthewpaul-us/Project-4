/**
 * ---------------------------------------------------------------------------
 * File name: Room.java<br/>
 * Project name: 1260-088-PROJECT4-MiddaughStephen<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Stephen Middaugh, middaughs@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * Represents a room in a dungeon.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */
public class Room
{
	Monster monster;		// The monster that is in the room, if any
	Weapon weapon;			// The weapon that is in the room, if any
	
	/**
	 * @return monster
	 */
	public Monster getMonster ( )
	{
		return monster;
	}
	/**
	 * @return weapon
	 */
	public Weapon getWeapon ( )
	{
		return weapon;
	}
	/**
	 * @param monster the monster to set
	 */
	public void setMonster (Monster monster)
	{
		this.monster = monster;
	}
	/**
	 * @param weapon the weapon to set
	 */
	public void setWeapon (Weapon weapon)
	{
		this.weapon = weapon;
	}
	
	
}
