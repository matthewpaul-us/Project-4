/**
 * ---------------------------------------------------------------------------
 * File name: AboutDialogTest.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 20, 2012<br/>
 * Date of Last Modification: Apr 20, 2012
 * ---------------------------------------------------------------------------
 */

package test;

import javax.swing.JDialog;
import front.AboutDialog;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 20, 2012<br>
 * Date last modified: Apr 20, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class AboutDialogTest
{

	/**
	 * Enter method description here <br>        
	 *
	 * <hr>
	 * Date created: Apr 20, 2012 <br>
	 * Date last modified: Apr 20, 2012 <br>
	 *
	 * <hr>
	 * @param args
	 */

	public static void main(String [ ] args)
	{
		JDialog dialog = new AboutDialog(null);
		
		dialog.setVisible(true);

	}

}
