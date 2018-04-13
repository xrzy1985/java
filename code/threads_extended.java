import java.util.*;
import java.text.DateFormat;

	// You want to implement Runnable instead of extending the Threads class
	// Runnable will achieve the same thing, and allow the programmer to
	// extend another class. Since you can only extend one class, but you can
	// implement as many classes as you want.
public class CheckSystemTime implements Runnable
{

	public void run()
	{
			// Initialize a Date object called rightNow
		Date rightNow;

			// Initialize a Locale object called currentLocale
		Locale currentLocale;

			// Initialize a DateFormat object called timeFormatter
			// This will format the time for the user
		DateFormat timeFormatter;

			// This is the String object that we will store the formatted time in
		String timeOutput;

			// Cast rightNow as a new Date object
		rightNow = new Date();

			// Cast currentLocale as a Locale object with en for english
		currentLocale = new Locale("en");

		timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
		timeOutput = timeFormatter.format(rightNow);

		System.out.println();

		System.out.println("TIME: " + timeOutput);

	}

}
//-------------------------------------------------------------
//-------------------------------------------------------------
// Library allows for library lock down
	// It is possible that both threads might call at the same time
	// Causing a thread lock situation
	// ReentrantLock helps eliminate those issues
import java.util.concurrent.locks.ReentrantLock;

	// Implement Runnable, maybe we want to extend a class in the future
public class PerformSystemCheck implements Runnable
{
		// Initialize a String object called checkWhat
		// It will hold the value for which we wish to check
	private String checkWhat;

		// Create a new ReentrantLock object
	ReentrantLock lock = new ReentrantLock();

		//
	public PerformSystemCheck(String checkWhat)
	{
			// this is a reference to the actual object's variables
			// So...  actualObject = passedInformation
			// This is why we create the constructor
		this.checkWhat = checkWhat;
	}

		// You may use synchronized to help eliminate a thread lock situation
		// of you can just lock it down using code
	public void run()
	{
			// Use lock to lock a thread instead of synchronized
		lock.lock();

		System.out.println();

			// Tell the user it is checking for the thread that is calling it
		System.out.println("Checking " + this.checkWhat);

			// Whenever you lock a thread down, you must remember to unlock
			// Much like a database, when you access the database it must be
			// opened and closed after use.
		lock.unlock();


	}

}
//-------------------------------------------------------------
//-------------------------------------------------------------
	// import the scheduler
	// this uses predefined schedules
	// used to throw all threads into a pool and execute
import java.util.concurrent.ScheduledThreadPoolExecutor;

	// You have to import the time schedule
import static java.util.concurrent.TimeUnit.*;

public class Tutorial18
{

	public static void main(String[] args)
	{
			// Call to a method outside of the main function to run the threads
		addThreadsToPool();
	}



	public static void addThreadsToPool()
	{
			// Create the STPE object called eventPool with 5 threads
		ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);

			//	This will add a thread to the pool
			// This will check the System time immediately upon execution
			// This will check immediately and every 2 seconds following
		eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 2, SECONDS);

			// This will run a Mail check after 5 seconds and every 5 seconds following
		eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail"), 5, 5, SECONDS);

			// This will run a Calender check after 10 seconds and continue to do so
			// every 10 seconds following
		eventPool.scheduleAtFixedRate(new PerformSystemCheck("Calender"), 10, 10, SECONDS);

			// This will tell us the number of threads present
			// 1. Main with a priority of 5
			// 2,3,4 will come from the threads we created
		System.out.println("Number of Threads: " + Thread.activeCount());

			// Create an array to store the thread information in
			// Thread.activeCount() will give us the number of threads active
		Thread[] listOfThreads = new Thread[Thread.activeCount()];

			// Use a enumerator to loop through the list of threads
		Thread.enumerate(listOfThreads);

			// Use the for loop to print out the information from the threads using
			// the enumerator
			// You can set the priority of each thread by
			// threadName.setPriority();
			// 1 is the lowest, and 10 is the highest
		for(Thread i : listOfThreads)
		{
			System.out.println("========================");
			System.out.println(i.getName());
			System.out.println();
			System.out.println(i.getId());
			System.out.println(i.getPriority());
			System.out.println("========================");
		}

			// eventPool.shutdown(); will cease all of your threads from running
			// the minute this code is executed

			// We don't want our program to run indefinitely
			// Create a try and catch block to fix that issue

		try
		{
			Thread.sleep(20000);
		}
		catch(InterruptedException e)
		{

		}
	}
}
