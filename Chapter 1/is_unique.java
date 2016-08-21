/* Implement an algorithm to determine if a string has all unique characters.  What if you
 * cannot use additional data structures?
 */

public class is_unique
{
	public static void main(String[] args)
	{
		boolean output = unique(args[0]);
		if(output) System.out.println("The string is all unique characters");
		else System.out.println("The string is not all unique characters");
	}

	private static boolean unique2(String input)
	{
		//If the string contains more characters than unicode, it can't have all unique characters
		if(input.length() > 128) return false;
		
		//Create a boolean array for each character in unicode.
		boolean[] charValues = new boolean[128];
		
		//For every character in the input check it's boolean in the unicode array.
		//If it's true then it's a dupe and it is not all unique.
		//If it's false then toggle that boolean to true.
		for(int i = 0; i < input.length(); i++)
		{
			int val = input.charAt(i);
			if(charValues[val]) return false;
			else charValues[val] = true;
		}
		//If it hasn't returned false, return true.
		return true;
	}
}