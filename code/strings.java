import java.util.Arrays;

public class tutorial13
{

	public static void main(String[] args)
	{
		// To create a general string
		String greeting = "I'm doing great!";

		// Use the \before a " if you need to use one inside a string
		String gotToQuote = "He said, \"I'm here\"";

		int num = 31;

		String upper = "HELLO";

		String upperLower = "hello";

		String lower = ", how are you?";

		System.out.println();

		// how to print out various strings mixed with an int value
		System.out.println(upper + lower + "\n" + greeting + num);

		System.out.println();

		// We can check if two strings are equal
		// This will return false due to it being case sensitive
		if (upper.equals(upperLower))
		{
			System.out.println("They are equal");
		}
		else
		{
			System.out.println("They are not equal");
		}

		System.out.println();

		// This will ignore case, and return true
		// it only looks at the spelling
		if (upper.equalsIgnoreCase(upperLower))
		{
			System.out.println("They are equal");
		}
		else
		{
			System.out.println("They are not equal");
		}

		System.out.println();

		String letters = "abcdef";

		String moreLetters = "ghjijkl";

		System.out.println("2nd character: " + letters.charAt(2));

		System.out.println();

		// This is how to compare two strings to each other
		// This will return false, but it will print a -6
		// If the strings are equal, a 0 will be printed
		// compareTo compares strings based on alphabetical order
		System.out.println(letters.compareTo(moreLetters));

		System.out.println();

		// If you want to find out if a string contains something
		System.out.println(letters.contains("cde"));

		System.out.println();

		// To see if a string ends a certain way
		System.out.println(letters.endsWith("ef"));

		System.out.println();

		// To find the starting index position for a char
		System.out.println(letters.indexOf("cde"));
		// You can specify the index to start searching from
		// indexOf(stringToSearchFor, indexStartingPosition)
		// lastIndexof() is the same as indexOf, except it
		// works from the end forwards

		System.out.println();

		//Find out the length of a string
		System.out.println(letters.length());

		System.out.println();

		// You can also replace letters
		System.out.println(letters.replace("abc", "xyz"));

		// The replace function does not replace the actual values
		// It only replaces the values at that moment if it is called
		System.out.println(letters);

		System.out.println();

		// You can split the string
		// You do have to provide a delimiter
		// If can be nothing, a comma, any character
		String [] strA = letters.split("");

		System.out.println(Arrays.toString(strA));

		System.out.println();

		// The sub string function is neat
		System.out.println(letters.substring(1,3));

		System.out.println();

		// To force uppercase, and you can specify index
		System.out.println(letters.toUpperCase());

		System.out.println();

		// To force lower case
		System.out.println(letters.toLowerCase());

		System.out.println();

		// To delete white space in a string
		// Trim only works at the beginning and the end
		// It will not work on the inside of the string
		String ranStr = "       Hi,        abcekasfjasjkhd";

		System.out.println(ranStr);

		System.out.println();

		System.out.println(ranStr.trim());

		System.out.println();

		// String Builder is great
		StringBuilder str1 = new StringBuilder("Hello World");

		System.out.println(str1);

		System.out.println();

		// Will add on to the stringBuilder object
		// The change is permanent
		System.out.println(str1.append(" , How are you?"));

		System.out.println();

		System.out.println(str1);

		System.out.println();

		// You can delete from starting index to end
		System.out.println(str1.delete(5, 10));

		System.out.println();

		// StringBuilder is reserving memory just for your string
		// You can find out how much that space is by
		System.out.println(str1.capacity());

		System.out.println();

		// You can check the length of a StringBuilder object
		System.out.println(str1.length());

		System.out.println();

		// You can use the trimToSize to ensure your capacity
		// reserved in memory is proportionate to your actual
		// string size
		str1.trimToSize();

		System.out.println(str1.capacity());

		System.out.println();

		StringBuilder str2 = new StringBuilder("A random Value");

		System.out.println(str2);

		// You can add onto a string
		System.out.println(str2.insert(1, "nother"));

		// To convert a StringBuilder into a String object
		String str3 = str2.toString();
	}
}
