import java.io.*;

public class Tutorial33
{

	public static void main(String[] args)
	{
			// Let us create an array with type Customer
			// The array will be set equal to a method
			// which will populate our customers array with customers
		Customer[] customers = getCustomers();

			// A DataOutputStream will allow the user to print primitive
			// data types to a specific file
		DataOutputStream custOutput = createFile("/Users/James/Desktop/Java/customers2.dat");

			// The enhanced for loop will help cycle through all of the customers in the
			// customer array
		for(Customer person : customers)
		{
			createCustomers(person, custOutput);
		}

			// Next we need to definitely close the connection to the data stream
		try
		{
			custOutput.close();
		}
		catch(IOException e)
		{
			System.out.println("An I/O Error Occurred.");

			System.exit(0);
		}

			// This method will get the primitive data on file
			// and display it on the console for the user
		getFileInfo();
	}

		// This user created class will define the fields for the customers
	private static class Customer
	{
		public String customerName;
		public int customerAge;
		public double customerDebt;
		public boolean oweMoney;
		public char customerGender;

			// Create the constructor for when a customer is made
		public Customer(String customerName, int customerAge, double customerDebt, boolean oweMoney, char customerGender)
		{
			this.customerName = customerName;
			this.customerAge = customerAge;
			this.customerDebt = customerDebt;
			this.oweMoney = oweMoney;
			this.customerGender = customerGender;
		}
	}

		// We need to create an array of Customer objects
	private static Customer[] getCustomers()
	{
			// Create the actual array with 5 indexes
		Customer[] customers = new Customer[5];

		customers[0] = new Customer("James Patterson", 31, 1.25, true, 'M');
		customers[1] = new Customer("Jill Hardin", 52, 2.25, true, 'F');
		customers[2] = new Customer("Earl Rittenhouse", 78, 0, false, 'M');
		customers[3] = new Customer("Brian Anderson", 35, 3.25, true, 'M');
		customers[4] = new Customer("Japhia L", 27, 5.25, true, 'F');

			// we need to return the array
		return customers;
	}

		// Now we need to create the actual file
		// and create the DataOutputStream that will write to the actual file
	private static DataOutputStream createFile(String fileName)
	{
		try
		{
				// You must create a File object that will allow you to work with files
				// there is no difference between File for characters or binary stream
				// writing/reading
			File listOfNames = new File(fileName);

				/* FileOutStream is used to write streams of data to a file
				 * 		FileOutStream(fileName, true) will append to the file
				 * 		FileOutStream(fileName, false) will create a new file
				 *
				 * BufferedOutputStream will gather all of the data at once
				 * 		and write to the file for quicker processing
				 *
				 * DataOutputStream is only used to write primitive data to the file				 *
				 */
			DataOutputStream infoToWrite = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(listOfNames)));

				// You will want to return the actual DataOutputStream file
			return infoToWrite;
		}

			// This needs to be caught when using a FileOutputStream
		catch(IOException e)
		{
			System.out.println("An I/O Exception has occurred");
			System.exit(0);
		}
		return null;
	}


		// This method will create a String, and write the string to a file predefined
	private static void createCustomers(Customer customer, DataOutputStream custOutput)
	{
		try
		{
				// first, try to write the primitive data to the file
			custOutput.writeUTF(customer.customerName);

				// write the integer value
			custOutput.writeInt(customer.customerAge);

				// write the debt
			custOutput.writeDouble(customer.customerDebt);

				// write the boolean value for the debt
			custOutput.writeBoolean(customer.oweMoney);

				// write the character associated with gender
			custOutput.writeChar(customer.customerGender);

				// writeByte, writeLong, writeShort, and writeFloat
				// are all legit options that can be used when dealing
				// with data output streams

		}
		catch(IOException e)
		{
			System.out.println("An I/O Exception has occurred");
			System.exit(0);
		}
	}

		// The following method will just read the information stored on the file
		// and display it nicely for the user of the console
	private static void getFileInfo()
	{
		System.out.println("Info Written to the File");

			// Open connection to the file
		File listOfNames = new File("/Users/James/Desktop/Java/customers2.dat");

			// create a boolean to flip once the end of file has been reached
		boolean eof = false;

		/* DataInputStream
		 * 		has the methods required to read the binary data
		 *
		 * BufferedInputStream
		 * 		will gather the data all at once in blocks
		 *
		 * FileInputStream
		 * 		accesses the binary data from the file
		 */
		try
		{
			DataInputStream getInfo = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(listOfNames)));

				// Use a while loop, and pull the data until a EOFException is triggered
			while (!eof)
			{
				String customerName = getInfo.readUTF();
				int customerAge = getInfo.readInt();
				double customerDebt = getInfo.readDouble();
				boolean oweMoney = getInfo.readBoolean();
				char customerGender = getInfo.readChar();

				System.out.print(customerName + " ");
				System.out.print(customerAge + " ");
				System.out.print(customerDebt + " ");
				System.out.print(oweMoney + " ");
				System.out.print(customerGender + " ");
				System.out.print(" \n");

			}
		}
		catch(EOFException e)
		{
			eof = true;
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File could not be Found");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("An I/O Exception has occurred");
			System.exit(0);
		}
	}
}
