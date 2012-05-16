/**
 * ---------------------------------------------------------------------------
 * File name: Module.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: May 15, 2012<br/>
 * Date of Last Modification: May 15, 2012
 * ---------------------------------------------------------------------------
 */

package front;


/**
 * Enum to represent the different modules.<br>
 *
 * <hr>
 * Date created: May 15, 2012<br>
 * Date last modified: May 15, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public enum Module
{
	ERROR,		//Error Module; should never really have a need to use this
	DEFAULT,	//Default test Module; Uses TutorCanvas
	LASER		//Laser Defense Module; Uses LaserTutorCanvas
}
