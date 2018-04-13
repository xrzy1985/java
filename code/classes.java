// You can place multiple classes within a file
// There can only be one public class though
// The other classes must not be public
public class tutorial7
{
	// A defined constant String
	public final String TOMBSTONE = "Here Lies the Deceased Monster";

	// Fields, or otherwise known as class variables

	private int health = 500;
	private int attack = 25;
	private int movement = 5;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean isAlive = true;

	public String monsterName = "Big Monster";

	// Accessor methods; they have access to the private fields
	public int getHealth()
	{
		return health;
	}

	public int getAttack()
	{
		return attack;
	}

	public int getMovement()
	{
		return movement;
	}

	public int getXPosition()
	{
		return xPosition;
	}

	public int getYPosition()
	{
		return yPosition;
	}

	public boolean getIsAlive()
	{
		return isAlive;
	}

	public void setHealth (int decreaseHealth)
	{
		health = health - decreaseHealth;

		if (health <= 0)
		{
			isAlive = false;
		}
	}

	// This method will overload the setHealth method
	// if a double data type is sent instead of an int
	// the proper thing to do is write methods for each
	// data type to be handled individually.
	// think about the variables being passed to the
	// method, not the return type
	public void setHealth(double decreaseHealth)
	{
		int decreased = (int) decreaseHealth;
		health = health - decreased;

		if (health <= 0)
		{
			isAlive = false;
		}
	}

	public void setHealth(float decreaseHealth)
	{
		int decreased = (int) decreaseHealth;
		health = health - decreased;

		if (health <= 0)
		{
			isAlive = false;
		}
	}

	public void setHealth(long decreaseHealth)
	{
		int decreased = (int) decreaseHealth;
		health = health - decreased;

		if (health <= 0)
		{
			isAlive = false;
		}
	}

	// Constructor Methods
	// must have the same name as your class
	// cannot have a return type of any kind... so no void
	// The constructor method is the first method that is
	// called once an object has been created
	public tutorial7(int newHealth, int newAttack, int newMovement)
	{
		// this is a reference to the actual object's variables
		this.health = newHealth;
		this.attack = newAttack;
		this.movement = newMovement;
	}

	// Default constructor
	// The method exists and does nothing at all
	public tutorial7 ()
	{

	}

	public static void main(String[] args)
	{
		// The following will create a tutorial7 object
		// named James, and will print out the attack
		// attribute connected to the int attack.
		// This will work with the private variable
		// since you are still working within the
		// tutorial7 class

		tutorial7 James = new tutorial7();

		System.out.println(James.attack);
	}

}
