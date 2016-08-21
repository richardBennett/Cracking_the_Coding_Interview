/* Given an image represented by an NxN matrix, where each pixel in the image is four bytes,
 * write a method to rotate the image by 90 degrees.  Can you do this in place?
 */

public class rotate_matrix
{
	public static void main(String[] args)
	{
		//This is creating a 4x4 matrix to test the method, and filling it with values
		//It starts the values at ten so I could see the matrix with double digits to make
		//it even.
		int n = 4;
		int[][] image = new int[n][n];
		int count = 10;

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				image[i][j] = count;
				count++;
			}
		}

		//Print the matrix to show the original, rotate it, then print it again.
		printImage(image);
		rotate(image);
		printImage(image);
	}

	/* To solve we will rotate the outside blocks of the matrix, then go one block
	inward and rotate those as if they are the outside blocks, until you've reached the center.
	*/
	public static void rotate(int[][] image)
	{

		int n = image[0].length;	//Initial length of outermost blocks.
		int start = 0;				//Initial starting index
		int end, temp;				//The last block to iterate to, and a temporary block.
		
		/*Until you reach the center
		The end is the one less than the initial ending index minus the start index
		Then for every index you want to rotate, from start to end, rotate them.
		Then increment start one to move to the next set of inner blocks.
		*/ 
		while(start < n/2)
		{
			end = n - 1 - start;
			for(int i = start; i < end; i++)
			{
				temp = image[start][start+i];
				image[start][start+i] = image[end-i][start];
				image[end-i][start] = image[end][end-i];
				image[end][end-i] = image[start + i][end];
				image[start + i][end] = temp;
			}
			start++;
		}
	}

	//Prints the matrix in a pleasing format.
	public static void printImage(int[][] image)
	{
		int n = image[0].length;
		System.out.println();
		for(int i = 0; i < n; i++) 
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(image[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}