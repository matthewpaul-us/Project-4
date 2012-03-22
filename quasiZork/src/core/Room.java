package core;
import java.util.ArrayList;
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
	Player player;
	Monster monster;		// The monster that is in the room, if any
	Weapon weapon;			// The weapon that is in the room, if any
	
	boolean northDoor,
			eastDoor,
			southDoor,
			westDoor;
	
	final public static int NORTH_DOOR = 0,
					 		EAST_DOOR = 1,
				 			SOUTH_DOOR = 2,
							WEST_DOOR = 3;
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 19, 2012 <br>
	 * Date last modified: Mar 19, 2012 <br>
	 *
	 * <hr>
	 */
	public Room()
	{
		this(null, null, null);
	}
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @param monster
	 * @param weapon
	 * @param doorArray
	 */
	public Room(Monster monster, Weapon weapon, int[] doorArray)
	{
		setMonster(monster);
		setWeapon(weapon);
		setDoors(doorArray, true);
	}
		
	/**
	 * Copy Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @param room
	 */
	public Room(Room room)
	{
		this(room.getMonster( ), room.getWeapon( ), room.getDoors( ));
	}
	
	/**
	 * Returns an array of the doors, suitable for passing to a door constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public int[] getDoors()
	{
		ArrayList<Integer> doorList= new ArrayList<Integer>(); 
		
		if (northDoor)
			doorList.add(NORTH_DOOR);
		if (eastDoor)
			doorList.add(EAST_DOOR);
		if (southDoor)
			doorList.add(SOUTH_DOOR);
		if (westDoor)
			doorList.add(WEST_DOOR);
		int[] array = new int[doorList.size()];
		
		for (int c = 0; c < array.length; c++)
		{
			array[c] = doorList.get(c);
		}
		
		return array;

	}
	
	/**
	 * Returns whether there is a door on the direction input. <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @param direction
	 * @return true if there is a door
	 */
	public boolean isDoor(int direction)
	{
		switch (direction)
		{
			case NORTH_DOOR:
				return northDoor;
			case EAST_DOOR:
				return eastDoor;
			case SOUTH_DOOR:
				return southDoor;
			case WEST_DOOR:
				return westDoor;
			default:
				return false;
		}
	}
	/**
	 * Places doors on the appropriate walls. Use the constants defined in 
	 * Room class for array values. <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @param array
	 * @param b
	 */
	public void setDoors(int[] array, boolean b)
	{
		
		if (array != null)
		{
			for (int c = 0; c < array.length; c++ )
			{
				setDoor(array [c], b);
			}
		}
		else
		{
			setDoor(NORTH_DOOR, false);
			setDoor(EAST_DOOR, false);
			setDoor(SOUTH_DOOR, false);
			setDoor(WEST_DOOR, false);

		}
	}
	
	/**
	 * Sets a single door to a specific boolean value. Uses the constants
	 * defined in the Room class. <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @param door
	 * @param b
	 */
	private void setDoor(int door, boolean b)
	{
		switch(door)
		{
			case NORTH_DOOR:
				northDoor = b;
				break;
			case EAST_DOOR:
				eastDoor = b;
				break;
			case SOUTH_DOOR:
				southDoor = b;
				break;
			case WEST_DOOR:
				westDoor = b;
				break;
		}
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
	
	/**
	 * @return player
	 */
	public Player getPlayer()
	{
		return (player != null? new Player(player): null);
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player)
	{
		this.player = (player != null? new Player(player): null);
	}
	
	/**
	 * Returns a string representing the room suitable for showing to the player <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public String getRoomString()
	{
		char midDoorSymbol = '_';
		
//		figure out the symbol for the north and south doors
		if (isDoor(NORTH_DOOR) && isDoor(SOUTH_DOOR))
			midDoorSymbol = '8';
		else if (isDoor(NORTH_DOOR))
			midDoorSymbol = '\u00b0';
		else if (isDoor(SOUTH_DOOR))
			midDoorSymbol = 'o';
		
//		this will return something like this: |_P_o_W_M_>
		return (isDoor(WEST_DOOR)? '<': '|') + "_" + (player != null? "P": "_") + '_' + midDoorSymbol + "_" + (weapon != null? "W": "_") +
				   		"_" + (monster != null? "M": "_") + "_" + (isDoor(EAST_DOOR)? '>': '|');
	}

	/**
	 * Returns a string showing the state of the room. Suitable for debugging. <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "@---" + (isDoor(NORTH_DOOR)? "+": "-") + "---@\n" +
			   "|       |\n" +
			   (isDoor(WEST_DOOR)? "+": "|") + " " + (player != null? "P": " ") + " " + (monster != null? "M": " ") +
			   		" " + (weapon != null? "W": " ") + " " + (isDoor(EAST_DOOR)? "+": "|") + "\n" +
			   "|       |\n" +
			   "@---" + (isDoor(SOUTH_DOOR)? "+": "-") + "---@" + "\n" +
			   "Monster: " + (monster != null? monster.toString( ): "null") + 
			   "\tWeapon: " + (weapon != null? weapon.toString( ): "null");
	}
}
