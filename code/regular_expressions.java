/*
 * This tutorial will focus on regular expressions, or RegEx
 */
// Import the proper libraries
import java.util.regex.*;

public class Tutorial19
{

	public static void main(String[] args)
	{

			// First, lets create two strings with different types of information
		String myString = " James Patterson GA 12345 MI (555)555-1111 example@yahoo.com 555-555-1515 555 555-1511 5555551122 ";

			// Second, create another bologna string
		String oddString = " 1Z aab **** *** {{{ {{ { ";
			/*
			* Anything being searched for by a regular expression will be in []
			* [A-Z] will search for all capital letters between A and Z
			* [a-z] will search for all lower case letters between a and z
			* [0-9] search for numbers between 0 and 9
			* [^A-G] will search for characters NOT A-G
			* 	-----This is different in Java than any other language
			* \\s will search for white space
			* 		this is very sensitive
			* 		\\s\\s will search for 2 white spaces before or after the characters
			* \\S will search for NOT white space
			* \\w{2,20} will match any Strings between 2 and 20 characters
			* \\d will search for digits
			* \\D will search for anything that isnt a digit
			* {5} search for something that occurred a specific amount of times, say 5
			*
			* {n,m} will search for [minimum, maximum}			*
			*
			* To search for a word that is between 5 and 20 characters in length
			* 	[A-Za-z]{5,20}
			*
			*/

			// This will return James, GA, and MI
			// because James has a single white space before and after
			// while going through the string, Patterson does not appear to have white
			// space before it due to James , and this is why Patterson does not
			// show up. If you would use \\S at the end, the results would be different
		regexChecker("\\s[A-Za-z]{2,20}\\s", myString);

		System.out.println("==============================");

			// Looking for a word between 2 and 20 characters
			// with either upper/lower case letters and not white space following it

		regexChecker("\\s[A-Za-z]{2,20}\\S", myString);

		System.out.println("==============================");

			//

		regexChecker("\\w[A-Za-z]{2,20}", myString);

		System.out.println("==============================");

			// To search for a 5 digit code with white space before and after it

		regexChecker("\\s\\d{5}\\s", myString);

		System.out.println("==============================");

			// search for combinations of
			/*
			 * AK, AL, AR, AZ
			 * CA, C0, CT
			 * G0, GA, GR
			 * ME, MW, MR, MI
			 */
		regexChecker("A[KLRZ] | C[A0T] | G[0AR] | M[EWRI]", myString);

		System.out.println("==============================");

			// Want to search for something with a min but NOT a max
		regexChecker("\\d{5,}", myString);

			// When you use a + sign in a regular expression
			// it means whatever follows the + sign must occur
			// One or More times

		System.out.println("==============================");

		// regexChecker();

			// Things that need to be backslashed twice before using them
			/*
			 * a .
			 * a ^
			 * a *
			 * a +, ?, [], \, |, ()
			 */

			// How to find characters with a minimum of x, x = 2 here
		regexChecker("(\\{{2,})", oddString);

		System.out.println("==============================");

			// Find two characters that has 1 or more of the same character following
		regexChecker("(\\{+)", oddString);

		System.out.println("==============================");

			// If you want to find anything, with a certain number involved
			// it definitely matches white spaces
		regexChecker(".{3}", oddString);

			// Search for any kind of word

		System.out.println("==============================");

		regexChecker("\\w [A-Za-z0-9_]", oddString);

			// Search for something that happens 0 or more times
		System.out.println("==============================");

		regexChecker("\\w*", oddString);

			// email addresses??
		System.out.println("==============================");

			// This will search for all combination of letters upper/lower and numbers
			// between 0-9, followed by a manditory @ then followed by any combination
			// of those same letters, followed by a manditory . with a 2 - 4 letter
			// combination following
		regexChecker("[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}", myString);

		System.out.println("==============================");

		regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[A-Za-z0-9]{7})", myString);

		/*
		 * 	([0-9]( |-)?)?    	This is saying we are looking for a combination of 0-9
		 * 						followed by a white space or a -, but that might not
		 * 						exist at all and none of it might be present. Thats what
		 * 						the ? is about, it represents if something is or isn't there
		 *
		 * 	(\\(?[0-9]{3}\\)?	This is looking for a ( that might or might not exist,
		 * 						followed by having the digits 0-9 inside , which will be
		 * 						only 3 digits, followed by a ) that might or might not exist
		 *
		 * 	|[0-9]{3})			OR the digits 0-9 in a combination of 3
		 *
		 * 	( |-)?([0-9]{3}( |-)?	Followed by a space or - that might or might not exist
		 * 							followed by 3 digit number 0-9 that is before a white
		 * 							space or - which might not exist at all
		 *
		 * 	[0-9]{4}			Followed by a 4 digit combination of numbers 0-9
		 *
		 * 	|[A-Za-z0-9]{7})	OR a 7 digit combination of upper/lower case letters and
		 * 						the digits 0-9.
		 */

		System.out.println("==============================");

		regexReplace(myString);

	}




	public static void regexChecker(String theRegex, String str2Check)
	{
		Pattern checkRegex = Pattern.compile(theRegex);

		Matcher regexMatcher = checkRegex.matcher(str2Check);

		while(regexMatcher.find())
		{
			if(regexMatcher.group().length() != 0)
			{
				System.out.println(regexMatcher.group().trim());
			}

			System.out.println("Starting index: " + regexMatcher.start());


			System.out.println("Ending index: " + regexMatcher.end());

		}


	}

	public static void regexReplace(String str2Replace)
	{
		Pattern replace = Pattern.compile("\\s+");

		Matcher regexMatcher = replace.matcher(str2Replace.trim());

		System.out.println(regexMatcher.replaceAll(", "));


	}
}
