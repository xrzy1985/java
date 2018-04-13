public class tutorial7Part2
{

	// It is important to understand that you can use methods and other
	// information stored within other java files
	// You just need to understand how to access them and how to keep
	// The information private

	public static void main(String[] args)
	{
		tutorial7 Jim = new tutorial7();

		Jim.monsterName = "Jim";

		// You can not call Jim.attack
		// The attack int variable is set to private
		// You must be within the original class to access a private field
		// You must write a accessor method to access the private field
		// and the accessor method can then return the attack type to
		// the outside class

		System.out.println(Jim.monsterName + " has a " + Jim.getAttack() + "hp attack.");
	}

}
