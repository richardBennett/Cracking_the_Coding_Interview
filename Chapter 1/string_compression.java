/* Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.  If the "compressed" string would not
 * become smaller than the original string, your method should return the original string.  You can 
 * assume the string has only uppercase and lowercase letters (a-z).
 */ 

public class string_compression
{
	public static void main(String[] args)
	{
		System.out.println(compress(args[0]));
	}

	/* To solve we'll move down the string, and at each letter after the current letter, if it's
	the same letter we'll increment the count.  Once we hit a different letter we'll add the current
	letter and it's count to output.
	*/
	public static String compress(String input)
	{
		StringBuilder output = new StringBuilder(input.length());
		char[] inputarray = input.toCharArray();

		int count = 1;
		char currentchar = inputarray[0];
		output.append(inputarray[0]);

		for(int i = 1; i < inputarray.length; i++)
		{
			if(inputarray[i] == currentchar) count++;
			else 
			{
				output.append(count);
				currentchar = inputarray[i];
				output.append(inputarray[i]);
				count = 1;
			}
		}
		output.append(count);

		//We'll return the smaller of the two strings, input or output.
		if(output.length() < input.length()) return output.toString();
		return input;
	}
}