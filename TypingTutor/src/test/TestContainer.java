/**
 * ---------------------------------------------------------------------------
 * File name: TestContainer.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 17, 2012<br/>
 * Date of Last Modification: Apr 17, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * ---------------------------------------------------------------------------
 * File name: TestContainer.java<br/>
 * Project name: poolSimulator<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 28, 2012<br/>
 * Date of Last Modification: Mar 28, 2012
 * ---------------------------------------------------------------------------
 */

package test;

import java.awt.*;
import javax.swing.*;
import front.TutorCanvas;

/**
 * Provides a test for canvas tutorials.<br>
 *
 * <hr>
 * Date created: Mar 28, 2012<br>
 * Date last modified: Mar 28, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class TestContainer implements Runnable
{

	private static final String	TITLE	= "Generic Title";
	private static final int	X_SIZE	= 400;
	private static final int	Y_SIZE	= 400;

	/**
	 * Main method of the class. <br>        
	 *
	 * <hr>
	 * Date created: Mar 28, 2012 <br>
	 * Date last modified: Mar 28, 2012 <br>
	 *
	 * <hr>
	 * @param args
	 */

	public static void main(String [ ] args)
	{
		
		new TestContainer( );
	}
	
	public TestContainer()
	{
		JFrame gui = new JFrame();
		gui.setTitle(TITLE);
		gui.setSize(X_SIZE, Y_SIZE);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Container pane = gui.getContentPane( );
		pane.setLayout(new GridLayout(1,1));
		
		
		
		gui.setVisible(true);
		
		Canvas canvas = new TutorCanvas();
		pane.add(canvas);
		gui.pack( );
		
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}

}