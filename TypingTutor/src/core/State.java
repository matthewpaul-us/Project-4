/**
 * ---------------------------------------------------------------------------
 * File name: State.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: May 8, 2012<br/>
 * Date of Last Modification: May 8, 2012
 * ---------------------------------------------------------------------------
 */

package core;


/**
 * Enum that represent the different states the game could be in<br>
 *
 * <hr>
 * Date created: May 8, 2012<br>
 * Date last modified: May 8, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public enum State
{
	ERROR,		// Error state; should never have to use this
	TITLE,		// Title screen state
	COUNTDOWN,	// Countdown State
	LOOP,		// The game loop
	GAME_OVER,	// Game over
	WON,		// Player has won
	PAUSED		// Paused the game
}
