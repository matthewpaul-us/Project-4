/**
 * ---------------------------------------------------------------------------
 * File name: FileWriter.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 16, 2012<br/>
 * Date of Last Modification: Apr 16, 2012
 * ---------------------------------------------------------------------------
 */

package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Handles writing and reading to and from text files.<br>
 *
 * <hr>
 * Date created: Apr 16, 2012<br>
 * Date last modified: Apr 16, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class FileOperator
{
	public static final String	DEFAULT_WORD_FILE	= "resources/wordList.txt";
	public static final String	DEFAULT_SCORE_FILE	= "highScores.txt";
	public static final String	DEFAULT_RESULTS_FILE	= "results.txt";
	
	public static final int WORD_FILE = 0,
							SCORE_FILE = 1,
							RESULTS_FILE = 2;

//	File that contains the library to be used
	private File wordFile,
//	File that contains the high scores for the tutor
				 scoreFile,
//	File that contains the results of the score
				 resultsFile;
	
	
	/**
	 * Full Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 16, 2012 <br>
	 * Date last modified: Apr 16, 2012 <br>
	 *
	 * <hr>
	 * @param wordFile The file that contains the list of words.
	 * @param scoreFile The file that contains the high scores.
	 * @param resultsFile The file that contains the results of the typing tutor games.
	 */
	public FileOperator(File wordFile, File scoreFile, File resultsFile)
	{
		this.wordFile = new File(wordFile.toURI( ));
		this.scoreFile = new File(scoreFile.toURI( ));
		this.resultsFile = new File(resultsFile.toURI( ));
	}
	
	
	/**
	 * No-Arg Constructor. Uses a file in the resources folder named wordList.txt
	 * as the word list file, and files in the base directory named highScores.txt
	 * and results.txt for the high scores of the game and the game results,
	 * respectively. <br>        
	 *
	 * <hr>
	 * Date created: Apr 16, 2012 <br>
	 * Date last modified: Apr 16, 2012 <br>
	 *
	 * <hr>
	 */
	public FileOperator()
	{
		this(new File(DEFAULT_WORD_FILE), new File(DEFAULT_SCORE_FILE), new File(DEFAULT_RESULTS_FILE));
	}
	
	/**
	 * Returns an array containing all the lines in a file. The file is specified by passing an integer into the method. <br><br>
	 * WORD_FILE - Indicates that the score file is requested. <br>
	 * SCORE_FILE - Indicates that the score file is requested. <br>
	 * RESULTS_FILE - Indicates that the results file is requested. <br>        
	 *
	 * <hr>
	 * Date created: Apr 16, 2012 <br>
	 * Date last modified: Apr 16, 2012 <br>
	 *
	 * <hr>
	 * @param fileChoice an integer representing which file was requested. It is recommended to use the constants in the
	 * class to fill this parameter.
	 * @return String array containing all of the elements from the file.
	 * @throws IOException if the file is not available or the integer passed into method was incorrect.
	 */
	public String[] readFile(int fileChoice) throws IOException
	{
		Scanner inputFile = null;
		
		switch (fileChoice)
		{
			case WORD_FILE:
				inputFile = new Scanner(wordFile);
				break;
			case SCORE_FILE:
				inputFile = new Scanner(scoreFile);
				break;
			case RESULTS_FILE:
				inputFile = new Scanner(resultsFile);
				break;
			default:
				inputFile = null;
				break;
		}
		
		ArrayList <String> lines = new ArrayList<String>();
		
		while(inputFile.hasNext( ))
		{
			lines.add(inputFile.nextLine( ));
		}
		
		return lines.toArray(new String[lines.size( )]);
	}

}
