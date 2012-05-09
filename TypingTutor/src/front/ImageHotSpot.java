/**
 * ---------------------------------------------------------------------------
 * File name: ImageHotSpot.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: May 9, 2012<br/>
 * Date of Last Modification: May 9, 2012
 * ---------------------------------------------------------------------------
 */

package front;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Specialized HotSpot that uses an image for its zone.<br>
 *
 * <hr>
 * Date created: May 9, 2012<br>
 * Date last modified: May 9, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class ImageHotSpot extends HotSpot
{
	private BufferedImage image = null;
	
	
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param x the x coordinate of the hotspot's top left corner
	 * @param y the y coordinate of the hotspot's top left corner
	 * @param imageFile the file that contains the image to be used
	 */
	public ImageHotSpot(int x, int y, File imageFile)
	{
		super(x, y, 50, 30);
		
		try
		{
			loadImage(imageFile);
			
			rect = new Rectangle(x, y, image.getWidth( ), image.getHeight( ));
		}
		catch (IOException e)
		{
			System.out.println("Error loading hotspot image!");
		}
		
	}
	
	/**
	 * Loads the specified image. <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param imageFile File to be used as the hotspot.
	 * @throws IOException
	 */
	private void loadImage(File imageFile) throws IOException
	{
		image = ImageIO.read(imageFile);
	}
	
	/**
	 * Draws the hotspot using the image. <br>        
	 *
	 * <hr>
	 * Date created: May 9, 2012 <br>
	 * Date last modified: May 9, 2012 <br>
	 *
	 * <hr>
	 * @param g
	 * @see front.HotSpot#drawHotSpot(java.awt.Graphics)
	 */
	@Override
	public void drawHotSpot(Graphics g)
	{
		if (image != null)
			g.drawImage(image, rect.x, rect.y, null);
		else
			super.drawHotSpot(g);
	}
}
