// When you want to create a class where every method does not
// need to be implemented to use the abstract class
public abstract class Crashable
{

	boolean vehicleDrivable = true;

	public void youCrashed()
	{
		this.vehicleDrivable = false;
	}

	public abstract void setCarColor(String carColor);

	public abstract String getCarColor();

}
//-------------------------------------------------------------
//-------------------------------------------------------------
// Java does not allow inheritance from multiple classes
// Therefore, abstract classes and interfaces come into play
public interface Drivable
{

	// Putting fields within an interface ensures the
	// fields are basically constants. They will not change
	double PI = 3.14;

	int getWheel();

	void setWheels(int numberOfWheels);

	double getSpeed();

	void setSpeed(double speed);

}

// Interfaces are nice, concise, and tidy. They are usually short
// and to the point. They are a blueprint of what you will do with
// additional implementations. I like to go ahead and write out the
// methods here to be able to easily copy and paste into the class
// that will implement the interface. Anything created within an
// interface must be implemented within the class that is implementing
// the interface. Interfaces seem a bit odd and counter productive, but
// Java does not allow multiple inheritance. So,

/*

	public int getWheel()
	{
		return this.numberOfWheels;
	}

	public void setWheels(int numOfWheels)
	{
		this.numberOfWheels = numOfWheels;
	}

	public double getSpeed()
	{
		return this.speed;
	}

	public void setSpeed(double speed)
	{
		this.speed = speed;
	}

*/
//-------------------------------------------------------------
//-------------------------------------------------------------
public class Vehicle extends Crashable implements Drivable
{
	int numberOfWheels = 4;

	double speed = 120.00;

	String carColor = "Green";

	// First, copy and paste all of the information from the interface
	// into the class you're implementing
	// Everything defined inside of the interface is public
	// within the class though, you must put public

	public int getWheel()
	{
		return this.numberOfWheels;
	}

	public void setWheels(int numOfWheels)
	{
		this.numberOfWheels = numOfWheels;
	}

	public double getSpeed()
	{
		return this.speed;
	}

	public void setSpeed(double speed)
	{
		this.speed = speed;
	}

	// Do Not Forget your standard issue constructor

	public Vehicle()
	{

	}

	public Vehicle(int wheels, double s)
	{
		this.numberOfWheels = wheels;
		this.speed = s;
	}

	// Make sure to take abstract out of the methods here
	// it wont execute if you leave them in
	public void setCarColor(String carColor)
	{
		this.carColor = carColor;
	}

	public String getCarColor()
	{
		return this.carColor;
	}

}

//-------------------------------------------------------------
//-------------------------------------------------------------
public class tutorial15
{

	public static void main(String[] args)
	{
		Vehicle car = new Vehicle(4, 120.05);

		System.out.println("The car has a top speed of " + car.getSpeed() + " mph.");
		System.out.println("The number of wheels on the car is " + car.getWheel() + ".");

		car.setCarColor("Lime Green");

		System.out.println("The color of the car is " + car.getCarColor() + ".");

	}

}
