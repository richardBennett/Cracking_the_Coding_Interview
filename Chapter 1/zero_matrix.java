/* Write an algorithm such that if an element in an MxN matrix is 0, the entire row and column
 * are set to 0.
 */
public class zero_matrix
{
	public static void main(String[] args)
	{
		//Initialize a matrix for testing;
		int[][] matrix = new int[5][5];
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				matrix[i][j] = 5;
			}
		}

		matrix[1][2] = 0;
		matrix[4][4] = 0;

		//Print the matrix, zero it, then print it again.
		printArray(matrix);
		System.out.println();
		zero2(matrix);
		printArray(matrix);
	}

	public static void zero(int[][] matrix)
	{
		//Matrix dimensions
		int width = matrix.length;
		int height = matrix[0].length;

		//Arrays for each row or column to hold whether it contained a zero.
		boolean[] rows = new boolean[width];
		boolean[] cols = new boolean[height];

		//Find all the zeroes in the array and update the boolean arrays accordingly
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(matrix[i][j] == 0)
				{
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		//Then for every row that contained a zero, zero that row in the matrix
		for(int i = 0; i < width; i++) {
			if(rows[i])
			{
				for(int j = 0; j < height; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		//Then for every col that contained a zero, zero that col in the matrix
		for(int i = 0; i < height; i++) {
			if(cols[i])
			{
				for(int j = 0; j < width; j++) {
					matrix[j][i] = 0;
				}
			}
		}
	}

	//Alternative method!
	public static void zero2(int[][] matrix)
	{

		boolean firstRowZero = false;
		boolean firstColZero = false;
		int width = matrix.length;
		int height = matrix[0].length;

		//First check if the first row or col contain zero
		for(int i = 0; i < width; i++)
			if(matrix[0][i] == 0) firstRowZero = true;
		for(int i = 0; i < height; i++)
			if(matrix[i][0] == 0) firstColZero = true;

		//For every other position in the matrix, if it's zero make the 
		//first row and col index 0
		for(int i = 1; i < width; i++) {
			for(int j = 1; j < height; j++) {
				if(matrix[i][j] == 0)
				{
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		//Then for each col in first row, if it's zero that whole col is zero
		for(int i = 0; i < width; i++) {
			if(matrix[0][i] == 0) 
			{
				for(int j = 0; j < height; j++) matrix[j][i] = 0;
			}
		}
		//Then for each row in the first col, if it's zero that whole col is zero.
		for(int i = 0; i < height; i++) {
			if(matrix[i][0] == 0)
			{
				for(int j = 0; j < width; j++) matrix[i][j] = 0;
			}
		}

		//If the first row or the first col contained a zero, then that row or col
		//should be set to Zeroes
		if(firstRowZero)
			for(int i = 0; i < width; i++) matrix[0][i] = 0;
		if(firstColZero)
			for(int i = 0; i < height; i++) matrix[i][0] = 0;
	}

	//Prints the array in a pleasing manner
	public static void printArray(int[][] matrix)
	{
		int width = matrix.length;
		int height = matrix[0].length;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}