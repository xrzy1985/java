// Inside java, everything is a class or an object
// public class defines all the attributes, variables,
// data structures, functions, methods, or additional functionality

// public means everyone should be able to access it

public class tutorial1
{
	// public allows all classes to use this function
	// static only a class can call for this function, variable, etc to execute
	// 		the class main will be called/used by helloWorld
	// void means the function does not return any values when execution is finished
	// (String[]args) means every main function must accept an array of string objects

	// the static variable will be able to be used by the main function since its static
	// the string gamerTag holds the string of characters xRzy
	static String gamerTag = "xRzy";

	// PIE is a double, but could be cast as a float as well
	// Double is larger and more precise than a float
	static final double PIE = 3.141529;

	public static void main (String[]args)
	{
		// The first two will print on the same line

		System.out.print("James ");
		System.out.print("Patterson; " + gamerTag + "\n");

		// The \n will drop to the next line

		System.out.println("\nHello, World!");

		System.out.println("\nPi: " +  PIE);

		// a integer variable is created and assigned the value of 21
		// this is a DECLARATION STATEMENT

		int randomInteger = 21;

		System.out.println("\nOne must be " + randomInteger + " to drink legally.");

		// another int is created using the first variable minus 3
		// this is known as a EXPRESSION STATEMENT

		int randomInteger2 = randomInteger -3;

		System.out.println("\nOne must be " + randomInteger2 + " to smoke legally.");

		// a byte data type cannot be larger than 127 and a minimum of -128
		byte bigByte = 127;

		// a short data type cannot be larger than 32767 and a minimum of -32768
		short smallShort = 32767;

		System.out.println("\n" + smallShort);

		int bigInt = 2100000000;

		System.out.println("\n" + bigInt);

		// a long must end in a L
		long bigLong = 920000000000000000L;

		System.out.println("\n" + bigLong);

		// a float variable is a long winded double variable
		// it is machine dependant
		float bigFloat = 3.14F;

		System.out.println("\n" + bigFloat);

		double bigDouble = 3.143425352365645634563456;

		System.out.println("\n" + bigDouble);

		System.out.print("\nThe largest float your machine can create is: ");

		System.out.print(Float.MAX_VALUE);

		System.out.print("\nThe largest double your machine can create is: ");

		System.out.print(Double.MAX_VALUE);

		// boolean variables are either true or false
		// they cannot hold any other type of input

		boolean tF = true;

		System.out.println("\n" + tF);

		// a char is just a character
		char badge1 = 74;		//74 is the character code for J
		char badge2 = 'P';
		char badge3 = '8';
		char badge4 = '5';
		String badge = "Tag: ";

		// Escaped Characters
		// \f \b \n \r \t \" \' \\
		// the \ must be used before hand
		// and they need to be inclosed in a ''

		char escaped = '\n';

		System.out.println(escaped + badge + badge1 + badge2 + badge3 + badge4);

		String sentence1 = escaped + "This is my first sentence, ";

		String sentence2 = "but it will  not be my last";

		System.out.println(sentence1 + sentence2);

		// To convert any of the other types to a string
		// you must cast the variable as a string

		String byteString = Byte.toString(bigByte);

		System.out.println(escaped + bigByte);

		System.out.println(escaped + byteString);

		double variable1 = 17.432;
		int doubleToInt = (int) variable1;

		System.out.println(escaped + doubleToInt);


		System.out.println("\nGoodbye, World!");

		// println will print on a new line each time
	}
}
