package weapons;
/**
 * ---------------------------------------------------------------------------
 * File name: Sword.java<br/>
 * Project name: 1260-088-PROJECT4-MiddaughStephen<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Stephen Middaugh, middaughs@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */
public class Sword extends Weapon
{
	private static final String	DEFAULT_NAME	= "sword"; // default name of a sword
	private static final int	DEFAULT_DAMAGE	= 3; // default damage of a sword
	

	/**
	 * No-Args Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 */
	public Sword ()
	{
		super (DEFAULT_NAME, DEFAULT_DAMAGE); // create a sword with default characteristics
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
	public Sword (String name, int damage)
	{
		super (name, damage); // create a sword with custom characteristics
	}
	
	/**
	 * Copy Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 */
	public Sword (Sword sword)
	{
		this(sword.getName( ), sword.getDamage( )); 
	}
	
	/**
	 * Copy method that returns a sword object <br>        
	 *
	 * <hr>
	 * Date created: Mar 20, 2012 <br>
	 * Date last modified: Mar 20, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see weapons.Weapon#copy()
	 */
	public Weapon copy()
	{
		return new Sword(this); // creates a deep copy of a sword
	}

	
	/**
	 * gets the damage modifier of the sword. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see Weapon#getDamage()
	 */
	@Override
	public int getDamage ( )
	{
		return super.damage; // returns the damage of a sword
	}
	
	/**
	 * sets the damage modifier of the sword. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @param damage
	 */
	@Override
	public void setDamage(int damage)
	{
		this.damage = damage; // sets the damage of a sword
	}

	
	

}
