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
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
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
				  crosshairImage,
				  gameOverImage,
				  winImage,
				  lives3Image,
				  lives2Image,
				  lives1Image;
	
	File backgroundFile = new File("resources/laserBackground.gif");
	File crosshairFile = new File("resources/laserCrossHairs.gif");
	File gameOverFile = new File("resources/gameOverScreen.gif");
	File winFile = new File("resources/winScreen.gif");
	
	File lives3File = new File("resources/shield3Lives.gif");
	File lives2File = new File("resources/shield2Lives.gif");
	File lives1File = new File("resources/shield1Life.gif");
	
	DecimalFormat f = new DecimalFormat("#,##0");
	

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
		
		drawHUD(g);
		
		drawLives(g);
		
		try
		{
			for (Word word: wordsOnScreen)
				word.drawWord(g);
		}
		catch (ConcurrentModificationException e)
		{
			FileOperator file = new FileOperator( );
			
			try
			{
				file.write(FileOperator.RESULTS_FILE, "Error!");
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		
		drawCrosshairs(g);
		
		if (killedWord != null)
			drawKillShot(g);
	}

	private void drawLives(Graphics g)
	{
		System.out.println("Drawing Life!");
		g.drawImage(lives3Image, 0, 295, 600, 200, null);
		switch(livesLeft)
		{
			case 3:
				g.drawImage(lives3Image, 0, 295, 600, 200, null);
				break;
			case 2:
				g.drawImage(lives2Image, 0, 295, 600, 200, null);
				break;
			case 1:
				g.drawImage(lives1Image, 0, 295, 600, 200, null);
				break;
			default:
				System.out.println("Error! Default case reached in drawLives()");
		}
	}

	/**
	 * Draw the HUD for the game <br>        
	 *
	 * <hr>
	 * Date created: Apr 21, 2012 <br>
	 * Date last modified: Apr 21, 2012 <br>
	 *
	 * <hr>
	 * @param g
	 */
	
	protected void drawHUD(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawString("Score: " + f.format(score), 10, Gui.HEIGHT / 30);
		g.drawString("Errors: " + errors, 10, Gui.HEIGHT / 30 + 13);
		g.drawString("Aliens Defeated: " + clearedWords.size( ), 10, Gui.HEIGHT / 30 + 26);
		g.drawString("WPM: " + wpm, 10, Gui.HEIGHT / 30 + 39);
	}
	
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
	public void renderGameOver(Graphics g)
	{
		
		g.drawImage(gameOverImage, 0, 0, null);
		drawHUD(g);
	}
	
	@Override
	public void renderWin(Graphics g)
	{
		g.drawImage(winImage, 0, 0, null);
		drawHUD(g);
	}
	
	private void loadImages() throws IOException
	{
			loadBackgroundImage();
			loadCrosshairImage();
			loadGameOverImage();
			loadWinImage();
			loadShieldImages();

	}
	
	private void loadShieldImages() throws IOException 
	{
		lives3Image = ImageIO.read(lives3File);
		lives2Image = ImageIO.read(lives2File);
		lives1Image = ImageIO.read(lives1File);
	}

	private void loadWinImage() throws IOException
	{
		winImage = ImageIO.read(winFile);
	}

	private void loadCrosshairImage() throws IOException
	{
		crosshairImage = ImageIO.read(crosshairFile);
	}
	
	private void loadBackgroundImage() throws IOException
	{
		backgroundImage = ImageIO.read(backgroundFile);
	}
	
	private void loadGameOverImage() throws IOException
	{
		gameOverImage = ImageIO.read(gameOverFile);
	}
	


}
