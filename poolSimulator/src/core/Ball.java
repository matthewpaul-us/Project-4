/**
 * ---------------------------------------------------------------------------
 * File name: Ball.java<br/>
 * Project name: poolSimulator<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 26, 2012<br/>
 * Date of Last Modification: Mar 26, 2012
 * ---------------------------------------------------------------------------
 */

package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import front.Render;


/**
 * Represents a pool ball<br>
 *
 * <hr>
 * Date created: Mar 26, 2012<br>
 * Date last modified: Mar 26, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class Ball
{
	private static final double	DEFAULT_X	= 0;

	private static final double	DEFAULT_Y	= 0;

	private double locX,
		   		   locY,
		   		   velX,
		   		   velY;
	
	private Color ballColor;
	
	private BallNumber ballNumber;
	
	private boolean pocketed;
	
	public final double BALL_MASS = 0.163;		// The radius of the ball, in meters

	public static final double	BALL_RADIUS = 0.05715;

	private static final double	TRIANGLE_MULTIPLYER	= 0.707107; 	// multiplier to determine equal sides of a triangle, based on hypoteneuse. Uses h = sqrt(2a^2)
	
	private BufferedImage ballImage = null;
	
	/**
	 * @return locX
	 */
	public double getLocX()
	{
		return locX;
	}

	/**
	 * @param locX the locX to set
	 */
	public void setLocX(double locX)
	{
		this.locX = locX;
	}

	/**
	 * @return locY
	 */
	public double getLocY()
	{
		return locY;
	}

	/**
	 * @param locY the locY to set
	 */
	public void setLocY(double locY)
	{
		this.locY = locY;
	}

	/**
	 * @return velX
	 */
	public double getVelX()
	{
		return velX;
	}

	/**
	 * @param velX the velX to set
	 */
	public void setVelX(double velX)
	{
		this.velX = velX;
	}

	/**
	 * @return velY
	 */
	public double getVelY()
	{
		return velY;
	}

	/**
	 * @param velY the velY to set
	 */
	public void setVelY(double velY)
	{
		this.velY = velY;
	}

	/**
	 * @return ballColor
	 */
	public Color getBallColor()
	{
		return ballColor;
	}

	/**
	 * @param ballColor the ballColor to set
	 */
	public void setBallColor(Color ballColor)
	{
		this.ballColor = ballColor;
	}

	/**
	 * @return ballNumber
	 */
	public BallNumber getBallNumber()
	{
		return ballNumber;
	}

	/**
	 * @param ballNumber the ballNumber to set
	 */
	public void setBallNumber(BallNumber ballNumber)
	{
		this.ballNumber = ballNumber;
	}

	/**
	 * @return isPocketed
	 */
	public boolean isPocketed()
	{
		return pocketed;
	}

	/**
	 * @param isPocketed the isPocketed to set
	 */
	public void setPocketed(boolean isPocketed)
	{
		this.pocketed = isPocketed;
	}

	/**
	 * @return bALL_MASS
	 */
	public double getBALL_MASS()
	{
		return BALL_MASS;
	}

	/**
	 * @return bALL_RADIUS
	 */
	public double getBALL_RADIUS()
	{
		return BALL_RADIUS;
	}

	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 */
	public Ball()
	{
		initializeDefaultValues();
	}
	
	public Ball(int locX, int locY)
	{
		initializeDefaultValues( );
		
		setLocX(locX);
		setLocY(locY);
	}

	/**
	 * Initializes the ball with default values <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 */
	private void initializeDefaultValues()
	{
		setLocX(DEFAULT_X);
		setLocY(DEFAULT_Y);
		
		setVelX(0);
		setVelY(0);
		
		setBallColor(Color.gray);
		
		setBallNumber(BallNumber.EIGHT);
		
		setPocketed(false);
		
		loadImage();
	}
	
	
	private void loadImage()
	{
		try
		{
			ballImage = ImageIO.read(new File("resources/ballSmall.gif"));
			
		}
		catch (IOException e)
		{
			System.out.println("Error! Ball image file load failed! " + e.getMessage( ));
		}
	}

	/**
	 * Copy Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param copy
	 */
	public Ball(Ball copy)
	{
		setLocX(copy.getLocX( ));
		setLocY(copy.getLocY( ));
		
		setVelX(copy.getVelX( ));
		setVelY(copy.getVelY( ));
		
		setBallColor(copy.getBallColor( ));
		
		setBallNumber(copy.getBallNumber( ));
		
		setPocketed(copy.isPocketed( ));
	}
	
	/**
	 * Moves the ball according to how much time has passed <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param deltaTime
	 */
	public void moveBall(long deltaTime)
	{
		// calculate velocity
		double dX = getVelX( ) * deltaTime / 1000 * 292,	// multiplying by 292 to convert meters to pixels. 
			   dY = getVelY( ) * deltaTime / 1000 * 292;	// Based on size of 1.37 m for width of table.
		
		if (Math.abs(getVelX()) < 1e-4)
			dX = 0;
		
		if (Math.abs(getVelY()) < 1e-4)
			dY = 0;
		
		
		// apply friction
		applyFriction(deltaTime);
		
		// apply velocity to ball
		setLocX(getLocX( ) + dX);
		setLocY(getLocY( ) + dY);
	}

	/**
	 * Applies the correct amount of friction based on time elapsed <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param deltaTime
	 */
	private void applyFriction(long deltaTime)
	{
		if (Math.abs(getVelX( )) > 1e-4 || Math.abs(getVelY( )) > 1e-4)
		{
			double coefficient = 0.01, gravity = 9.8;
			double frictionForce = 0.0;

			frictionForce = coefficient * gravity * deltaTime / 1000;

			double velocityAngle = Math.atan(getVelY( ) / getVelX( ));
			double frictionAngle = - velocityAngle;
			
			double frictionAcceleration = frictionForce / BALL_MASS;
			double VelocityMagnitude = Math.sqrt(Math.pow(getVelX( ), 2) +
							Math.pow(getVelY( ), 2));
			
//			double signBefore = Math.signum(VelocityMagnitude);
//			
//			VelocityMagnitude -= frictionAcceleration;
//			
//			double signAfter = Math.signum(VelocityMagnitude);
//			
//			if (signBefore != signAfter)
//				VelocityMagnitude = 0;
			
			setVelX(Math.signum(getVelX()) * VelocityMagnitude * Math.sin(velocityAngle) - frictionAcceleration * Math.sin(frictionAngle));
			setVelY(Math.signum(getVelY()) * VelocityMagnitude * Math.cos(velocityAngle) - frictionAcceleration * Math.cos(frictionAngle));
		}
		else
		{
//			do nothing
		}
	}
	
	/**
	 * Collides with a second ball. <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param ball
	 */
	public void collide(Ball ball)
	{
//		int angleToBall = (int)getAngle(getLocX( ), getLocY( ), ball.getLocX( ), ball.getLocY( ));
//		System.out.println("Angle between Balls: " + angleToBall);
//		
//		if (angleToBall == 0 || angleToBall == 180)
//		{
//			ball.setVelY(getVelY());
//			
//			setVelY(0);
//		}
//		else if (angleToBall == 90 || angleToBall == 270)
//		{
//			ball.setVelX(getVelX());
//			
//			setVelX(0);
//		}
//		else
//		{
//			double ball2VelX = (2 * getVelX( ) * (Math.cos(540 - angleToBall) - Math.cos(450 - angleToBall)) / Math.cos(2 * (540 - angleToBall)) + Math.cos(2 * (450 - angleToBall)) + 2); 
//			ball.setVelX(ball2VelX);
//			
//			double ball1VelX = (getVelX() - ball.getVelX( ) * Math.cos(450 - angleToBall)) / Math.cos(540 - angleToBall);
//			setVelX(ball1VelX);
//			
//			double ball2VelY = (2 * getVelY( ) * (Math.cos(540 - angleToBall) - Math.cos(450 - angleToBall)) / Math.cos(2 * (540 - angleToBall)) + Math.cos(2 * (450 - angleToBall)) + 2); 
//			ball.setVelY(ball2VelY);
//			
//			double ball1VelY = (getVelY() - ball.getVelY( ) * Math.cos(450 - angleToBall)) / Math.cos(540 - angleToBall);
//			setVelY(ball1VelY);
//		}
		
	}
	
	public static final int TOP_RAIL = 0,
							RIGHT_RAIL = 1,
							BOTTOM_RAIL = 2,
							LEFT_RAIL = 3;
		
	/**
	 * Enter method description here <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param side
	 */
	public void collideWithRail(int side)
	{
		
		switch (side)
		{
			case TOP_RAIL:
				setLocY(0);
				setVelY(-getVelY( ));
				break;
			case RIGHT_RAIL:
				setLocX(Render.WIDTH);
				setVelX(-getVelX());
				break;
			case BOTTOM_RAIL:
				setLocY(Render.HEIGHT);
				setVelY(-getVelY( ));
				break;
			case LEFT_RAIL:
				setLocX(0);
				setVelX(-getVelX( ));
				break;
		}
	}
	
	/**
	 * Draws the ball <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param g
	 */
	public void drawBall(Graphics g)
	{
		g.setColor(getBallColor( ));
		g.drawImage(ballImage, (int)(getLocX() - 8.5), (int)(getLocY() - 8.5), null);
		
		g.setColor(Color.BLACK);
		
		if (Math.abs(getVelX( )) < 1 && Math.abs(getVelY()) < 1)
			g.drawString(ballNumber.toString( ), (int)getLocX( ) + 10, (int)getLocY( ) + 10);
	}
	
	public double getAngle(double x1, double y1, double x2, double y2) {

		 

        // take care of special cases - if the angle

        // is along any axis, it will return NaN,

        // or Not A Number.  This is a Very Bad Thing(tm).

        if (y2 == y1) {

            return (x1 > x2) ? 180 : 0; 

        }

        if (x2 == x1) {

            return (y2 > y1) ? 90 : 270;

        }

        

        double tangent = (x2 - x1) / (y2 - y1);

        // convert from radians to degrees

        double ang = (float) Math.atan(tangent) * 57.2958;

        // the arctangent function is non-deterministic,

        // which means that there are two possible answers

        // for any given input.  We decide which one here.

        if (y2-y1 < 0) ang -= 180;

 

 

        // NOTE that this does NOT need to be normalised.  Arctangent

        // always returns an angle that is within the 0-360 range.

        

 

        // barf it back to the calling function

        return (double) ang;

    

    }
	
	public static String round(double d, int sig)
	{
		String formatterString = "##0.";
		
		for (int c = 0; c < sig; c++)
			formatterString += "0";
		
		if (Math.abs(d) <  1e-4)
			d = 0.0;
		
		DecimalFormat f = new DecimalFormat(formatterString);
		
		return f.format(d);
	}

}
