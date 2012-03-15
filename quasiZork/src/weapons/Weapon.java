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
	protected String name;		// The name of the weapon, to be displayed to the user.
	protected double damage;	// 
	
	
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

	public Weapon (String name, double damage)
	{
		this.name = name;
		this.damage = damage;
	}

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
	public abstract int getDamage();
	
}
