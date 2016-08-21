/* Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the 
 * "true" length of the string. (Note: If implementing in Java, please use a character array so
 * that you can perform this operation in place.
 */
public class URLify
{
	public static void main(String[] args)
	{
		System.out.println(toURL(args[0]));
	}

	/*To solve set a variable size to the length of the string. Then go through the first string
	every time a blank is found, add two to size.  Once complete create a chararray with size size,
	and copy the first string over, putting '%20' where every blank would be, using an int to keep
	track of the current position.
	*/
	private static String toURL(String input)
	{
		char[] inputArray = input.toCharArray();
		int size = inputArray.length;
		for(char c : inputArray)
		{
			if(c == ' ') size += 2;
		}

		char[] outputArray = new char[size];
		int currentPosition = 0;
		for(int i = 0; i < inputArray.length; i++)
		{
			if(inputArray[i] == ' ') 
			{
				outputArray[currentPosition] = '%';
				outputArray[currentPosition + 1] = '2';
				outputArray[currentPosition + 2] = '0';
				currentPosition += 2;
			}
			else outputArray[currentPosition] = inputArray[i];
			currentPosition++;
		}
		return new String(outputArray);
	}
}