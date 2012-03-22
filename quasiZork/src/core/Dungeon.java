package core;


import java.util.Random;
import monsters.Monster;
import weapons.Stick;
import weapons.Sword;
import weapons.Weapon;

/**
 * Represents a collection of rooms that make up a dungeon.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */

public class Dungeon
{
	private int playerXCoordinate;	// The players location in the dungeon. 0 = start.
	private int playerYCoordinate;
	private Room[][] rooms;	// The collection of rooms for the player to travel through.
	
	
	
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 */
	public Dungeon()
	{
		
		rooms = new Room[10][5];
		
		populateDungeon( ); // Fill the dungeon with monsters and a weapon
		
		playerXCoordinate = 0;
	}
	
	
	/**
	 * Test Constructor. This can be removed before final submission <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @param b
	 */
	public Dungeon(boolean b)
	{
		rooms = new Room[5][10];
		
		populateFreeDungeon( ); // Fill the dungeon with monsters and a weapon
		
		playerXCoordinate = 0;
		playerYCoordinate = 0;
	}
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @param player
	 */
	public Dungeon(Player player)
	{
		this();
		player = new Player(player);
	}
	
	/**
	 * @return playerXCoordinate
	 */
	public int getPlayerXCoordinate()
	{
		return playerXCoordinate;
	}
	
	public int getPlayerYCoordinate()
	{
		return playerYCoordinate;
	}
	
	/**
	 * @return size of the dungeon
	 */
	public int getDungeonSize()
	{
		return rooms.length;
	}

	/**
	 * Populates the dungeon with both monsters and a weapon. <br>        
	 *
	 * <hr>
	 * Date created: Mar 14, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 */
	public void populateDungeon()
	{
//		create the random number generator to be used for this method
		Random rand = new Random();
		
		rooms[0][0] = new Room();
//		for each room other than the starting room, randomly decide if there is a monster
		for (int x = 0; x < rooms.length; x++ )
		{
			
			for( int y = 0; y < rooms[x].length; y++)
			{	
				if(x == 0 && y == 0) // if x and y == 0 then a monster will not be placed into that room
				{
					
				}
				
				else
				{
					rooms[x][y] = new Room();
//					there is an approximately 50% chance for a monster to be there
					if (rand.nextBoolean( ))
					{	
						rooms[x][y].setMonster(new Monster());
					}
				}
			}

		}
		
//		Generate a random weapon to store in the dungeon
		Weapon weapon;
		if (rand.nextBoolean( ))
		{
			weapon = new Sword();
		}
		else
			weapon = new Stick();
		
//		put a weapon randomly in a cell other than the start cell
		int randomY = rand.nextInt(rooms.length);
		int randomX = rand.nextInt(rooms[randomY].length);
		while (randomX == 0 && randomY == 0)
		{
			randomY = rand.nextInt(rooms.length);
			randomX = rand.nextInt(rooms[randomY].length);
		}
		rooms[randomY][randomX].setWeapon(weapon);
		
	}
	
	
	/**
	 * Adds a door everywhere, to allow testing of the dungeon. This can be removed
	 * before final submission. <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 */
	public void populateFreeDungeon()
	{

//		create the random number generator to be used for this method
		Random rand = new Random();
		
		rooms[0][0] = new Room();
		
		int[] allDoors = {Room.NORTH_DOOR, Room.SOUTH_DOOR, Room.EAST_DOOR, Room.WEST_DOOR};
		rooms[0][0].setDoors(allDoors, true);
		
//		for each room other than the starting room, randomly decide if there is a monster
		for (int y = 0; y < rooms.length; y++ )
		{
			
			for( int x = 0; x < rooms[y].length; x++)
			{	
				if(x == 0 && y == 0) // if x and y == 0 then a monster will not be placed into that room
				{
					
				}
				
				else
				{
					rooms[y][x] = new Room();
					
					rooms[y][x].setDoors(allDoors, true);
					
//					there is an approximately 50% chance for a monster to be there
					if (rand.nextBoolean( ))
					{	
						rooms[y][x].setMonster(new Monster());
					}
				}
			}

		}
		
//		Generate a random weapon to store in the dungeon
		Weapon weapon;
		if (rand.nextBoolean( ))
		{
			weapon = new Sword();
		}
		else
			weapon = new Stick();
		
//		put a weapon randomly in a cell other than the start cell
		
		int randomY = rand.nextInt(rooms.length);
		int randomX = rand.nextInt(rooms[0].length);
		while (randomX == 0 && randomY == 0)
		{
			randomY = rand.nextInt(rooms.length);
			randomX = rand.nextInt(rooms[0].length);
		}
		rooms[randomY][randomX].setWeapon(weapon);
		
	}
	
	/**
	 * Causes the player to enter the dungeon <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 */
	public void enterDungeon(Player player)
	{
		playerXCoordinate = 0;
		playerYCoordinate = 0;
		rooms[playerXCoordinate][playerYCoordinate].setPlayer(player);
	}
	
	/**
	 * Allows the player to exit the dungeon <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 */
	public String exitDungeon()
	{
		playerXCoordinate = 0;
		playerYCoordinate = 0;
		return "Dungeon Exited! Congratulations. You won!.";
	}
	
	/**
	 * Moves the player. Uses the Command enum. <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @param command
	 */
	public String movePlayer(Command command) throws NoPathException
	{
		StringBuffer output = new StringBuffer("");

		//		pull the player from the room into a holder
		Player player = rooms[playerYCoordinate][playerXCoordinate].getPlayer( );
		rooms[playerYCoordinate][playerXCoordinate].setPlayer(null);

		//		if the player has reached the dungeons end, exit it. Otherwise, put him where he wants to be		
		if (rooms[playerYCoordinate][playerXCoordinate].isExitRoom( ) && command == Command.GO_EAST)
		{
			output.append(exitDungeon( ));
			
		}
		else
		{
			//		move the player according to the command
			if (command.equals(Command.GO_EAST))
			{
				if (rooms [playerYCoordinate] [playerXCoordinate]
								.isDoor(Room.EAST_DOOR))
				{
					playerXCoordinate++ ;
					output.append("You travel east.");
				}
				else
					throw new NoPathException("No East Door");
			}
			else if (command.equals(Command.GO_WEST))
				if (rooms [playerYCoordinate] [playerXCoordinate]
								.isDoor(Room.WEST_DOOR))
				{
					playerXCoordinate-- ;
					output.append("You travel west.");
				}
				else
					throw new NoPathException("No West Door");
			else if (command.equals(Command.GO_NORTH))
				if (rooms [playerYCoordinate] [playerXCoordinate]
								.isDoor(Room.NORTH_DOOR))
				{
					playerYCoordinate-- ;
					output.append("You travel north.");
				}
				else
					throw new NoPathException("No North Door");
			else if (command.equals(Command.GO_SOUTH))
				if (rooms [playerYCoordinate] [playerXCoordinate]
								.isDoor(Room.SOUTH_DOOR))
				{
					playerYCoordinate++ ;
					output.append("You travel south.");
				}
				else
					throw new NoPathException("No South Door");
			//		if the room has a weapon, pick it up if it is better
			if (rooms [playerYCoordinate] [playerXCoordinate].getWeapon( ) != null)
			{
				if (player.getWeapon( ).getDamage( ) > rooms [playerYCoordinate] [playerXCoordinate]
								.getWeapon( ).getDamage( ))
					player.setWeapon(rooms [playerYCoordinate] [playerXCoordinate]
									.getWeapon( ));
			}
			rooms [playerYCoordinate] [playerXCoordinate].setPlayer(player);
			//		if the room has a monster, have the player fight it		
			if (rooms [playerYCoordinate] [playerXCoordinate].getMonster( ) != null)

			{
				output.append("\n" + battle( ));
			}
		}


		return output.toString( );
	}

	/**
	 * Simulates a battle between the player and the monster in this room. <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @param roomIndex 
	 * @return whether or not the player is alive
	 */
	public String battle()
	{
		Monster monster = rooms[playerYCoordinate][playerXCoordinate].getMonster( );
		Player player = rooms[playerYCoordinate][playerXCoordinate].getPlayer( );
		StringBuffer output = new StringBuffer("You see a " + monster.getName( ) + ".\n");

		
//		while both the monster and the player are alive
		while(monster.getHealth( ) > 0 && player.getHealth( ) > 0)
		{
			output.append(player.getName( ) + " attacks!\n");
			int damage = player.attack( );
			output.append((damage > 0? "He hits for " + damage + "!": "He misses.") + "\n");
			monster.takeDamage(damage);
			output.append((damage > 0? monster.getName( ) + " has " + monster.getHealth( ) + " health left.": "") + "\n\n");
			
			if (monster.getHealth( ) > 0)
			{
				output.append(monster.getName( ) + " attacks!\n");
				damage = monster.attack();
				output.append((damage > 0? "It hits for " + damage + "!": "It misses.") + "\n");
				player.takeDamage(damage);
				output.append((damage > 0? player.getName( ) + " has " + player.getHealth( ) + " health left.": "") + "\n\n");
			}
			
		}
//		return whether the player is alive or not
		if (player.getHealth( ) < 1)
			output.append("The player died...");
		else
			output.append("The player won!");
		
		rooms[playerYCoordinate][playerXCoordinate].setPlayer(player);
		
		return output.toString( );
	}
	
	/**
	 * Returns a string representing the dungeon, suitable for display to the player <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public String getDungeonString()
	{
		StringBuffer output = new StringBuffer("");
		
//		for every room in the 2D array rooms
		for (Room[] col: rooms)
		{
			for (Room room: col)
			{
//				concatenate the room's display string
				output.append(room.getRoomString( ) + " ");
			}
//			at the end of every row, output a carriage return
			output.append("\n");
		}
		
		return output.toString( );
	}
	
	/**
	 * Returns the status of the player in a string, suitable for displaying to the user <br>        
	 *
	 * <hr>
	 * Date created: Mar 21, 2012 <br>
	 * Date last modified: Mar 21, 2012 <br>
	 *
	 * <hr>
	 * @return the status of the player
	 */
	public String getPlayerStatusString()
	{
		Player player = new Player(rooms[playerYCoordinate][playerXCoordinate].getPlayer( ));
		return player.getName( ) + "\tHealth: " + player.getHealth( ) + "\tWeapon: " + (player.getWeapon( ) != null? player.getWeapon( ).getName( ): "Nothing");
	}
	/**
	 * Returns a string representation suitable for testing. <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @return a String representing the dungeon
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer output = new StringBuffer("");
		
		Player player = rooms[playerYCoordinate][playerXCoordinate].getPlayer( );
		
		output.append("Player: " + player.toString( ) + "\tLocation: " + playerXCoordinate + "\n");
		for (Room[] row: rooms)
		{
			for (Room room: row)
			{
				output.append (room + "\n");
			}
			output.append ("\n" );
		}
		
		return output.toString( );
	}
	
	public boolean isPlayerAlive()
	{
		return rooms[playerYCoordinate][playerXCoordinate].getPlayer( ).isAlive( );
	}
}
