import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class tutorial11
{

	public static void main(String[] args)
	{
		// Create array lists just like arrays
		ArrayList arrayListOne;

		arrayListOne = new ArrayList();

		// You can declare the arraylist all on one line
		ArrayList arrayListTwo = new ArrayList();

		// Array lists can be data type cast
		// ArrayList<dataType> arrayName = new ArrayList<dataType>();
		ArrayList<String> names = new ArrayList<String>();

		// You can add to the array list without declaring an index
		names.add("James Patterson");	// 0
		names.add("Jill Hardin");		// 1
		names.add("Steve Vai");	// 2

		// or you can declare the index and add to a specific index
		names.add(2, "Bon Jovi");	// 3

		// Loop through to see the results
		for (int i = 0; i < names.size(); i++)
		{
			System.out.println(names.get(i));
		}

		// You can replace a value inside an index using set
		names.set(2, "Jack Reacher");

		System.out.println();

		for (int i = 0; i < names.size(); i++)
		{
			System.out.println(names.get(i));
		}
		System.out.println();

		// To remove a value from a specific index
		names.remove(2);

		for (int i = 0; i < names.size(); i++)
		{
			System.out.println(names.get(i));
		}

		System.out.println();

		// You could print out the arraylist like this

		System.out.println(names);

		System.out.println();

		// You can use the enhanced for loop
		for(String row : names)
		{
			System.out.println(row);
		}

		System.out.println();

		// To use the iterator object
		Iterator eachValue = names.iterator();

		while(eachValue.hasNext())
		{
			System.out.println(eachValue.next());
		}

		System.out.println();

		// You can copy one array list to another
		ArrayList namesCopy = new ArrayList();

		namesCopy.addAll(names);

		for(Object row : namesCopy)
		{
			System.out.println(row);
		}

		System.out.println();

		// You can create a string
		// and add that string to the
		// array list dynamically

		String tupac = "Tupac Shukar";

		names.add(tupac);

		for(Object row : names)
		{
			System.out.println(row);
		}

		System.out.println();

		// You can search for a specific value inside the array list
		// if the boolean returns true, your code will execute from the
		// if statement block

		if (names.contains(tupac))
		{
			System.out.println("Tupac is in da house");
		}

		System.out.println();

		// If you need to make sure all the data is identical

		if (namesCopy.containsAll(names))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}

		System.out.println();

		// If you want to clear out the array list

		namesCopy.clear();

		if (namesCopy.isEmpty())
		{
			System.out.println("The copy of names is empty");
		}

		System.out.println();

		// This is how to create an array list with data type
		// set as object
		Object[] moreNames = new Object[4];

		moreNames = names.toArray();

		System.out.println(Arrays.toString(moreNames));

	}

}
