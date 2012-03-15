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
	public Sword (String name, double damage)
	{
		super (name, damage);
	}

	
	@Override
	public int damage_modifier ( )
	{
		return 3;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getDamage()
	{
		return this.damage;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDamage(double damage)
	{
		this.damage = damage;
	}

	
	

}
