import java.util.Arrays;

// You can place multiple classes within a file
// There can only be one public class though
// The other classes must not be public
public class Monsters
{
	static char[][] battleArena = new char[10][10];

	public static void buildBattleArena()
	{	// The following code will loop through
		// the multi-dimensional array we created
		// and fill each individual spot in the
		// array with a #

		for(char[] row : battleArena)
		{
			Arrays.fill(row,  '#');
		}
	}

	public void drawArena()
	{
		int a = 1;
		// This will create the top of the board
		while(a <= 30){System.out.print('-'); a++;}
		System.out.println();
		//
		for (int i = 0; i < battleArena.length; i++)
		{
			for (int j = 0; j < battleArena.length; j++)
			{
				System.out.print("|" + battleArena[i][j] + "|");
			}
			System.out.println();
		}
		int b = 1;
		// This will create the top of the board
		while(b <= 30){System.out.print('-'); a++;}
		System.out.println();
	}

	// A defined constant String
	// a constant is defined with the final keyword
	public final String TOMBSTONE = "Here Lies the Deceased Monster";

	// Fields, or otherwise known as class variables

	private int health = 500;
	private int attack = 25;
	private int movement = 5;


	private boolean isAlive = true;

	public String monsterName = "Big Monster";
	public char namedCharacter1 = 'B';
	public int xPosition = 0;
	public int yPosition = 0;
	public static int numberOfMonsters = 0;

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
	public Monsters(int newHealth, int newAttack, int newMovement, String newName)
	{
		// this is a reference to the actual object's variables
		// this.objectFieldName = attributeFieldName
		this.health = newHealth;
		this.attack = newAttack;
		this.movement = newMovement;
		this.monsterName = newName;

		int maxXBoardSpaces = battleArena.length -1;
		int maxYBoardSpaces = battleArena[0].length -1;

		int randNumX, randNumY;

		do
		{
			randNumX = (int) (Math.random() * maxXBoardSpaces);
			randNumY = (int) (Math.random() * maxYBoardSpaces);
		}
		while (battleArena[randNumX][randNumY] != '#');

		this.xPosition = randNumX;
		this.yPosition = randNumY;

		this.namedCharacter1 = this.monsterName.charAt(0);

		battleArena[this.yPosition][this.xPosition] = this.namedCharacter1;

		numberOfMonsters++;
	}

	// Default constructor
	// The method exists and does nothing at all
	public Monsters ()
	{
		numberOfMonsters++;
	}

	public static void main(String[] args)
	{
		// The following will create a tutorial7 object
		// named James, and will print out the attack
		// attribute connected to the int attack.
		// This will work with the private variable
		// since you are still working within the
		// tutorial7 class

		Monsters James = new Monsters();

		System.out.println(James.attack);
	}

}
