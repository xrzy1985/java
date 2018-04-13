import java.util.Arrays;

public class tutorial9
{

	public static void main(String[] args)
	{
		// An array is an object
		// Once you declare how large the array is
		// You can not change it due to being fixed size
		// Arrays are storage with each cell assigned an index
		// Arrays can only hold one type of data type

		// dataType[] arrayName;
		// arrayName = new dataType[size];
		// Initialize the array then declare the size
		int[] intArray;
		intArray = new int[7];

		// or you can do it all in one line
		int[] integerArray = new int[10];

		// Arrays start indexing at 0
		// So, If your array is size 7
		// the array index will be 0, 1, 2, 3, 4, 5, 6
		integerArray[0] = 1;

		// This is how to create a string array
		String[] stringArray = {"Hello World","This is James"};

		System.out.println(Arrays.toString(stringArray));

		// The following code will help you visualize what an array
		// Looks like
		// The loop will add actual int values to our array
		// until the end of the arrays length is reached
		for(int i = 0; i < intArray.length; i++)
		{
			intArray[i] = i;
		}

		int a = 1;
		while(a <= 35){System.out.print('-');a++;}
		System.out.println();

		// This will loop through the array and
		// print out to the screen what is inside
		// each index of the array
		for(int j = 0; j < intArray.length; j++)
		{
			System.out.print("|" + j + " ");
		}

		a = 1;
		System.out.println("|");
		while(a <= 35){System.out.print('-');a++;}

		System.out.println();

		// Arrays can be multidimensional arrays
		// The array will hold two sets of information
		// [a][b] are both storage for the array
		/*	|a,b |
		 * 	|0,0 |0,1 |0,2 |0,3 |0,4 |
			|1,0 |1,1 |1,2 |1,3 |1,4 |
			|2,0 |2,1 |2,2 |2,3 |2,4 |
			|3,0 |3,1 |3,2 |3,3 |3,4 |
			|4,0 |4,1 |4,2 |4,3 |4,4 |
		 */

		String[][] multiArray = new String[5][5];

		a = 1;
		while(a <= 35){System.out.print('-');a++;}
		System.out.println();

		for(int i = 0; i < multiArray.length; i++)
		{
			for(int j = 0; j < multiArray[i].length; j++)
			{
				multiArray[i][j] = i + "," + j;
			}
		}

		for(int i = 0; i < multiArray.length; i++)
		{
			for(int j = 0; j < multiArray[i].length; j++)
			{
				System.out.print("|" + multiArray[i][j] + " ");
			}

			System.out.println("|");
		}

		a = 1;
		while(a <= 35){System.out.print('-');a++;}
		System.out.println();

		// You can use the "enhanced" for loop
		// to print out values within an array

		for(int row : intArray)
		{
			System.out.print(row);
		}
		System.out.println("\n");

		// The enhanced for loop can be used with
		// the multidimensional array
		// for(dataType[] variableForRow : arrayName)

		for(String[] rows : multiArray)
		{
			// for(dataType variableForColumn : arrayName)
			for(String column : rows)
			{
				System.out.print("|" + column + " ");
			}

			System.out.println("|");
		}

		System.out.println();

		// You can use the java arrays library to make a copy
		// of an array with the following code
		// dataType[] arrayName = Arrays.copyOf(originalName, newSize);

		int[] intCopy = Arrays.copyOf(intArray, 6);

		for(int row : intCopy)
		{
			System.out.print(row);
		}
		System.out.println("\n");

		// The following will copy the original array within a
		// specific set range. The numbers will be copied up
		// to the index before the end.
		// so [0,1,2,3,4,5] with a range of [1,5]
		// will yield [1,2,3,4]

		int[] intCopy2 = Arrays.copyOfRange(intArray, 1, 5);

		// Then use the arrays library to print out the array
		// using the toString method

		System.out.println(Arrays.toString(intCopy2));

		System.out.println();

		// If for some reason you have to fill an array
		// with all of the same value
		// fill is your guy

		int [] allTwos = new int [100];

		Arrays.fill(allTwos, 2);

		System.out.println(Arrays.toString(allTwos));

		System.out.println();

		// Filling a game board with all one character
		// is something that can be done easily using
		// fill

		// create a multidimensional char array 5x5
		char [][] boardGame = new char [5][5];

		// create for loop to fill array with char *
		for(char[] row : boardGame)
		{
			Arrays.fill(row, '*');
		}

		// use for loop to print out results
		for(char[] row : boardGame)
		{
			// for(dataType variableForColumn : arrayName)
			for(char column : row)
			{
				System.out.print("|" + column);
			}

			System.out.println("|");
		}
		System.out.println();

		// You can sort an array using the built in sorting
		// algorithms inside the arrays library

		// Create new array with 10 indexes
		int[] intSort = new int[10];

		// Create for loop to generate values for the index of i
		for(int i = 0; i<intSort.length; i++)
		{
			// Fill array with Math.random() * number
			intSort[i] = (int) (Math.random() * 11);
		}

		System.out.println("\nBefore Sort\n");

		System.out.println(Arrays.toString(intSort));

		// Call to Arrays.sort to sort the array of random numbers
		Arrays.sort(intSort);

		System.out.println("\nAfter Sort\n");

		System.out.println(Arrays.toString(intSort));

		// If you need to find a value inside of an array
		// use the binarySearch method
		// This will return a negative value if the value
		// you're searching for is not found, but will return
		// the index location of the value if found. The
		// index will be the first location where the value
		// is found, and it might be in multiple places

		int whereIsTen = Arrays.binarySearch(intSort, 10);

		System.out.println(whereIsTen);

	}

}
