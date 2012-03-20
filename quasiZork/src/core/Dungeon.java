package core;


import java.util.Random;
import weapons.Stick;
import weapons.Sword;
import weapons.Weapon;
import monsters.Monster;

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
	private Player player;
	
	
	
	
	
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
		
		player = new Player();
		playerXCoordinate = 0;
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
		
		int randomX = rand.nextInt(10);
		int randomY = rand.nextInt(5);
		if(randomX == 0 && randomY == 0)
		{
			randomX = rand.nextInt(9) + 1;
			randomY = rand.nextInt(5);
		}
		rooms[randomX][randomY].setWeapon(weapon);
		
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
	public void enterDungeon()
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
	public void exitDungeon()
	{
		playerXCoordinate = 0;
		System.out.println("Dungeon Exited! GAME OVER.");
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
	public void movePlayer(Command command)
	{
//		pull the player from the room into a holder
		Player holder = rooms[playerXCoordinate][playerYCoordinate].getPlayer( );
		rooms[playerXCoordinate][playerYCoordinate].setPlayer(null);


		
//		move the player according to the command
		if (command.equals(Command.GO_EAST))
			playerXCoordinate++;
		else if (command.equals(Command.GO_WEST))
			playerXCoordinate--;
		else if(command.equals(Command.GO_NORTH))
			playerYCoordinate--;
		else if(command.equals (Command.GO_SOUTH))
			playerYCoordinate++;
		
//		if the player has reached the dungeons end, exit it. Otherwise, put him where he wants to be		
		if (playerXCoordinate == rooms.length)

			exitDungeon( );
		else
			rooms[playerXCoordinate][playerYCoordinate].setPlayer(holder);
		
		
//		if the room has a monster, have the player fight it		
		if (rooms[playerXCoordinate][playerYCoordinate].getMonster( ) != null)

		{
			
			System.out.println(battle(playerXCoordinate, playerYCoordinate));
		}
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
	public boolean battle(int roomXIndex, int roomYIndex)
	{
		Monster monster = rooms[roomXIndex][roomYIndex].getMonster( );

		
//		while both the monster and the player are alive
		while(monster.getHealth( ) > 0 && player.getHealth( ) > 0)
		{
			int damage = player.attack( );
			monster.takeDamage(damage);
			
			if (monster.getHealth( ) > 0)
			{
				damage = monster.attack();
				player.takeDamage(damage);
			}
			
		}
//		return whether the player is alive or not
		if (player.getHealth( ) > 0)
			return true;
		else
			return false;
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
		
		output.append("Player: " + player.toString( ) + "\tLocation: " + playerXCoordinate + "\n");
		for (Room room: rooms)
		{
			output.append(room + "\n");
		}
		
		return output.toString( );
	}
}
