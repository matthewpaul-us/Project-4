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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import core.Tutor;


/**
 * Represents a canvas to which the game can write to.<br>
 *
 * <hr>
 * Date created: Apr 18, 2012<br>
 * Date last modified: Apr 18, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class TutorCanvas extends Canvas
{
	private static final long	serialVersionUID	= 1L;
	
//	The game object for the canvas to run
	protected Tutor game;
	
//	The bufferStrategy used to write to the canvas
	protected BufferStrategy buffer;
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 */
	public TutorCanvas()
	{
		super();
		
		game = new Tutor();
		
		game.initialize( );
	}
	
	/**
	 * Renders a regular frame of the game. <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 */
	public void render()
	{
		Graphics g = buffer.getDrawGraphics( );

		g.clearRect(0, 0, Gui.WIDTH, Gui.HEIGHT);

		game.drawGame(g);

		g.dispose( );
		buffer.show( );
	}
	
	/**
	 * Renders a pause Screen. <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 */
	public void renderPausedScreen()
	{
		Graphics g = buffer.getDrawGraphics( );

		g.clearRect(0, 0, Gui.WIDTH, Gui.HEIGHT);
		
		g.setColor(Color.DARK_GRAY);
		
		g.drawString("PAUSED", Gui.WIDTH / 2, Gui.HEIGHT / 2);

		g.dispose( );
		buffer.show( );
	}
	
	/**
	 * States whether the game has been lost or not <br>        
	 *
	 * <hr>
	 * Date created: Apr 21, 2012 <br>
	 * Date last modified: Apr 21, 2012 <br>
	 *
	 * <hr>
	 * @return boolean. True indicates game has been lost.
	 */
	public boolean isGameOver()
	{
		return game.isGameOver( );
	}
	
	/**
	 * Creates and stores the buffer strategy for the canvas. This method should only
	 * be called after the setVisible(true) call of the containing frame. <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 */
	public void setBufferStrategy()
	{
		createBufferStrategy(2);
		buffer = getBufferStrategy( );
	}
	
	/**
	 * Pipeline to pass the KeyEvent to the game logic. <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 * @param e KeyEvent object that is thrown when a user types a key
	 */
	public void processCharacter(KeyEvent e)
	{
		game.processCharacter(e);
	}
	
	/**
	 * Call the update method of the game. <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 * @param deltaTime
	 */
	public void update(int deltaTime)
	{
		game.update(deltaTime);
	}
	
	public void reset()
	{
		game = new Tutor();
		game.initialize( );
	}

	public void renderGameOver()
	{
		Graphics g = buffer.getDrawGraphics( );

		g.clearRect(0, 0, Gui.WIDTH, Gui.HEIGHT);

		game.renderGameOver(g);

		g.dispose( );
		buffer.show( );
	}
}
