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

/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */
import java.util.Random;
public class Player
{
	private String name;
	private double health = 100;
	private final double HIT_CHANCE = 90;
	
	public Player()
	{
		this.name = "player 1";
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
	 * @param hitChance
	 */
	public Player (String name, double health)
	{
		super ( );
		this.name = name;
		this.health = health;
	}
	
	public int attack()
	{
		Random rand = new Random();
		
		int attackRoll = rand.nextInt(100) + 1;
		
		if(attackRoll <= HIT_CHANCE)
		{
			return 5;
		}
		
		else
		{
			return 0;
		}
	}
	
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
	
}
