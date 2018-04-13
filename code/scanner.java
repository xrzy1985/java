import java.util.Scanner;

public class tutorial2
{
  // here we are creating a scanner object named userInput
	static Scanner userInput = new Scanner(System.in);

  // start our main function
	public static void main (String[]args)
	{

		System.out.print("Your name is: ");

    // if the user enters a name
		if (userInput.hasNext())
		{
      // the string variable name will hold that information and then print
			String name = userInput.nextLine();
			System.out.println("\nThe name you entered is: " + name);
		}

		System.out.print("===========================================\n");

		System.out.print("Your age is: ");

		if (userInput.hasNextInt())
		{
			int age = userInput.nextInt();

			System.out.println("\nThe age you entered is: " + age);

			int doubleAge = age + age;

			System.out.println("Double your age: " + doubleAge);

			System.out.println("Minus 2 from your age: " + (age-2));

			System.out.println("Square your age: " + (age*age));

			System.out.println("Double your age then divide by 4: " + ((age*4)/2));

			System.out.println("Modolus your age: " + (age % 2));

			age = age - 10;

			System.out.println(age);

			age += 10;

			System.out.println(age);

			age -= 10;

			System.out.println(age);

			age--;

			System.out.println(age);

			age++;

			System.out.println(age);

			int absAge = Math.abs(age);

			System.out.println(absAge);

			int temp = 10;

			int whichIsBigger = Math.max(age,  temp);

			System.out.println(whichIsBigger);

			int whichIsSmaller = Math.min(age, temp);

			System.out.println(whichIsSmaller);

			double randomNumber = (double) (Math.random() * 3.14);

			System.out.println("Random Double: " + randomNumber);
		}
		else
		{
			System.out.println("Please, enter a proper response, mate.");
		}



	}

}
