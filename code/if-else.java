/*
James Patterson - Java Tutorial - Else If
Problem:
  Print weird if the number is odd or when the number
  is even and between 6 and 20, print
  not weird if the number is between 2 and 5 or
  greater than 20, and you must use STDIN and STDOUT.

There are a variety of ways to solve this problem. You could use
the Java Math library, regular expressions, or just old fashioned code.

1: Old fashioned code
2: Math library
3: Regular expressions

Finally, a look at which I would personally choose.

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        String ans="";
        String a = "Weird";
        String b = "Not Weird";

        // 1: Old Fashioned Coding

        if(n%2==1){
          ans = a;
        }
        else{
            if(n >= 2 && n <= 5){
                ans = b;
            }
            else if(n >= 6 && n <= 20){
                ans = a;
            }
            else
                ans = b;
        }
        System.out.println(ans);

        /*

          2: Java's Built in Math Library

        */

        /*

          3: Regular Expressions

        */

        /*

          4: Old Fashioned Revised
              Here, we are able to shorten the amount of lines we code

                  Scanner sc=new Scanner(System.in);
                  int n=sc.nextInt();
                  String ans="";
                  String a = "Weird";
                  String b = "Not Weird";
                  if(n%2==1){
                    ans = a;
                  }
                  else{
                      if(n >= 2 && n <= 5 || n > 20){
                          ans = b;
                      }
                      else
                          ans = a;
                  }
                  System.out.println(ans);

        */


    }
}
