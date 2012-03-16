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
	private static final String	DEFAULT_NAME	= "sword";
	private static final int	DEFAULT_DAMAGE	= 3;
	

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
		super (DEFAULT_NAME, DEFAULT_DAMAGE);
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
		super (name, damage);
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
	
	public Weapon copy()
	{
		return new Sword(this);
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
		return super.damage;
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
		this.damage = damage;
	}

	
	

}
