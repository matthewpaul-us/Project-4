/**
 * ---------------------------------------------------------------------------
 * File name: TutorCanvas.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 17, 2012<br/>
 * Date of Last Modification: Apr 17, 2012
 * ---------------------------------------------------------------------------
 */

package front;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import core.Tutor;


/**
 * Class that handles the game screen. To be placed into a gui.<br>
 *
 * <hr>
 * Date created: Apr 17, 2012<br>
 * Date last modified: Apr 17, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class TutorCanvas extends Canvas
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	public final static int WIDTH = 400,
							HEIGHT = 400;
	
	BufferStrategy buffer;
	
	Tutor game;
	
	public TutorCanvas()
	{
		super();
		
		game = new Tutor();
		
		setBounds(0, 0, WIDTH, HEIGHT);
		setIgnoreRepaint(true);
		
		
	}
	
	long desiredFPS = 60;
    long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;
    
   boolean running = true;
   
   public void loop()
   {
	   long beginLoopTime;
	      long endLoopTime;
	      long currentUpdateTime = System.nanoTime();
	      long lastUpdateTime;
	      long deltaLoop;
	      
	      while(running){
	         beginLoopTime = System.nanoTime();
	         
	         render();
	         
	         lastUpdateTime = currentUpdateTime;
	         currentUpdateTime = System.nanoTime();
	         update((int) ((currentUpdateTime - lastUpdateTime)/(1000*1000)));
	         
	         endLoopTime = System.nanoTime();
	         deltaLoop = endLoopTime - beginLoopTime;
	           
	           if(deltaLoop > desiredDeltaLoop){
	               //Do nothing. We are already late.
	           }else{
	               try{
	                   Thread.sleep((desiredDeltaLoop - deltaLoop)/(1000*1000));
	               }catch(InterruptedException e){
	                   System.out.println(e.getMessage( ));
	               }
	           }
	      }
   }
   
   public void render()
   {
	   //game.drawGame(buffer.getDrawGraphics( ));
	   Graphics g = buffer.getDrawGraphics( );
	   buffer.show( );
   }
   
   public void update(int deltaTime)
   {
	   //game.update(deltaTime);
   }
   
   public void addNotify()
   {
	   super.addNotify();
	   this.createBufferStrategy(2);
	   buffer = this.getBufferStrategy();
	   loop();
	}
	
	

}
