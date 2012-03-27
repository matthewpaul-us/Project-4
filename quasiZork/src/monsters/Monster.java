package monsters;
import java.util.Random;

/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java<br/>
 * Project name: 1260-088-Project4-PaulMatthew<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * Represents a monster in a Zork Dungeon Crawler.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class Monster
{
	private static final int	DEFAULT_HEALTH	= 20;  // default health of a monster
	private static final String	DEFAULT_NAME	= "monster";  // default name of a monster
	private static final int	DEFAULT_DAMAGE	= 4;  // default damage of a monster
	
	private int health;  // holds health of a monster
	private final int HIT_CHANCE = 80; // hit chance of monsters
	
	private String name;  // holds name of a monster
	private int damage;  // holds damage of a monster
	
	
	
	/**
	 * No-Args Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 */
	public Monster()
	{
		this(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE); // creates a monster witih default name, health, and damage
	}
	
	/**
	 * Copy Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @param name
	 * @param health
	 * @param damage
	 */
	public Monster(String name, int health, int damage)
	{
		setHealth(health); // sets health of monster
		setName(name); // sets the name of monster
		setDamage(damage); // sets the damage of monster
	}
	
	public Monster(Monster monster)
	{
		this(monster.getName( ), monster.getHealth( ), monster.getDamage( ));
	}

	/**
	 * @return health
	 */
	public int getHealth()
	{
		return health; // returns the health of a monster
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health)
	{
		this.health = health; // sets the health of a monster
	}

	/**
	 * @return name
	 */
	public String getName()
	{
		return name; // returns the name of a monster
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name; // sets the name of a monster
	}

	/**
	 * @return damage
	 */
	public int getDamage()
	{
		return damage;  // returns the damage done by a monster
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage)
	{
		this.damage = damage; // sets the damage done by a monster
	}

	/**
	 * Calculate the damage that the monster does.<br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @return the damage done by the monster, if any
	 */
	public int attack()
	{
		Random rand = new Random();  // object of the Random class named rand
		
		int attackRoll = rand.nextInt(100) + 1;  // attackRoll is a random number between 1 and 100
		
		if (attackRoll < HIT_CHANCE + 1) // if attackroll is less than 80 
		{
			return damage;  // return damage
		}
		else
			return 0; // if it is a miss, return zero
	}
	
	/**
	 * Applies the damage input to the monsters health. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param damage
	 */
	public void takeDamage(int damage)
	{
		setHealth(getHealth() - damage);  // subtracts the damage from the health of the monster
	}
	
	public String toString()
	{
		return getName() + " with " + getHealth() + " hp";  // "monster with 100 hp"
	}

}
