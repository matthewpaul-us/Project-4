/**
 * ---------------------------------------------------------------------------
 * File name: FileOperatorTest.java<br/>
 * Project name: TypingTutor<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Apr 19, 2012<br/>
 * Date of Last Modification: Apr 19, 2012
 * ---------------------------------------------------------------------------
 */

package test;

import java.io.File;
import java.io.IOException;
import core.FileOperator;


/**
 * Tests the FileOperator Class<br>
 *
 * <hr>
 * Date created: Apr 19, 2012<br>
 * Date last modified: Apr 19, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class FileOperatorTest
{

	/**
	 * Main method <br>        
	 *
	 * <hr>
	 * Date created: Apr 19, 2012 <br>
	 * Date last modified: Apr 19, 2012 <br>
	 *
	 * <hr>
	 * @param args - not used
	 */

	public static void main(String [ ] args)
	{
		FileOperator fileOp = new FileOperator();
		
		System.out.println("Printing wordList file\n");
		
		String[] lines = null;
		
		try
		{
			lines = fileOp.read(FileOperator.WORD_FILE);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String line: lines)
		{
			System.out.println(line);
		}
		
		try
		{
			fileOp.write(FileOperator.WORD_FILE, "Halifax");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\n");
		
		try
		{
			lines = fileOp.read(FileOperator.WORD_FILE);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String line: lines)
		{
			System.out.println(line);
		}
		
		try
		{
			fileOp.setWordFile(new File("wordList"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage( ));
		}
	}
}
