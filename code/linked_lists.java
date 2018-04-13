import java.util.Arrays;
import java.util.LinkedList;

// Linked lists are great, but they have pros and cons
// LLs are great if you need to add or delete information
// within the lists, but they are not great with indexing.

public class tutorial12
{

	public static void main(String[] args)
	{
		// Create the object for the linked list
		LinkedList linkedList1 = new LinkedList();

		// Create the object with a specific data type
		LinkedList<String> names = new LinkedList<String>();

		// add a few names to the linked list
		names.add("James Patterson");
		names.add("Jill Hardin");
		names.add("Brian Hartman");

		// Enhanced for loop to loop through the names
		int i = 0;
		for(String name : names)
		{
			System.out.println(i + ": " + name); i++;
		}	System.out.println();

		//
		// This will add the value to the end of the list
		names.addLast("Nathan Miller");

		i = 0;
		for(String name : names)
		{
			System.out.println(i + ": " + name); i++;
		}	System.out.println();

		// This will add the name to the first of the list
		names.addFirst("Josh Bain");

		i = 0;
		for(String name : names)
		{
			System.out.println(i + ": " + name); i++;
		}	System.out.println();

		// Adding to a specific location is easy
		// just use add(index, value)
		names.add(3, "Danielle Walker");

		i = 0;
		for(String name : names)
		{
			System.out.println(i + ": " + name); i++;
		}	System.out.println();

		// This is how you replace a value at a specific index
		names.set(0, "Paul Newman");

		i = 0;
		for(String name : names)
		{
			System.out.println(i + ": " + name); i++;
		}	System.out.println();

		// This is how to remove from a linked list
		names.remove(0);
		// Remove by index or by value
		names.remove("Danielle Walker");

		i = 0;
		for(String name : names)
		{
			System.out.println(i + ": " + name); i++;
		}	System.out.println();

		// Additional way to retrieve the values
		System.out.println("First index: " + names.get(1));

		System.out.println();

		// Print out the first value
		System.out.println("First index: " + names.getFirst());

		System.out.println();

		// Print out the second value
		System.out.println("First index: " + names.getLast());

		System.out.println();

		// This is how to copy a data type specific linked list
		// LL<dataType> LLName = new LL<dataType>(originalLL)
		LinkedList<String> names2 = new LinkedList<String>(names);

		// This will print the values, but it is a bit ugly
		System.out.println("Copy of names LL: " + names2);

		System.out.println();

		// You can use an if statement to see if a value is
		// located in the linked list
		if(names.contains("James Patterson"))
		{
			System.out.println("Is in da house");
		}	System.out.println();

		// You can check to see if two linked lists are the same
		if(names.containsAll(names2))
		{
			System.out.println("Yes, they are");
		}	System.out.println();

		// This is will return "No" but if you do not
		// code the else statement in, the response
		// will be nothing.
		names.remove(3);

		if(names.containsAll(names2))
		{
			System.out.println("Yes, they are");
		}else
		{
			System.out.println("No, they are not");
		}	System.out.println();

		// To search the linked list by name
		// You need to put the whole value at the index
		// If you just put James or james patterson
		// the function will return nothing
		int nameOf = names.indexOf("James Patterson");

		System.out.println(nameOf);

		System.out.println();

		// If you would like to check to see if a list is empty
		// isEmpty is a method that returns a boolean
		System.out.println("Is the list empty: " + names.isEmpty());
		System.out.println();

		// If you push a value on the linked list
		// You are adding the value to the beginning
		names2.push("Peter Griffin");

		i = 0;
		for(String name : names2)
		{
			System.out.println(i + ": " + name); i++;
		}	System.out.println();

		// You can pop an object off the linked list
		// You are removing the first value of the list
		names2.pop();

		i = 0;
		for(String name : names2)
		{
			System.out.println(i + ": " + name); i++;
		}	System.out.println();

		// To create an array from a linked list
		Object [] namesArray = new Object[5];

		namesArray = names.toArray();

		System.out.println(Arrays.toString(namesArray));

		// If you need to clear the entire Linked List
		names.clear();

		System.out.println();
		System.out.println("Is the list empty: " + names.isEmpty());
		System.out.println();
	}

}
