/**
 * ---------------------------------------------------------------------------
 * File name: TextProcessorTest.java<br/>
 * Project name: quasiZork<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 15, 2012<br/>
 * Date of Last Modification: Mar 15, 2012
 * ---------------------------------------------------------------------------
 */

package test;

import core.TextProcessor;


/**
 * Tests the TextProcessor Class<br>
 *
 * <hr>
 * Date created: Mar 15, 2012<br>
 * Date last modified: Mar 15, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class TextProcessorTest
{

	/**
	 * Driver for the test class. <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @param args
	 */

	public static void main(String [ ] args)
	{
		System.out.println("Inputting \"Go west\"");
		System.out.println(TextProcessor.process("Go west").name( ));
		
		System.out.println("Inputting \"Travel W\"");
		System.out.println(TextProcessor.process("Travel W").name( ));
		
		System.out.println("Inputting \"Move East\"");
		System.out.println(TextProcessor.process("Move East").name( ));
		
		System.out.println("Inputting \"go e\"");
		System.out.println(TextProcessor.process("go e").name( ));
		
		System.out.println("Inputting \"Crazy stuffs\"");
		System.out.println(TextProcessor.process("Crazy stuffs").name( ));
	}

}
