//Input radius of circle and calculate area.
import java.util.Scanner;

public class Main{
  public static void main(String[] args){

  Scanner sc = new Scanner(System.in);
    System.out.print("Enter radius of the circle :");
    double r = sc.nextDouble();

  double area = Math.PI*r*r;

  System.out.println("Area of circle = "+ area);
  }
}
Output:
Enter radius of the circle :24
Area of circle = 1809.5573684677208
