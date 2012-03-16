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
	private static final int	DEFAULT_HEALTH	= 20;
	private static final String	DEFAULT_NAME	= "monster";
	private static final int	DEFAULT_DAMAGE	= 4;
	
	private int health;
	private final int HIT_CHANCE = 80;
	
	private String name;
	private int damage;
	
	
	
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
		this(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE);
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
		setHealth(health);
		setName(name);
		setDamage(damage);
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
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}

	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return damage
	 */
	public int getDamage()
	{
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage)
	{
		this.damage = damage;
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
		Random rand = new Random();
		
		int attackRoll = rand.nextInt(100) + 1;
		
		if (attackRoll < HIT_CHANCE + 1)
		{
			return damage;
		}
		else
			return 0;
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
		setHealth(getHealth() - damage);
	}
	
	public String toString()
	{
		return getName() + " with " + getHealth() + " hp";
	}

}
