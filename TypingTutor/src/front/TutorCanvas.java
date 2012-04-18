/**
 * ---------------------------------------------------------------------------
 * File name: TutorCanvas.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 18, 2012<br/>
 * Date of Last Modification: Apr 18, 2012
 * ---------------------------------------------------------------------------
 */

package front;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import core.Tutor;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 18, 2012<br>
 * Date last modified: Apr 18, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class TutorCanvas extends Canvas
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	Tutor game;
	BufferStrategy buffer;
	
	public TutorCanvas()
	{
		super();
		game = new Tutor();
	}
	
	public void render()
	{
		Graphics g = buffer.getDrawGraphics( );
		   
		   game.drawGame(g);
		   g.clearRect(0, 0, WIDTH, HEIGHT);
		   g.dispose( );
		   buffer.show( );
	}
	
	public void setBufferStrategy()
	{
		buffer = getBufferStrategy( );
	}
	
	public void update(int deltaTime)
	{
		game.update(deltaTime);
	}
}
