/* Given a string, write a function to check if it is a permutation of a palindrome.  A palindrome
 * is a word or phrae that is the same forwards and backwards.  A permutation is a rearrangement of
 * words.  The palindrome does not need to be limited to just dictionary words.
 */
public class palindrome_permutation
{
	public static void main(String[] args)
	{
		if(check_pp(args[0])) System.out.println("It can have palindrome permutations");
		else System.out.println("It cannot have palindrome permutations");
	}

	/* To solve count the number of times each letter appears in an array that holds all 26 
	letter values.  Then, if the string is of even length, if any of those letter counts is
	not even, it can't be a palindrome.  If the string is odd, it's allowed to have one letter
	count that is odd.
	*/
	private static boolean check_pp(String input)
	{
		int[] letterCount = new int[26];
		char[] inputArray = input.toLowerCase().toCharArray();
		boolean isEven = (inputArray.length % 2 == 0);
		boolean oddFound = false;

		for(char c : inputArray)
		{
			int charnum = 'z' - c;
			if(charnum > -1 && charnum < 26) letterCount[charnum]++;
			else isEven = !isEven;
		}

		for(int i : letterCount)
		{
			if(i % 2 != 0) 
			{
				if(isEven) return false;
				else if(oddFound) return false;
				else oddFound = true;
			}
		}
		return true;
	}
}