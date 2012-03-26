/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java<br/>
 * Project name: 1260-088-Project4-PaulMatthew<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 26, 2012
 * ---------------------------------------------------------------------------
 */
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
	private int playerXCoordinate;	// The players x location in the dungeon.
	private int playerYCoordinate;	// The players y location in the dungeon.
	private Room[][] rooms;	// The collection of rooms for the player to travel through.
	
	
	
	
	
	/**
	 * No-Args Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 */
	public Dungeon()
	{
//		Create an array of rooms with the default parameters
		rooms = new Room[5][10];
		
//		create a room at the origin
		rooms[0][0] = new Room();
		
//		build a random dungeon with no bias towards the right.
		buildRandomDungeon(0, 0, 0);
		
//		populate the dungeon with monsters and a weapon
		populateDungeon( );
		
//		find the first room on the last row. This is the exit room
		for (int y = 0; y < rooms.length; y++)
		{
			if (rooms[y][rooms[y].length - 1] != null)
			{
				rooms[y][rooms[y].length - 1].setExitRoom(true);
			}
		}
		
//		set the player coordinates to 0, 0
		playerXCoordinate = 0;
		playerYCoordinate = 0;
	}
	
	
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 * @param ySize the width of the dungeon space
	 * @param xSize the length of the dungeon space
	 * @param rightStrength the amount of bias towards the right
	 */
	public Dungeon(int ySize, int xSize, double rightStrength)
	{
//		create an array of rooms ySize by xSize
		rooms = new Room[ySize][xSize];
		
//		add a room at the origin
		rooms[0][0] = new Room();
//		call the recursive method buildRandomDungeon
		buildRandomDungeon(0, 0, rightStrength);
//		populate the dungeon with monsters and a weapon
		populateDungeon( );
		
//		set the exit room of the dungeon to the rightmost cell
		for (int y = 0; y < rooms.length; y++)
		{
			if (rooms[y][rooms[y].length - 1] != null)
			{
				rooms[y][rooms[y].length - 1].setExitRoom(true);
			}
		}
		
//		place the coordinates at the origin
		playerXCoordinate = 0;
		playerYCoordinate = 0;
	}
	
	/**
	 * @return playerXCoordinate
	 */
	public int getPlayerXCoordinate()
	{
		return playerXCoordinate;
	}
	
	/**
	 * @return playerYCoordinate
	 */
	public int getPlayerYCoordinate()
	{
		return playerYCoordinate;
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
		
//		for each room other than the starting room, randomly decide if there is a monster
		for (int y = 0; y < rooms.length; y++ )
		{
			
			for( int x = 0; x < rooms[y].length; x++)
			{	
				if(x != 0 && y != 0 && rooms[y][x] != null) // if x and y == 0 then a monster will not be placed into that room
				{

//					there is an approximately 50% chance for a monster to be there
					if (rand.nextBoolean( ))
					{
						rooms [y] [x].setMonster(new Monster( ));
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
		{
			weapon = new Stick();
		}
		
//		put a weapon randomly in a cell other than the start cell
//		get a random x and y value that is a valid coordinate for the dungeon
		int randomY = rand.nextInt(rooms.length);
		int randomX = rand.nextInt(rooms[randomY].length);
//		While the room picked is at the origin or not a room, pick another random coordinate
		while ((randomX == 0 && randomY == 0) || rooms[randomY][randomX] == null)
		{
			randomY = rand.nextInt(rooms.length);
			randomX = rand.nextInt(rooms[randomY].length);
		}
//		set the generated weapon inside the randomly determined room
		rooms[randomY][randomX].setWeapon(weapon);
		
	}
		
	/**
	 * Generates a dungeon based on a direction algorithm. This algorithm takes a double that determines
	 * how aggressively it should travel towards the end of the map. A rightStrength of 1.0 will cause
	 * the algorithm to go always towards the end. A strength of 0 will cause the algorithm to give no
	 * weight to the east direction. A negative number will cause the algorithm to avoid going right.
	 * A higher number will cause the dungeon to be small, and a lower number will cause a dungeon to be
	 * big, on average. <br>        
	 *
	 * <hr>
	 * Date created: Mar 24, 2012 <br>
	 * Date last modified: Mar 24, 2012 <br>
	 *
	 * <hr>
	 * @param xLoc The x coordinate of the cell to be looked at
	 * @param yLoc The y coordinate of the cell to be looked at
	 * @param rightStrength The strength of the algorithm's need to travel right.
	 */
	public void buildRandomDungeon(int xLoc, int yLoc, double rightStrength)
	{
//		assume all directions are all equally valid
		double upProb = 1,
			   rightProb = 1,
			   leftProb = 1,
			   downProb = 1;
		
		Random rand = new Random();
		
//		If the room in focus is not the last room on the right (base case)
		if (xLoc < rooms[yLoc].length - 1)
		{
// 			Determine probabilities
//			if it is an edge cell, set the appropriate direction to a 0 % chance to be selected
			if (yLoc < 1)
			{
				upProb = 0;
			}
			if (xLoc < 1)
			{
				leftProb = 0;
			}
			if (yLoc > rooms.length - 2)
			{
				downProb = 0;
			}
			if (xLoc > rooms [yLoc].length - 2)
			{
				rightProb = 0;
			}
			
//			if there is a room in the way
			if (yLoc > 0 && rooms [yLoc - 1] [xLoc] != null)
			{
				upProb = 0;
			}
			if (yLoc < rooms.length - 2 && rooms [yLoc + 1] [xLoc] != null)
			{
				downProb = 0;
			}
			if (xLoc > 0 && rooms [yLoc] [xLoc - 1] != null)
			{
				leftProb = 0;
			}
			if (xLoc < rooms [yLoc].length - 2 && rooms [yLoc] [xLoc + 1] != null)
			{
				rightProb = 0;
			}
			
//			calculate how many directions are still valid and the probability if they were equally likely
			
//			Adding up the probabilities that are left will give you the number of valid options
			double numOfChoices = (upProb + downProb + leftProb + rightProb);
			
//			Find the probability that each choice can have
			double standardProb = 1.0 / numOfChoices;
			
//			If the right is a valid option, weight it according to the rightStrength
			if (rightProb > 0.01)
			{
				rightProb = standardProb * (1 + rightStrength);
			}
			
//			Give whatever is left to the other options
			double leftoverProb = (1 - rightProb) / (numOfChoices - 1);
			if (upProb > 0.01)
			{
				upProb = leftoverProb;
			}
			if (downProb > 0.01)
			{
				downProb = leftoverProb;
			}
			if (leftProb > 0.01)
			{
				leftProb = leftoverProb;
			}
			
			int direction; // 0 = right, 1 = left, 2 = up, 3 = down
			
			//randomly pick a direction based on probabilities
			double randomDouble = rand.nextDouble( );
			if (randomDouble < leftProb)
			{
				direction = 1;
			}
			else if (randomDouble < upProb + leftProb)
			{
				direction = 2;
			}
			else if (randomDouble < downProb + upProb + leftProb)
			{
				direction = 3;
			}
			else
			{
				direction = 0;
			}
			// add room in the direction indicated and recursively call buildRandomDungeon()
			switch (direction)
			{
				case 0:
					rooms [yLoc] [xLoc + 1] = new Room( );
					buildRandomDungeon(xLoc + 1, yLoc, rightStrength);
					break;
				case 1:
					rooms [yLoc] [xLoc - 1] = new Room( );
					buildRandomDungeon(xLoc - 1, yLoc, rightStrength);
					break;
				case 2:
					rooms [yLoc - 1] [xLoc] = new Room( );
					buildRandomDungeon(xLoc, yLoc - 1, rightStrength);
					break;
				case 3:
					rooms [yLoc + 1] [xLoc] = new Room( );
					buildRandomDungeon(xLoc, yLoc + 1, rightStrength);
				default:
					break;
			}
			
//			this occurs after the recursion finishes
			
// 			connect with doors; one in the direction indicated, one in the opposite room going the other direction.
//			This connects allows the doors to be two way
			
//			put a door in the north wall if there's a room above
			if (yLoc > 0 && rooms [yLoc - 1] [xLoc] != null)
			{
				int [ ] doorArray = { Room.NORTH_DOOR };
				rooms [yLoc] [xLoc].setDoors(doorArray, true);

				doorArray [0] = Room.SOUTH_DOOR;
				rooms [yLoc - 1] [xLoc].setDoors(doorArray, true);
			}
			
//			put a door in the south wall if there's a room below
			if (yLoc < rooms.length - 1 && rooms [yLoc + 1] [xLoc] != null)
			{
				int [ ] doorArray = { Room.SOUTH_DOOR };
				rooms [yLoc] [xLoc].setDoors(doorArray, true);

				doorArray [0] = Room.NORTH_DOOR;
				rooms [yLoc + 1] [xLoc].setDoors(doorArray, true);
			}
			
//			put a door in the west wall if there's a room to the left
			if (xLoc > 0 && rooms [yLoc] [xLoc - 1] != null)
			{
				int [ ] doorArray = { Room.WEST_DOOR };
				rooms [yLoc] [xLoc].setDoors(doorArray, true);

				doorArray [0] = Room.EAST_DOOR;
				rooms [yLoc] [xLoc - 1].setDoors(doorArray, true);
			}
			
//			put a door in the east wall if there's a room to the right
			if (xLoc < rooms [yLoc].length - 1 && rooms [yLoc] [xLoc + 1] != null)
			{
				int [ ] doorArray = { Room.EAST_DOOR };
				rooms [yLoc] [xLoc].setDoors(doorArray, true);

				doorArray [0] = Room.WEST_DOOR;
				rooms [yLoc] [xLoc + 1].setDoors(doorArray, true);
			}
		}
		
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
//		set the player coordinates to 0 and stick player in that room
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
//		set the player coordinates to the sentinal coordinate (-1,-1)
		playerXCoordinate = -1;
		playerYCoordinate = -1;
		
//		return a string with the win message
		return "Dungeon Exited! Congratulations. You won!";
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
//			move the player according to the command. If there is no door, then throw a noPathException
			if (command.equals(Command.GO_EAST))
			{
				if (rooms [playerYCoordinate][playerXCoordinate].isDoor(Room.EAST_DOOR))
				{
					output.append(player.getName() + " travels east.\n");
					playerXCoordinate++;
				}
				else
				{
					rooms[playerYCoordinate][playerXCoordinate].setPlayer(player);
					throw new NoPathException("No East Door");
				}
					
			}
			else if (command.equals(Command.GO_WEST))
				if (rooms [playerYCoordinate] [playerXCoordinate]
								.isDoor(Room.WEST_DOOR))
				{
					output.append(player.getName() + " travels west.\n");
					playerXCoordinate--;
				}
				else
				{
					rooms[playerYCoordinate][playerXCoordinate].setPlayer(player);
					throw new NoPathException("No West Door");
				}
					

			else if (command.equals(Command.GO_NORTH))
				if (rooms [playerYCoordinate] [playerXCoordinate]
								.isDoor(Room.NORTH_DOOR))
				{
					output.append(player.getName() + " travels north.\n");
					playerYCoordinate--;
				}
				else
				{
					rooms[playerYCoordinate][playerXCoordinate].setPlayer(player);
					throw new NoPathException("No North Door");
				}
					

			else if (command.equals(Command.GO_SOUTH))
				if (rooms [playerYCoordinate][playerXCoordinate].isDoor(Room.SOUTH_DOOR))
				{
					output.append(player.getName() + " travels south.\n");
					playerYCoordinate++;
				}
				else
				{
					rooms[playerYCoordinate][playerXCoordinate].setPlayer(player);
					throw new NoPathException("No South Door");
				}
			
	
			
//			if the room has a weapon, pick it up if it is better
			if (rooms [playerYCoordinate] [playerXCoordinate].getWeapon( ) != null)
			{
				if ((player.getWeapon( ) != null? player.getWeapon( ).getDamage( ): 0) < 
								rooms[playerYCoordinate][playerXCoordinate].getWeapon( ).getDamage( ))
				{
//					give the player the weapon
					player.setWeapon(rooms [playerYCoordinate][playerXCoordinate].getWeapon( ));
//					send the message that the player got the weapon to the output queue
					output.append(player.getName( ) + " picks up a " + player.getWeapon( ).getName( ));
					
//					set the room's weapon where the player picked it up to null
					rooms[playerYCoordinate][playerXCoordinate].setWeapon(null);
				}
			}
			
//			put the player in the new room
			rooms [playerYCoordinate] [playerXCoordinate].setPlayer(player);

			//		if the room has a monster, have the player fight it		
			if (rooms [playerYCoordinate] [playerXCoordinate].getMonster( ) != null)

			{
				output.append("\n" + battle( ));
			}
		}


//		return the output queue
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
		StringBuffer output = new StringBuffer("You see a " + monster.getName( ) +
			(monster.getHealth( ) < 1? ", but it is already dead": "") + ".\n");
		
		boolean alreadyDead = monster.getHealth( ) < 1;

		
//		while both the monster and the player are alive
		while(monster.getHealth( ) > 0 && player.isAlive( ))
		{
//			send message to queue
			output.append(player.getName( ) + " attacks!\n");
//			get damage player does
			int damage = player.attack( );
//			output damage if hit, or miss if not
			output.append((damage > 0? "He hits for " + damage + "!": "He misses.") + "\n");
//			apply damage to monster
			monster.takeDamage(damage);
//			output the health of the monster
			output.append((damage > 0? monster.getName( ) + " has " + monster.getHealth( ) + " health left.": "") + "\n\n");
			
//			if the monster is not dead, let it attack
			if (monster.getHealth( ) > 0)
			{
//				output the monster attack message
				output.append(monster.getName( ) + " attacks!\n");
//				get the monster's damage
				damage = monster.attack();
//				output the damage if any
				output.append((damage > 0? "It hits for " + damage + "!": "It misses.") + "\n");
//				apply the damage to the player
				player.takeDamage(damage);
//				output the player's remaining health
				output.append((damage > 0? player.getName( ) + " has " + player.getHealth( ) + " health left.": "") + "\n\n");
//				if player has died, setAlive to false
				if (player.getHealth( ) < 1)
					player.setAlive(false);
			}

		}
//		if the monster wasn't already at the beginning of the battle
		if (!alreadyDead)
		{
			//		return whether the player is alive or not
			if (player.getHealth( ) < 1)
			{
				output.append("The player died...");
			}
			else
			{
				output.append("The player won!");
			}
		}
//		update the player health 
		rooms[playerYCoordinate][playerXCoordinate].setPlayer(player);
		
//		return the output queue
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
//		create output queue
		StringBuffer output = new StringBuffer("");
		
//		for every room in the 2D array rooms
		for (Room[] col: rooms)
		{
			for (Room room: col)
			{
				if (room != null)
				{
//					concatenate the room's display string
					output.append(room.getRoomString( ) + " ");
				}
				else
				{
//					add a space where the room would have been
					output.append("            ");
				}
			}
//			at the end of every row, output a carriage return
			output.append("\n");
		}
		
//		return the output queue
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
//		if the player is alive, build the status string. Otherwise, return nothing
		if (isPlayerAlive( ))
		{
			Player player = new Player(rooms[playerYCoordinate][playerXCoordinate].getPlayer( ));
//			return the player's health and his weapon
			return player.getName( ) + "\tHealth: " + player.getHealth( ) + "\tWeapon: " + (player.getWeapon( ) != null? player.getWeapon( ).getName( ): "Nothing");
		}
		else
			return null;
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
//		create an output queue
		StringBuffer output = new StringBuffer("");
		
		Player player = rooms[playerYCoordinate][playerXCoordinate].getPlayer( );
//		output the player to string and the location
		output.append("Player: " + player.toString( ) + "\tLocation: " + playerXCoordinate + "\n");
//		for each room, append the room toString()
		for (Room[] row: rooms)
		{
			for (Room room: row)
			{
				output.append (room + "\n");
			}
			output.append ("\n" );
		}
		
//		return the output queue
		return output.toString( );
	}
	
	/**
	 * Determines whether the player is alive or not. <br>        
	 *
	 * <hr>
	 * Date created: Mar 26, 2012 <br>
	 * Date last modified: Mar 26, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public boolean isPlayerAlive()
	{
//		if the player has won the game, set the player to dead
		if (playerXCoordinate == -1 && playerYCoordinate == -1)
			return false;
//		otherwise, return whether he is dead or not
		else
			return rooms[playerYCoordinate][playerXCoordinate].getPlayer( ).isAlive( );
	}
}
