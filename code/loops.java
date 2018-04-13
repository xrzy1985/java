import java.util.Scanner;

public class tutorial4
{

	static Scanner uI = new Scanner(System.in);

	public static void main(String[] args)
	{

		// The following is a loop structure that will
		// start at 1 and print each value until 15 is reached
		// While loops are great for when you know the exact
		// numbers you need to stop on

		int i = 1;

		while (i <= 20)
		{
			
			if (i == 5)
			{
				i+=1;
				// Continue will just pick the loop up
				// where it left off
				continue;
			}

			System.out.println(i);
			i++;

			if((i%2) == 0)
			{
				i++;
			}

			if (i > 15)
			{
				break;
			}

		}

		System.out.println("Outside");

		double myPi = 4.0;

		double j = 3.0;

		while(j < 8001)
		{
			myPi = myPi - (4/j) + (4/(j+2));
			j += 4;
			System.out.println(myPi);

		}

		System.out.println("Real Value of Pi: " + Math.PI);

		String contYorN = "Y";

		int k = 11;

		while (contYorN.equalsIgnoreCase("y"))
		{
			System.out.println(k);
			System.out.print("Continue or Nah?");
			contYorN = uI.nextLine();
			k++;
		}

		// A for loop will loop through as many times as
		// you set the variable a for. If a = 10; the for
		// loop will do whatever is inside the loop for 10
		// times

		for (int a = 10; a >= 1; a--)
		{
			System.out.print(a);
		}

	}

}
