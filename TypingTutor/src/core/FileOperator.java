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
import java.io.FileWriter;
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
	//////////////////
	//				
	//	FIELDS		
	//				
	//////////////////
//	default file paths
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
	
//////////////////
//				
//	CONSTRUCTORS
//				
//////////////////
	
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
	
	
//////////////////
//	
//	METHODS
//	
//////////////////
	
	/**
	 * Returns the word file. <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @return File object that represents the word file
	 */
	public File getWordFile()
	{
		return wordFile;
	}
	
	/**
	 * Sets the word file to the specified file <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param wordFile the File object that represents the word file
	 * @throws IOException - if file does not exist
	 */
	public void setWordFile(File wordFile) throws IOException
	{
		if (wordFile.exists( ))
			this.wordFile = new File(wordFile.toURI( ));
		else
			throw new IOException("File does not exist: " + wordFile.getAbsolutePath( ));
	}
	
	/**
	 * Gets the score file. <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @return File object that represents the score file
	 */
	public File getScoreFile()
	{
		return scoreFile;
	}
	
	/**
	 * Sets the score file to the specified file <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param scoreFile the File object that represents the score file
	 * @throws IOException - if score file does not exist
	 */
	public void setScoreFile(File scoreFile) throws IOException
	{
		if (scoreFile.exists( ))
			this.scoreFile = new File(scoreFile.toURI( ));
		else
			throw new IOException("File does not exist: " + scoreFile.getAbsolutePath( ));
	}
	
	/**
	 * Gets the results file <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @return The File object that represents the results file
	 */
	public File getResultsFile()
	{
		return resultsFile;
	}
	
	/**
	 * Sets the results file to the specified file <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param resultsFile
	 * @throws IOException - if the results file does not exist
	 */
	public void setResultsFile(File resultsFile) throws IOException
	{	
		if (resultsFile.exists( ))
			this.resultsFile = new File(resultsFile.toURI( ));
		else
			throw new IOException("File does not exist: " + resultsFile.getAbsolutePath( ));
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
	public String[] read(int fileChoice) throws IOException
	{
		Scanner inputFile = null;
		
		inputFile = new Scanner(chooseFile(fileChoice));
		
		ArrayList <String> lines = new ArrayList<String>();
		
		while(inputFile.hasNext( ))
		{
			lines.add(inputFile.nextLine( ));
		}
		
		inputFile.close( );
		
		return lines.toArray(new String[lines.size( )]);
	}


	/**
	 * Returns an File object based on the constant passed in. <br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 * @param fileChoice
	 * @return
	 * @throws FileNotFoundException
	 */
	
	private File chooseFile(int fileChoice) throws FileNotFoundException
	{
		File inputFile;
		switch (fileChoice)
		{
			case WORD_FILE:
				inputFile = new File(wordFile.toURI( ));
				break;
			case SCORE_FILE:
				inputFile = new File(scoreFile.toURI( ));
				break;
			case RESULTS_FILE:
				inputFile = new File(resultsFile.toURI( ));
				break;
			default:
				inputFile = null;
				break;
		}
		return inputFile;
	}
	
	/**
	 * Writes an array of lines to a file specified by the constant parameter. <br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 * @param fileChoice - an integer representing the file requested. Use a declared constant if possible
	 * @param overwrite - a boolean indicating whether to append the data or not. True means append.
	 * @param lines - a String array containing the lines to be written to the file.
	 * @throws IOException - if the file does not exist, or the write operation failed.
	 */
	public void write(int fileChoice, boolean overwrite, String[] lines) throws IOException
	{
		FileWriter outputFile = new FileWriter(chooseFile(fileChoice), overwrite);
		
		if(overwrite)
			outputFile.write("\n");
		
		for (String line: lines)
		{
			outputFile.write(line);
		}
		
		outputFile.close( );
	}
	
	/**
	 * Writes an array of lines to a file specified by the constant parameter. This is a 
	 * wrapper to make writing a single line to the file easier. Automatically appends it.<br>        
	 *
	 * <hr>
	 * Date created: Apr 17, 2012 <br>
	 * Date last modified: Apr 17, 2012 <br>
	 *
	 * <hr>
	 * @param fileChoice - an integer representing the file requested. Use a declared constant if possible
	 * @param overwrite - a boolean indicating whether to append the data or not. True means append.
	 * @param line - a String containing the line to be written to the file.
	 * @throws IOException - if the file does not exist, or the write operation failed.
	 */
	public void write(int fileChoice, String line) throws IOException
	{
		String[] array = new String[1];
		array[0] = line;
		
		write(fileChoice, true, array);
	}

}
