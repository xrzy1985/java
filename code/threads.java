public class GetTheMail implements Runnable
{

	private int startTime;

	public GetTheMail(int startTime)
	{
		this.startTime = startTime;
	}

	public void run()
	{
		try
		{
			Thread.sleep(startTime * 1000);
		}
		catch(InterruptedException e)
		{
			System.out.println("There was an error, mate.");
		}

		System.out.println("Checking the Mail, mate");
	}

}

//-------------------------------------------------------------
//-------------------------------------------------------------
import java.util.*;
import java.text.DateFormat;

/*
 * This tutorial will cover Threads
 *
 * 	threads just run parallel to each other
 * 	they will execute, run, print, etc at the same time
 * 	or in a specific order if you wish them to.
 *
 * 	Threads are responsible for a computer being able to run a program,
 * 	run firefox, check email, and more at the same time concurrently.
 * 	The programs are each running on a different thread of the OS.
 */

public class GetTime extends Thread
{
		// Since we extend Thread, we must have the methods from Thread we want to use
		// inside the class that is extending the Thread class.

	public void run()
	{
		Date rightNow;
		Locale currentLocale;
		DateFormat timeFormatter;
		DateFormat dateFormatter;
		String timeOutput;
		String dateOutput;

		for (int i = 1; i <= 20; i++)
		{
			rightNow = new Date();

			currentLocale = new Locale("en");

				// Try using short, medium, long, or full instead of Default
			timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);

			dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);

			// Converts the time into Strings for formatting purposes
			timeOutput = timeFormatter.format(rightNow);

			dateOutput = dateFormatter.format(rightNow);

			System.out.println("==========================");

			System.out.println();

			System.out.println(timeOutput);

			System.out.println();

			System.out.println(dateOutput);

			System.out.println();

			System.out.println("==========================");

			try
			{
					// 1000 = 1 second
					// 2000 = 2 second
					// 10000 = 10 seconds
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				System.out.println("There was an error, mate.");
			}

		}

	}

	public static void main(String[] args)
	{

	}

}
//-------------------------------------------------------------
//-------------------------------------------------------------
public class Tutorial17_2
{

	public static void main(String[] args)
	{
			// Need to create a thread object
		Thread getTime = new GetTime();

			// Create getMail Runnable object
		Runnable getMail = new GetTheMail(10);

			// To create another Runnable object
		Runnable getMail2 = new GetTheMail(20);

		// This is how to execute the getTime thread object
		getTime.start();

		new Thread(getMail).start();

		new Thread(getMail2).start();

	}

}
