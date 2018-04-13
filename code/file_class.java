import java.io.*;

import javax.swing.*;

public class Tutorial31  extends JFrame
{

	static String filePath, filePath2, parentDirectory;

	static File randomDir, randomFile, randomFile2;

	public static void main(String[] args)
	{
			// Create a file object inside of memory
		randomDir = new File("/Users/James/Desktop/Java/tutorial_31");

			// Create a working directory
		randomDir.mkdir();

			// create a file named random.txt
		randomFile = new File("random.txt");

			// create a file; define where the file will be saved
		randomFile2 = new File("/Users/James/Desktop/Java/tutorial_31/random2.txt");

			// The following is a required process when using the File class
		try
		{
				// create the files within the system
			randomFile.createNewFile();
			randomFile2.createNewFile();

				// the path for the files
			filePath = randomFile.getCanonicalPath();
			filePath2 = randomFile2.getCanonicalPath();
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage() + " : " + e.getStackTrace());

		}

			// The system needs to check if the file was created or exists
			// within the system before it can use any methods or calls
			// otherwise, an exception could occur or worse, failure.
		if(randomFile.exists() && randomFile2.exists())
		{
				//
			System.out.println("=============================================");
			System.out.println("Files do exist\n");
			System.out.println("File names - File 1: "
								+ randomFile.getName() + " , File 2: "
								+ randomFile2.getName() + ".\n");
			System.out.println("Files are Readable - randomFile: "
								+ randomFile.canRead() + " , randomFile2: "
								+ randomFile2.canRead() + ".\n");
			System.out.println("Files are Writable - randomFile: "
								+ randomFile.canWrite() + " , randomFile2: "
								+ randomFile2.canWrite() + ".\n");
			System.out.println("File locations - randomFile: "
								+ filePath + " , randomFile2: "
								+ filePath2 + ".\n");
			System.out.println("=============================================");

				// The following code will return a null
				// we did not define a parent directory
			System.out.println("Parent Directory: " + randomFile.getParent());

				// This will return the parent directory
				// because we did define the parent directory
			parentDirectory = randomFile2.getParent();

				//
			System.out.println("File 2 Parent Directory: " + parentDirectory + "\n");
			System.out.println("Is this a directory: " + randomDir.isDirectory() + "\n");

			System.out.println("=============================================");

				// create a String array to contain all of the files
			String[] filesInDir = randomDir.list();

			System.out.println("Files in the Random Directory\n");

				// Use the enhanced for loop
			for (String fileName : filesInDir)
			{
				System.out.println(fileName + "\n");
			}

				// You can check to see if this is a file
			System.out.println("Is this a file: " + randomFile.isFile() + "\n");

				// You can check for hidden files
			System.out.println("Is this a hidden file: " + randomFile.isHidden() + "\n");

				// Check to see when last modified
			System.out.println("Last modified: " + randomFile.lastModified() + "\n");

				// Return the actual size of a file
			System.out.println("The size of the file: " + randomFile.length() + "\n");

				// To change the name of the file
				// You will need the path
			randomFile2.renameTo(new File("/Users/James/Desktop/Java/tutorial_31/random3.txt"));

				// Print out the full path for the new file
			System.out.println("New File Full Path: " + randomFile2.toString() + "\n");

				// Print out the absolute path
			System.out.println("New File Absolute Path: " + randomFile2.getAbsolutePath() + "\n");

			new Tutorial31();

		}
		else
		{
			System.out.println("The File simply does not exist, Mate.\n");
		}

			// You can use the delete method to delete a file
		if(randomFile.delete())
		{
			System.out.println("File 1: Deleted\n");
		}

			// If you wanted to get an array of File objects from the directory
		File[] filesInDir = randomDir.listFiles();

			// Use enhanced for loop to delete all File objects present
		for (File fileN : filesInDir)
		{
			fileN.delete();
		}

			// You can only effectively remove a directory
			// if that directory is empty
		if (randomDir.delete())
		{
			System.out.println("Directory was successfully removed, mate.\n");
		}
	}

		// END OF THE MAIN FUNCTION
	public Tutorial31()
	{
			// create a file chooser at the specified location
		JFileChooser fileChooser = new JFileChooser(randomDir);

			// Opens the file chooser
		fileChooser.showOpenDialog(this);
	}
		// END OF THE CLASS
}
