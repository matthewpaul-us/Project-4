package weapons;
/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java<br/>
 * Project name: 1260-088-PROJECT4-MiddaughStephen<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Stephen Middaugh, middaughs@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * Abstract class that represents an arbitrary weapon. This class must be
 * derived in order to use it.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */
public abstract class Weapon
{
	private static final String	DEFAULT_NAME	= "weapon";	// The default name
	private static final int	DEFAULT_DAMAGE	= 0;	// The default damage
	protected String name;		// The name of the weapon, to be displayed to the user.
	protected int damage;	// The damage modifier of the weapon.
	
	
	
	/**
	 * No-Args Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 */
	public Weapon()
	{
		this(DEFAULT_NAME, DEFAULT_DAMAGE);  // no arg constructor creates a weapon of default name and damage
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
	 * @param damage
	 */

	public Weapon (String name, int damage) // allows creation of weapon with name and damage as parameters
	{
		setName(name); // sets the name of the weapon
		setDamage(damage); // sets the damage of the weapon
	}
	
	/**
	 * Copy method for each weapon. Must be overridden. This method needs to use
	 * good deep copy measures. <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @return copy a copy of the weapon
	 */
	public abstract Weapon copy(); // abstract method copy().
	

	/**
	 * @return name
	 */
	public String getName()
	{
		return name; // returns the name of the weapon
	}


	/**
	 * @param name the name to set. The player will see this.
	 */
	public void setName(String name)
	{
		this.name = name; // sets the name
	}


	/**
	 * @param damage the damage to set
	 */
	public abstract void setDamage(int damage); // abstact method to set the damage


	/**
	 * Method that returns the additional damage this weapon does. Must be
	 * overridden. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @return The damage modifier
	 */
	public abstract int getDamage(); // abstract method to return the damage of a weapon
	
	public String toString() // returns a string of the damage and name of the weapon
	{
		return "+" + getDamage() + " " + getName();
	}
}
