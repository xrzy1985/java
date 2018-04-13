// Animals would be the super class
// because we expect to make sub classes (copies of it)
// Those copies will change in one way or another
public class Animals
{
	// private means the only class who has access to this
	// is the Animals class
	private String name = "Animal";

	// public means anyone has access to it
	public String favFood = "Food";

	// protected ensures that all subclasses of the superclass
	// is allowed to access the methods
	// final makes sure that sub classes cannot change (override)
	protected final void changeName(String newName)
	{
		// this is a reference to an object created by the
		// Animals class
		this.name = newName;
	}

	//
	protected final String getName()
	{
		return this.name;
	}

	public void eatStuff()
	{
		System.out.println("This sure is good " + favFood);
	}

	// This method will be overridden
	public void walkAround()
	{
		System.out.println(this.name + " walks toward certain doom.");
	}

	// This is a constructor
	// the constructor method is executed
	// when an object is created
	public Animals()
	{

	}

	public Animals(String name, String favFood)
	{
		this.changeName(name);
		this.favFood = favFood;
	}

}
//---------------------------------------------------------

//---------------------------------------------------------
// Dogs will inherit all of the Animals methods, fields, etc
// This is referred to as inheritance
public class Dogs extends Animals
{
	public String favToy = "Rope";

	public void playWith()
	{
		System.out.println("The Dog plays with a " + favToy + ".");
	}

	// This method will override the original walkAround method
	// It will change what is printed
	public void walkAround()
	{
		System.out.println(this.getName() + " stalks around town.");
	}

	public String getToy()
	{
		return this.favToy;
	}

	// create the standard issue constructor
	public Dogs()
	{

	}

	// create your constructor to create a Dogs object
	public Dogs(String name, String favFood, String favToy)
	{
		super(name, favFood);
		this.favToy = favToy;
	}

}

//---------------------------------------------------------

//---------------------------------------------------------
// Uses the Animals.java and Dogs.java classes

public class tutorial14
{

	public static void main(String[] args)
	{
		// First we will create a generic Animal object
		// This will use generic information from the Animals class
		Animals regAnimal = new Animals();

		// This will print out what we set to return from getName method
		System.out.println(regAnimal.getName());

		// This will print out what we set to return from favFood
		System.out.println(regAnimal.favFood);

		// This will print out the original String phrase we coded
		// This will not be overridden
		regAnimal.walkAround();

		System.out.println();

		// This will create a Dogs object named buster
		// We are defining buster's attributes
		Dogs buster = new Dogs("Buster", "Steak", "Rubber Ducky");

		// Print out the information from the buster object
		System.out.println(buster.getName());
		System.out.println(buster.favFood);
		System.out.println(buster.favToy);

		// This will print out the method defined inside
		// of the Dogs subclass, not the Animals Superclass
		buster.walkAround();

		// This will create a Dogs object using the Animals super class
		// This is okay because all "Dogs" are Animals
		// Dogs directly inherits all of the Animals methods and etc
		Animals pudge = new Dogs("Pudge", "Green Peppers", "Stuffed Bunny");

		// Below we create a method that will show polymorphism
		// The method will accept an object, which we created a Dog object
		// above called pudge
		acceptAnimals(pudge);

		// The method will get the objects name, favorite food, and
		// it will print out the return statement from the walkAround
		// method located inside the Dogs class, not the Animals class
		// This is polymorphism in action
		// Basically, Java is smart enough to distinguish between which
		// walkAround method you need to use. The object being passed to
		// acceptAnimals will be evaluated. First, java will ensure it is
		// an Animal, and then Java will figure out if it is a Dogs object
		// or not. If it wasn't , Animals walkAround would be printed, but
		// since the object is a Dogs object, the Dogs walkAround method
		// will be executed.

		System.out.println();

		// Below we will create just a Animals object
		// and pass it to acceptAnimals
		// We will see that the method will return statements from
		// the Animals super class, and not any subclasses.

		Animals pooper = new Animals("Pooper", "Bird Seed");

		acceptAnimals(pooper);

	}

	public static void acceptAnimals(Animals randomAnimal)
	{
		System.out.println();

		System.out.println(randomAnimal.getName());

		System.out.println(randomAnimal.favFood);

		System.out.println();

		randomAnimal.walkAround();

		System.out.println();

		// This will cast the randomAnimal as a Dogs object
		// This will work for any actual Dogs objects
		// but it will throw an exception for any Animals objects
		Dogs temp = (Dogs) randomAnimal;

		// You simply cannot cast a superclass object
		// as a subclass object
		// Remember, all Dogs are Animals
		// but not all Animals are Dogs
		// So, all Subclasses are SuperClasses
		// but not all Superclasses are subclasses
		System.out.println(temp.favToy);

		// You may want to cast directly
		// This will ensure you don't have to use a temporary field
		// You can just cast it directly within the println
		System.out.println( ((Dogs)randomAnimal).favToy);

		// You can check to see if an object is an instance of a class
		if ( randomAnimal instanceof Animals)
		{
			System.out.println(randomAnimal.getName() + " is an Animal.");
		}

		if ( randomAnimal instanceof Dogs)
		{
			System.out.println(randomAnimal.getName() + " is a Dog.");
		}
	}
}
