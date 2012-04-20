/**
 * ---------------------------------------------------------------------------
 * File name: LaserTutor.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 19, 2012<br/>
 * Date of Last Modification: Apr 19, 2012
 * ---------------------------------------------------------------------------
 */

package laserDefense;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.prefs.BackingStoreException;
import javax.imageio.ImageIO;
import core.FileOperator;
import core.Tutor;
import core.Word;
import core.WordPool;
import front.Gui;


/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Apr 19, 2012<br>
 * Date last modified: Apr 19, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class LaserTutor extends Tutor
{
	
	BufferedImage backgroundImage,
				  crosshairImage;
	
	File backgroundFile = new File("resources/laserBackground.gif");
	File crosshairFile = new File("resources/laserCrossHairs.gif");
	

	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param wordsOnScreen
	 * @param acceptableWords
	 * @param clearedWords
	 * @param livesLeft
	 * @param errors
	 * @param buffer
	 */
	public LaserTutor(ArrayList <LaserWord> wordsOnScreen,
						ArrayList <LaserWord> acceptableWords,
						ArrayList <LaserWord> clearedWords, int livesLeft,
						int errors, StringBuffer buffer)
	{
		this.wordsOnScreen = new ArrayList<Word>(wordsOnScreen);
		this.acceptableWords = new ArrayList<Word>(acceptableWords);
		this.clearedWords = new ArrayList<Word>(clearedWords);
		
		this.livesLeft = livesLeft;
		this.errors = errors;
		
		this.buffer = new StringBuffer(buffer);
		
		FileOperator file = new FileOperator( );
		
		String [ ] lines = null;
		
		try
		{
			lines = file.read(FileOperator.WORD_FILE);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.pool = createWordPool(lines);
		
		file = null;
		
		try
		{
			loadImages( );
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage( ));
		}
	}

	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param array
	 */
	public LaserTutor(String [ ] array)
	{
		super(array);
	}

	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 */
	public LaserTutor()
	{
		try
		{
			loadImages( );
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected WordPool createWordPool(String [ ] lines)
	{
		LaserWord[] words = new LaserWord[lines.length];
		
		Random r = new Random();
		
		for (int c = 0; c < words.length; c++)
		{
			words[c] = new LaserWord(lines[c], r.nextInt(530) + 35, 0);
		}
		
		return new WordPool(words);
	}
	
	@Override
	public void drawGame(Graphics g)
	{
		g.drawImage(backgroundImage, 0, 0, Gui.WIDTH, Gui.HEIGHT, null);
		
		
		
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 10, Gui.HEIGHT / 30);
		g.drawString("High Score: ", 10, Gui.HEIGHT / 30 + 13);
		g.drawString("Errors: " + errors, 10, Gui.HEIGHT / 30 + 26);
		
		int charactersTyped = 0;
		
		for (Word word: clearedWords)
		{
			charactersTyped += word.getCharactersCleared( );
		}
		int wpm = (charactersTyped == 0? 1: charactersTyped) * 720 / (frameCount == 0? 1: frameCount);
		g.drawString("WPM: " + wpm, 10, Gui.HEIGHT / 30 + 39);		
		
		try
		{
			for (Word word: wordsOnScreen)
				word.drawWord(g);
		}
		catch (ConcurrentModificationException e)
		{
			e.printStackTrace();
		}
		
		drawCrosshairs(g);
		
		if (killedWord != null)
			drawKillShot(g);
	}
	
//	@Override
//	public void update(int deltaTime)
//	{
//		
//	}
	
	private void drawKillShot(Graphics g)
	{
		g.setColor(Color.ORANGE);
		
		g.drawLine(288, 442, killedWord.getLocX( ), killedWord.getLocY( ));
		
		killedWord = null;
	}

	private void drawCrosshairs(Graphics g)
	{
		Word word;
		
		for (int c = 0; c < acceptableWords.size( ); c++)
		{
			word = acceptableWords.get(c);
						
			g.drawImage(crosshairImage, word.getLocX( ) - crosshairImage.getWidth( ) / 2, word.getLocY( ) - crosshairImage.getHeight( ) / 2, null);
		}
	}

	@Override
	public void gameOver()
	{
		
	}
	
	private void loadImages() throws IOException
	{
			loadBackgroundImage();
			loadCrosshairFile();

	}
	
	private void loadCrosshairFile() throws IOException
	{
		crosshairImage = ImageIO.read(crosshairFile);
	}
	
	private void loadBackgroundImage() throws IOException
	{
		backgroundImage = ImageIO.read(backgroundFile);
	}

}
