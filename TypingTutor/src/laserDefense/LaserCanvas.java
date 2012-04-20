/**
 * ---------------------------------------------------------------------------
 * File name: LaserCanvas.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 19, 2012<br/>
 * Date of Last Modification: Apr 19, 2012
 * ---------------------------------------------------------------------------
 */

package laserDefense;

import java.awt.Color;
import java.awt.Graphics;
import front.Gui;
import front.TutorCanvas;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 19, 2012<br>
 * Date last modified: Apr 19, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class LaserCanvas extends TutorCanvas
{
	
	public LaserCanvas()
	{
		super();
		
		game = new LaserTutor();
		
		game.initialize( );
	}
	
	@Override
	public void renderPausedScreen()
	{
		if(!exiting)
		{
		Graphics g = buffer.getDrawGraphics( );

		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Gui.WIDTH, Gui.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.drawString("PAUSED", Gui.WIDTH / 2, Gui.HEIGHT / 2);

		g.dispose( );
		buffer.show( );
		}
	}
	
	@Override
	public void reset()
	{
		game = new LaserTutor( );
		game.initialize( );
	}

}
