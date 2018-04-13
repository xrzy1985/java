public class tutorial3
{

	public static void main(String[] args)
	{

		double ranNum = (double) (Math.random() * 3.145789);

		/*	Relational Operators
		 * 	>	Greater than
		 * 	< 	Less Than
		 * 	==	Equals to
		 * 	!= 	Not Equal To
		 * 	>=	Greater than or equal
		 * 	<= 	Less than or equal
		 */

		if (ranNum < 24)
		{
			System.out.println("The random number is less than 24");
		}

		System.out.println("The random number is: " + ranNum);

		if (ranNum < 1)
		{
			System.out.println("The random number is less than 1");
		}
		else if (ranNum > 2)
		{
			System.out.println("The number is greater than 2");
		}

		System.out.println("The random number is: " + ranNum);


		/*	Logical Operators
		 * 	!	Flips the value of the boolean variable
		 * 	&	Returns true if boolean values of (a,b) are both true
		 * 	&&	Returns true if boolean value of (a,b) are both true
		 * 	|	Returns true if one or both boolean values of (a,b) are true
		 * 	||
		 * 	^	Returns true if 1 is true and 1 is false from (a,b)
		 */

		if (!(false))		// if !(true) is used, its dead code
		{
			System.out.println("I turned false into true");
		}

		if (!(false) && (true))
		{
			System.out.println("Both are true");
		}

		if ((false) || (true))
		{
			System.out.println("At least one is true");
		}

		if ((false) ^ (true))
		{
			System.out.println("True vs. False");
		}

		int val1 = 1;
		int val2 = 2;

		// If val1 is > val2 the statement will return a true
		// and val1 is will assigned to the biggestValue
		// but val2 will be assigned to the biggestValue if
		// the first statement returns false, which it will

		int biggestValue = (val1 > val2) ? val1 : val2;

		System.out.println(biggestValue);

		char myGrade = 'd';

		//break; placed anywhere in a switch will automatically
		// stop evaluating and break out

		switch(myGrade)
		{
		case 'a':			// putting both the a and A will allow
		case 'A':			// the program to grab both
			System.out.println("Awesome");
			break;
		case 'b':			// One could cast all input to upper
		case 'B':			// to save some time and code
			System.out.println("Good");
			break;
		case 'c':
		case 'C':
			System.out.println("You Can Do BETTER");
			break;
		case 'd':
		case 'D':
			System.out.println("Welcome to McDonalds");
			break;
		case 'f':
		case 'F':
			System.out.println("Suck Less");
			break;
		default:
			System.out.println("Something went wrong");
			break;
		}

	}

}
