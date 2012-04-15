/**
 * ---------------------------------------------------------------------------
 * File name: Test.java<br/>
 * Project name: poolSimulator<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 28, 2012<br/>
 * Date of Last Modification: Mar 28, 2012
 * ---------------------------------------------------------------------------
 */

package front;

import javax.swing.*;
import core.Ball;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * A test panel to mess around on<br>
 *
 * <hr>
 * Date created: Mar 28, 2012<br>
 * Date last modified: Mar 28, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class Test extends JPanel
{
	JPanel test;
	int x = 0;
	
	Ball[] balls;
	
	public Test()
	{
		setBackground(Color.BLACK);
		
		balls = new Ball[2];
		
		balls[0] = new Ball();
		balls[1] = new Ball();
		
		balls[1].setLocX(200);
		balls[1].setLocY(200);
		balls[1].setBallColor(Color.CYAN);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// Paint code
		for (Ball ball: balls)
		{
			ball.drawBall(g);
		}
		
		
	}

}
