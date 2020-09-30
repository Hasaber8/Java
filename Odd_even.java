  GNU nano 5.2                                                                                                    Odd_even.java                                                                                                     Modified  
import java.util.Scanner;
public class Odd_even
{
    public static void main(final String[] args)
    {
        // User Input
        Scanner num1 = new Scanner(System.in);
        System.out.print("Enter a number :- ");
        int a = num1.nextInt();
        String oe=(a%2==0)?"Even":"Odd";
        System.out.println("Number is " + oe);
        num1.close();
    }
}

