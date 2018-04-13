public class tutorial5
{
	// Class variable
	static double myPI = 3.14159;

	static int randomNumber;

	public static void main(String[] args)
	{
		overrideNumbers(1);

		System.out.println("Global: " + myPI);

		System.out.println("The numbers 2 + 4 = " + addNumbers(2,4));

		int d = 5;

		// This is passing the value
		// It is the same as putting 5 instead of d inside the ()
		tryToChange(d);

		//This will print out the original int variable d
		System.out.println("Main d: " + d);

		System.out.println("Random Number: " + getRandomNumber());

	}
		// accessModifier static returnType methodName ()

		public static int overrideNumbers(int a)
		{
			// This is a local variable
			// This is only accessible within the method
			// it is defined
			double smallPI = 3.14;

			// By creating the myPI variable within the method
			// You are effectively overriding the global variable
			// but you do not replace the original value, only the
			// value while it is within the method
			double myPI = 3.0;

			// if you were to get rid of the double and write the code
			// myPI = myPI + 3;
			// you will replace the value for myPI
			// Not just override the value for the method

			System.out.println("Local Override: " + myPI);
			System.out.println("Local: " + smallPI);

			return a;
		}

		public static int addNumbers(int a, int b)
		{
			int c = a + b;
			return c;
		}

		public static void tryToChange(int d)
		{
			// These are local variables
			// They are not changing the original value of d
			d = d+1;
			// This will print d+1
			System.out.println("tryToChange d: " + d);

		}

		public static int getRandomNumber()
		{
			randomNumber = (int) (Math.random()*51);
			return randomNumber;
		}
}
