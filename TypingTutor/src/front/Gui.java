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

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
public class Gui implements Runnable
{
//	The width of the game window. Controls the outer frame size
	public static final int	WIDTH	= 600;
//	the height of the game window. Controls the outer frame size
	public static final int	HEIGHT	= 600;
	
//	The TutorCanvas that the game screen will be written on
	TutorCanvas canvas;
	
//	The frame that holds the canvas
	JFrame frame;

	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 18, 2012 <br>
	 * Date last modified: Apr 18, 2012 <br>
	 *
	 * <hr>
	 */
	public Gui()
	{
		frame = new JFrame("Typing Tutor");

		JPanel panel = (JPanel) frame.getContentPane( );

		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);

		canvas = new TutorCanvas();
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		canvas.setIgnoreRepaint(true);
		
		JMenuBar menuBar = new JMenuBar( );
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem resetOption = new JMenuItem("Reset Game");
		JMenuItem quitOption = new JMenuItem("Quit Game");
		
		fileMenu.add(resetOption);
		fileMenu.add(quitOption);
		
		JMenu gameMenu = new JMenu("Game");
		JMenuItem missileOption = new JMenuItem("Laser Defense");
		JMenuItem speedOption = new JMenuItem("Speed Test");
		
		gameMenu.add(missileOption);
		gameMenu.add(speedOption);
		
		
		JMenu aboutMenu = new JMenu("About");
		JMenuItem aboutOption = new JMenuItem("About Us");
		
		aboutMenu.add(aboutOption);
		

		menuBar.add(fileMenu);
		menuBar.add(gameMenu);
		menuBar.add(aboutMenu);
		
		frame.setJMenuBar(menuBar);

		panel.add(canvas);

		canvas.addKeyListener(new TutorKeyListener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas.addFocusListener(new TutorFocusListener());
		
		canvas.setBufferStrategy( );
		canvas.requestFocus();
	}
	
	private class TutorFocusListener implements FocusListener
	{

		@Override
		public void focusGained(FocusEvent arg0)
		{
			paused = false;
		}

		@Override
		public void focusLost(FocusEvent arg0)
		{
			paused = true;
		}
		
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
			canvas.processCharacter(e);
		}

	}

	long desiredFPS = 60;
	long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;

	boolean running = true;
	private boolean	paused;

	@Override
	public void run()
	{
		long beginLoopTime;
		long endLoopTime;
		long currentUpdateTime = System.nanoTime();
		long lastUpdateTime;
		long deltaLoop;

		while(running)
		{
			
			beginLoopTime = System.nanoTime();

			if (!paused)
			{
				canvas.render();
			}
			else
			{
				canvas.renderPausedScreen( );
			}
			lastUpdateTime = currentUpdateTime;
			currentUpdateTime = System.nanoTime();
			
			if (!paused)
			{
				canvas.update((int) ((currentUpdateTime - lastUpdateTime)/(1000*1000)));
			}
			
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
		Gui gui = new Gui();
		new Thread(gui).start( );
	}

}
