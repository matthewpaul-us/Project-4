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
	private static final double	DEFAULT_DAMAGE	= 0;	// The default damage
	protected String name;		// The name of the weapon, to be displayed to the user.
	protected double damage;	// The damage modifier of the weapon.
	
	
	
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
		this(DEFAULT_NAME, DEFAULT_DAMAGE);
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

	public Weapon (String name, double damage)
	{
		setName(name);
		setDamage(damage);
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
	public abstract Weapon copy();
	

	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}


	/**
	 * @param name the name to set. The player will see this.
	 */
	public void setName(String name)
	{
		this.name = name;
	}


	/**
	 * @param damage the damage to set
	 */
	public abstract void setDamage(double damage);


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
