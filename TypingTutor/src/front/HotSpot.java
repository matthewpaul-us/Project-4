/**
 * ---------------------------------------------------------------------------
 * File name: HotSpot.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: May 9, 2012<br/>
 * Date of Last Modification: May 9, 2012
 * ---------------------------------------------------------------------------
 */

package front;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: May 9, 2012<br>
 * Date last modified: May 9, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class HotSpot
{
	protected Rectangle rect;
	private Color	hotSpotColor;
	private String	hotSpotString;
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param x x coordinate of the top left corner.
	 * @param y y coordinate of the top left corner.
	 * @param width width of the hotspot.
	 * @param height height of the hotspot.
	 */
	public HotSpot(int x, int y, int width, int height)
	{
		rect = new Rectangle(x, y, width, height);
		hotSpotColor = Color.DARK_GRAY;
		hotSpotString = "Button";
	}
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param x x coordinate of the top left corner.
	 * @param y y coordinate of the top left corner.
	 * @param size width and height of the hotspot.
	 */
	public HotSpot(int x, int y, int size)
	{
		this(x, y, size, size);
	}
	
	/**
	 * Determines whether the mouse click happened inside the hotspot. <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param e MouseEvent that is to be checked
	 * @return true if the click was inside the hotspot
	 */
	public boolean isClicked(MouseEvent e)
	{
		return rect.contains(e.getX( ), e.getY( ));
	}
	
	/**
	 * Draws the hotspot. <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param g
	 */
	public void drawHotSpot(Graphics g)
	{
		g.setColor(hotSpotColor);
		
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(hotSpotString, rect.x + 5, rect.y + 5);
	}
}
