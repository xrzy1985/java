import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class tutorial6
{

  // Let us get some user input
	static Scanner userInput = new Scanner(System.in);

  // start our main function
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
    // try to throw a divide by zero exception
		divideByZero(23);

		System.out.println("How old are you?");

		int age = checkAge();

		if (age != 0)
		{
			System.out.println("You are " + age + " years old");
		}

		getFile("./something.txt");
	}

  // the following will throw and catch the exception
	public static void divideByZero(int a)
	{
    // try something we know might not work
		try
		{
			System.out.println(a/0);
		}
    // catch the exception and return an error message
		catch (ArithmeticException e)
		{
			System.out.println("You cannot divide by zero");
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

    // The user might not enter an integer value
		public static int checkAge()
		{
      // try to get the int value
			try
			{
				return userInput.nextInt();
			}
      // if the user enters anything but an int
			catch (InputMismatchException e)
			{
				userInput.next();
				System.out.println("That is not a whole number. ");
				return 0;
			}
		}

		// Here we will see how to check for the filenotfound exception
		public static void getFile(String fileName) throws FileNotFoundException, IOException
		{
      // try to locate the file
			try
			{
				FileInputStream file = new FileInputStream(fileName);
			}
      // if unsuccessful, print out the following statements
			catch (FileNotFoundException e)
			{
				System.out.println("That file does not exist.");
			}
      // there was an input/output error
			catch (IOException e)
			{
				System.out.println("Unknown IO Error");
			}
      // of some unknown error has occurred
      catch(Exception e)
			{
				System.out.println("Some error has occurred.");
			}
      // a finally command will execute no matter what
			finally
			{
				System.out.println("Finally will always execute, no matter what. ");
			}
		}



}
