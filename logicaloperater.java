//Demonstarte logical Oprater
import java.util.Scanner;

public class main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter first number");
    int a = sc.nextInt();

    System.out.print("Enter second number");
    int b = sc.nextInt();

    System.out.println("(a>0&&b>0):" + (a>0&&b>0));
    System.out.println("(a>0||b>0):" + (a>0||b>0));
    System.out.println("!(a>0):" + !(a>0));
    sc.close();
  }
}

Output:
Enter first number 12
Enter second number 23
(a>0&&b>0):true
(a>0||b>0):true
!(a>0):false
