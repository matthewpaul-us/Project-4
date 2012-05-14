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
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.io.File;
import core.State;
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
	
//////////////////
//
//FIELDS
//
//////////////////
	
	
	private static final long	serialVersionUID	= 1L;
	
//	The game object for the canvas to run
	protected Tutor game;
	
//	The bufferStrategy used to write to the canvas
	protected BufferStrategy buffer;
	
//	true if the focus has not been requested yet
	boolean firstFocus;
	
	
//////////////////
//
//CONSTRUCTOR
//
//////////////////
	
	
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
	
	
//////////////////
//
//METHODS
//
//////////////////
	
	
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

		game.render(g);

		g.dispose( );
		buffer.show( );
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
	
	/**
	 * Resets the canvas game and initializes it. <br>        
	 *
	 * <hr>
	 * Date created: Apr 24, 2012 <br>
	 * Date last modified: Apr 24, 2012 <br>
	 *
	 * <hr>
	 */
	public void reset(File wordFile)
	{
		if (wordFile.exists( ))
		{
			game = new Tutor(wordFile);
		}
		else
		{
			game = new Tutor( );
		}
		game.initialize( );
	}

	/**
	 * Sets the game state <br>        
	 *
	 * <hr>
	 * Date created: May 8, 2012 <br>
	 * Date last modified: May 8, 2012 <br>
	 *
	 * <hr>
	 * @param state State enum to set
	 */
	public void setGameState(State state)
	{
		game.setState(state);
	}

	/**
	 * Processes a mouse click. Used for the hotspots on the title screen. <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param e
	 */
	public void mouseClicked(MouseEvent e)
	{
		game.processMouse(e);
	}


	/**
	 * Sets the pause. Passes the boolean down to the game. <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param b
	 */
	public void setPause(boolean b)
	{
		game.setPause(b);
	}
}
