import java.util.Scanner;
class add
{
    void display(float a, float b)
    {
        float sum = a + b;
        System.out.println("sum ="+sum);
    }
}
 public class sumof2num
{
    public static void main(final String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 number:- ");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        add ob = new add();
        ob.display(a, b);
        sc.close();
    }
}