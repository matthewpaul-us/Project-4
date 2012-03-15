/**
 * ---------------------------------------------------------------------------
 * File name: Player.java<br/>
 * Project name: 1260-088-PROJECT4-MiddaughStephen<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Stephen Middaugh, middaughs@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */
package core;

import java.util.Random;
import weapons.Weapon;
/**
 * Represents a player class in a Zork-like dungeon crawler.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */
public class Player
{
	
	private String name;					// The name the player wishes to be called
	private double health;					// The health of the player. If this reaches 0, the player is dead
	private Weapon weapon;
	
	private final double HIT_CHANCE = 90;	// The chance for the player to hit. 10 = a 10% chance to hit an enemy.
	private final int DEFAULT_DAMAGE = 5;
	private static final String	DEFAULT_NAME	= "player 1";
	private static final double	DEFAULT_HEALTH	= 100;
	
	/**
	 * No-Args Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 14, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 */
	public Player()
	{
		this(DEFAULT_NAME, DEFAULT_HEALTH, null);
	}
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param name
	 * @param health
	 */
	public Player (String name, double health)
	{
		this(name, health, null);
	}
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @param name
	 * @param health
	 * @param weapon
	 */
	public Player(String name, double health, Weapon weapon)
	{
		setName(name);
		setHealth(health);
		setWeapon(weapon);
	}
	/**
	 * Copy Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param name
	 * @param health
	 */
	public Player (Player player)
	{
		this(player.getName( ), player.getHealth( ), player.getWeapon( ));
	}
	

	/**
	 * Calculates the damage, if any, that an attack from the player will do. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @return the damage, if any, done by the player
	 */
	public int attack()
	{
		Random rand = new Random();
		
		int attackRoll = rand.nextInt(100) + 1;
		
		if(attackRoll <= HIT_CHANCE)
		{
			return DEFAULT_DAMAGE + (weapon != null? weapon.getDamage( ): 0);
		}
		
		else
		{
			return 0;
		}
	}
	
	/**
	 * Subract the appropriate damage from the player's health. <br>        
	 *
	 * <hr>
	 * Date created: Mar 14, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @param damage
	 */
	public void takeDamage(int damage)
	{
		setHealth(getHealth() - damage);
	}

	/**
	 * @return name
	 */
	public String getName ( )
	{
		return name;
	}

	/**
	 * @return health
	 */
	public double getHealth ( )
	{
		return health;
	}

	/**
	 * @param name the name to set
	 */
	public void setName (String name)
	{
		this.name = name;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth (double health)
	{
		this.health = health;
	}
	
	/**
	 * @return weapon
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}

	/**
	 * @param weapon the weapon to set
	 */
	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}

	/**
	 * Returns a string representing a player. Not currently suitable for displaying to the end-user.
	 * To be used for testing the classes. <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		
		return "Player " + getName() + " has " + getHealth() + " health and is using " + (weapon != null? "a " + weapon.getName(): "nothing") + ".\n" +
			   "     His base damage is " + DEFAULT_DAMAGE + ". With " + (weapon != null? "a " + weapon.getName(): "nothing") + ", he does " + 
						(DEFAULT_DAMAGE + (weapon != null? weapon.getDamage( ): 0)) + " damage." ;
	}
	
}
