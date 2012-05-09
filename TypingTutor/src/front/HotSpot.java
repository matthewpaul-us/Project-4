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
	Rectangle rect;
	private Color	hotSpotColor;
	
	public HotSpot(int x, int y, int width, int height)
	{
		rect = new Rectangle(x, y, width, height);
	}
	
	public HotSpot(int x, int y, int size)
	{
		this(x, y, size, size);
	}
	
	public boolean isClicked(MouseEvent e)
	{
		return rect.contains(e.getX( ), e.getY( ));
	}
	
	public void drawHotSpot(Graphics g)
	{
		g.setColor(hotSpotColor);
		
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
}
