/*
James Patterson - Java Tutorial - Hello World
Problem:
  Take 3 inputs, integer values, from the user, and
  print those 3 out on their own individual lines

1: A lot of coding
2: simplified

Finally, a look at which I would personally choose.

*/
import java.util.*;

public class Solution
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        scanner.close();

        System.out.println(a + "\n" + b + "\n" + c);

        /*
          Alternatively, the following code would be more compact, and save
          space, if space was an issue. I almost prefer my code to be written
          out with longivity. So, I can follow along with it easier. 

          Scanner scan = new Scanner(System.in);
          int a = scan.nextInt(); int b = scan.nextInt(); int c = scan.nextInt();
          System.out.println(a + "\n" + b + "\n" + c);

        */

    }
}
