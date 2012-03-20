package weapons;
/**
 * ---------------------------------------------------------------------------
 * File name: Stick.java<br/>
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
public class Stick extends Weapon
{
	private static final String	DEFAULT_NAME	= "stick";
	private static final int	DEFAULT_DAMAGE	= 1;

	/**
	 * No-Args Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 */
	public Stick ()
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
	public Stick (String name, int damage)
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
	public Stick (Stick stick)
	{
		this(stick.getName( ), stick.getDamage( ));
	}
	
	/**
	 * Returns a copy of the weapon. <br>        
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
		return new Stick(this);
	}

	
	/**
	 * gets the damage modifier of the stick. <br>        
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
		return DEFAULT_DAMAGE;
	}
	
	/**
	 * sets the damage modifier of the stick. <br>        
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
