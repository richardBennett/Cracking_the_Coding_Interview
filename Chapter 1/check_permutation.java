/* Given Two Strings, write a method to decide if one is a permutation of the other.
 */
public class check_permutation
{
	public static void main(String[] args)
	{
		if(permutation(args[0], args[1])) System.out.println("They are permutations");
		else System.out.println("They are not permutations"); 
	}

	private static boolean permutation(String string1, String string2)
	{
		//If they are not the same length, they cannot be permutations
		if(string1.length() != string2.length()) return false;

		//Create an int array for every character in unicode;
		int[] charCount = new int[128];
		char[] charArray1 = string1.toCharArray();
		char[] charArray2 = string2.toCharArray();

		//For every character in the first string increment that position in the unicode array
		for(char c1 : charArray1)
		{
			charCount[c1]++;
		}
		
		//For every character in the second string decrement that position in the unicode array
		//If any position in the unicode array becomes less than zero, then it was not a permutation
		for(char c2 : charArray2)
		{
			charCount[c2]--;
			if(charCount[c2] < 0) return false;
		}
		//If it hasn't returned false, return true.
		return true;
	}
}