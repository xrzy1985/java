//Inside java, everything is a class or an object
//public class defines all the attributes, variables,
//data structures, functions, methods, or additional functionality
//public means everyone should be able to access it

public class HelloWorld
{
	// public allows all classes to use this function
	// static only a class can call for this function, variable, etc to execute
	// the class main will be called/used by helloWorld
	// void means the function does not return any values when execution is finished
	// (String[]args) means every main function must accept an array of string objects

	// the static variable will be able to be used by the main function since its static
	// the string gamerTag holds the string of characters xRzy

	static String hackerTag = "xRzy";

	public static void main(String[] args)
	{
        System.out.println("Hello World, my name is " + hackerTag + ".");
	}

}
