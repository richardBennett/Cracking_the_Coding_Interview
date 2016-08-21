/* Assume you have a method isSubstring which checks if one word is a substring of another.  Given
 * two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to 
 * isSubstring. (e.g. "waterbottle" is a rotation of "erbottlewat").
 */
public class string_rotation
{
	public static void main(String[] args)
	{
		if(isRotation(args[0], args[1])) System.out.println("YES");
		else System.out.println("NO");
	}

	//To see if the second string is a rotation of the first, add the first string to itself
	//For instance "waterbottlewaterbottle" then if the second string is a substring of that, it was
	//a rotation!
	public static boolean isRotation(String fullstring, String substring)
	{
		String rotations = fullstring + fullstring;
		return isSubstring(rotations, substring);
	}

	//Not really needed but the problem called for an isSubstring class
	public static boolean isSubstring(String fullstring, String substring)
	{
		return fullstring.toLowerCase().contains(substring.toLowerCase());
	}
}