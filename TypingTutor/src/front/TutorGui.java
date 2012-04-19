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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
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
public class TutorGui implements Runnable
{
	private static final long	serialVersionUID	= 1L;
	
	private static final String[] TEST_ARRAY = {"Hello", "Goodbye", "Chiau", "Hallo"};
	
	public final static int WIDTH = 600,
							HEIGHT = 600;
	
		JFrame frame;
		Canvas canvas;
		BufferStrategy buffer;
	    Tutor game;
	   
	   public TutorGui(){
	      frame = new JFrame("Render Frame");
	      
	      game = new Tutor(TEST_ARRAY);
	      
	      JPanel panel = (JPanel) frame.getContentPane();
	      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	      panel.setLayout(null);
	      
	      canvas = new Canvas();
	      canvas.setBounds(0, 0, WIDTH, HEIGHT);
	      canvas.setIgnoreRepaint(true);
	      
	      panel.add(canvas);
	      
	      canvas.addKeyListener(new TutorKeyListener());
	      
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.pack();
	      frame.setResizable(false);
	      frame.setVisible(true);
	      
	      canvas.createBufferStrategy(2);
	      buffer = canvas.getBufferStrategy();
	      
	      canvas.requestFocus();
	      
	      game.initialize( );
	   }
	

	private class TutorKeyListener implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent e)
		{
//			do nothing
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
//			do nothing
		}

		@Override
		public void keyTyped(KeyEvent e)
		{
			game.processCharacter(e);
		}
		
	}
	
	
	long desiredFPS = 60;
    long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;
    
   boolean running = true;
   
   public void run()
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
	   Graphics g = buffer.getDrawGraphics( );
	   g.clearRect(0, 0, WIDTH, HEIGHT);
	   game.drawGame(g);
	   
	   g.dispose( );
	   buffer.show( );
   }
   
   public void update(int deltaTime)
   {
	   game.update(deltaTime);
   }
   
   public static void main(String [] args)
   {
	      
	      TutorGui gui = new TutorGui();
	      new Thread(gui).start( );
   }
}
