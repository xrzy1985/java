import java.io.*;

public class Tutorial32
{
	public static void main(String[] args)
	{
			// Create a customers array of type Customer and set it equal to a method
			// we haven't created the method yet, but we will define it below
		Customer[] customers = getCustomers();

			// used to write characters to a file
			// You need to define the createFile method yourself
			// Create a folder on your desktop called Java, open it, and get the path
			// in the search bar from the folder. It should look something like
			// C:\Users\ userName\Desktop\Java -> use the foward slashes instead, and drop the HD
			// /Users/userName/Desktop/Java
		PrintWriter custOutput = createFile("/Users/James/Desktop/Java/customers.txt");

			// This will cycle through the people in customers
		for(Customer person : customers)
		{
				// method that will be defined to create a customer easily
			createCustomers(person, custOutput);
		}

			// Closes the connection to the PrintWriter
		custOutput.close();

			// A method we will create to print out the information on screen from file
		getFileInfo();

	}

		// A Customer class to define all the individual customer fields
	private static class Customer
	{
			// it is good practice to create fields as abstract as possible
			// Less is more when it comes to programming, with the exception
			// of comments. Comments are valuable beyond measure
		public String firstName, lastName;

			// An integer value to hold the customer's age
		public int custAge;

			// This is a constructor that will be called every time a customer
			// object is created. The customer object will have the information
			// passed to the Customer constructor.
		public Customer(String firstName, String lastName, int custAge)
		{
				// the this key word assigns the information passed to the current object
				// being created.
			this.firstName = firstName;
			this.lastName = lastName;
			this.custAge = custAge;
		}
	}

			// This method will create the array of Customer objects
		private static Customer[] getCustomers()
		{
			Customer[] customers = new Customer[5];
			customers[0] = new Customer("James", "Patterson", 31);
			customers[1] = new Customer("Jill", "Hardin", 52);
			customers[2] = new Customer("Kyle", "Earley", 32);
			customers[3] = new Customer("Johnathon", "Miles", 32);
			customers[4] = new Customer("Daniel", "Rogers", 32);

			return customers;
		}

			// Used to create and write to files on the system
		private static PrintWriter createFile(String fileName)
		{
				// Must be encased within a try/catch block
				// IOException could occur, and must be caught
			try
			{
					// Create a File object that will let you read write and delete
					// files on the hard drive
				File listOfNames = new File(fileName);

					// FileWriter is used to write streams of chars to a file
					// BufferedWriter renders a lot of chars at once, to speed
					// up the process, and PrintWriter is used to write the chars
					// to the actual file we created

				PrintWriter infoToWrite = new PrintWriter(
												new BufferedWriter(
													new FileWriter(listOfNames)));
				return infoToWrite;
			}	// Must be caught when using FileWriter
			catch(IOException e)
			{
				System.out.println("An I/O Error Occurred.");

					// Closes the java program
				System.exit(0);
			}
			return null;
		}

			// Creates a string with customer information, and writes the info to a file
		private static void createCustomers(Customer customer, PrintWriter custOutput)
		{
				// Create the String with the customer info that is a data type String
			String custInfo = customer.firstName + " " + customer.lastName + " ";

				// to add the age, you must parse the data to String data type
			custInfo += Integer.toString(customer.custAge);

				// Writes the string to the actual file
				// println is used for so much more than print to the console
			custOutput.println(custInfo);
		}

			// This method will read the information from the file
			// and write it to the screen/console for us
		private static void getFileInfo()
		{
			System.out.println("Info written to the file\n");

			File listOfNames = new File("/Users/James/Desktop/Java/customers.txt");

			try
			{
					// BufferedReader speeds up the process of reading characters
					// FileReader going to read each individual character
				BufferedReader getInfo = new BufferedReader(new FileReader(listOfNames));

					// Create a custInfo String that will hold the value from
					// each line being read in
					// Only reads one line at a time
					// last thing sent to read line is null
				String custInfo = getInfo.readLine();

					// The following will just print the info out
					// I'm going to comment this out
				/*
				while(custInfo != null)
				{
					System.out.println(custInfo);
					custInfo = getInfo.readLine();
				}
				*/

				while(custInfo != null)
				{
						// This will break lines into pieces
					String[] individualCustData = custInfo.split(" ");

						// Convert the age String into an integer with parseInt
						// 0: firstName	1: lastName	2: age
					int custAge = Integer.parseInt(individualCustData[2]);

						// Print out the data
					System.out.println("Customer: " + individualCustData[0] + " " +
						individualCustData[1] + " is " + custAge + " years old.\n");

						// This ensures that java will grab any additional lines
						// in the file we are trying to access
						// returns null when the end of file has been reached
					custInfo = getInfo.readLine();
				}

			}
			catch(FileNotFoundException e)
			{
				System.out.println("Couldn't find the file. ");
				System.exit(0);
			}
			catch(IOException e)
			{
				System.out.println("An I/O Exception has occurred");
				System.exit(0);
			}
		}


}
