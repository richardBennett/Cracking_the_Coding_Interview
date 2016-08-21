/* There are three types of edits that can be performed on strings: insert a character, 
 * remove a character, or replace a character.  Given two strings, write a function to check 
 * if they are one edit (or zero edits) away.
 */
public class one_away
{
	public static void main(String[] args)
	{
		if(check_away(args[0], args[1])) System.out.println("It is one away");
		else System.out.println("It is not one away");
	}

	public static boolean check_away(String string1, String string2)
	{
		//boolean found is if an edit has been found.
		boolean found = false;	

		//Create two char arrays, and make the largest string charArray1
		char[] chararray1;
		char[] chararray2;

		if(string1.length() > string2.length() ) 
		{
			chararray1 = string1.toCharArray();
			chararray2 = string2.toCharArray();
		}
		else 
		{
			chararray1 = string2.toCharArray();
			chararray2 = string1.toCharArray();
		}

		//If there's more than a one character difference return false
		if((charArray1.length - charArray2.length) > 1) return false;

		//If they are of equal length, see how many characters are different.
		//If more than one is different there was more than one edit.
		if(chararray1.length == chararray2.length)
		{
			for(int i = 0; i < chararray1.length; i++)
			{
				if(chararray1[i] != chararray2[i])
				{
					if(found) return false;
					else found = true;
				}
			}
			//If one or less match was found, return true.
			return true;
		}

		/* If they are different lengths create an int position. Then iterate through the
		smaller array.  For each index of the smaller array match that char to the char at index
		position of the larger array.  If there's a different increment position and sef
		found to true.  At the end of each index iteration increment position. If it happens again
		than there was more than one edit.
		*/ 
		int position = 0;
		for(int i = 0; i < chararray2.length; i++)
		{
			if(chararray2[i] != chararray1[position])
			{
				if(found) return false;
				else position++;
			}
			position++;
		}
		//If there was only one edit 
		return true;
	}
}