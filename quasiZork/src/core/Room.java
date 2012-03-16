package core;
import weapons.Weapon;
import monsters.Monster;


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
	
	public Room()
	{
		this(null, null);
	}
	
	public Room(Monster monster, Weapon weapon)
	{
		setMonster(monster);
		setWeapon(weapon);
	}
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
		this.monster = (monster != null? new Monster(monster): null);
	}
	/**
	 * @param weapon the weapon to set
	 */
	public void setWeapon (Weapon weapon)
	{
		this.weapon = (weapon != null? weapon.copy( ): null);
	}
	
	public String toString()
	{
		return "|_" + (monster != null? "M": "") + "_" + (weapon != null? "W": "") + "_|\n" +
			   "Monster: " + (monster != null? monster.toString( ): "null") + 
			   "\tWeapon: " + (weapon != null? weapon.toString( ): "null");
	}
}
