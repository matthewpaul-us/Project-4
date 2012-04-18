/**
 * ---------------------------------------------------------------------------
 * File name: Gui2.java<br/>
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
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 18, 2012<br>
 * Date last modified: Apr 18, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class Gui2 implements Runnable
{
	private static final int	WIDTH	= 600;
	private static final int	HEIGHT	= 600;
	TutorCanvas canvas;


	/**
	 * Enter method description here <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 * @param args
	 */

	public Gui2()
	{
		JFrame frame = new JFrame("Top-level GUI2");

		JPanel panel = (JPanel) frame.getContentPane( );

		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);

		canvas = new TutorCanvas();
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		canvas.setIgnoreRepaint(true);

		JMenuBar menuBar = new JMenuBar( );
		JMenu menu = new JMenu("A Menu");

		menuBar.add(menu);

		panel.add(canvas);

		canvas.addKeyListener(new TutorKeyListener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);

		canvas.createBufferStrategy(2);
		
		canvas.setBufferStrategy( );

		canvas.requestFocus();
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
			//			game.processCharacter(e);
		}

	}

	long desiredFPS = 60;
	long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;

	boolean running = true;

	@Override
	public void run()
	{
		long beginLoopTime;
		long endLoopTime;
		long currentUpdateTime = System.nanoTime();
		long lastUpdateTime;
		long deltaLoop;

		while(running){
			beginLoopTime = System.nanoTime();

			canvas.render();

			lastUpdateTime = currentUpdateTime;
			currentUpdateTime = System.nanoTime();
			canvas.update((int) ((currentUpdateTime - lastUpdateTime)/(1000*1000)));

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
	
	public static void main(String [ ] args)
	{
		Gui2 gui = new Gui2();
		new Thread(gui).start( );
	}

}
