//Calulate remainder without usign modulus operator.
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

  System.out.print("Enter Divided:");
    int divided = input.nextInt();

  System.out.print("Enter divisor:");
    int divisor = input.nextInt();

  if(divisor == 0){
    System.out.println("Error! Divisor by zero is not allowed. ");
  }else{
    int quotient = divided/divisor;

    int remainder = divided - ( divisor + quotient);
    System.out.println("Quotient=" + quotient);
    System.out.println("Remainder = " + remainder);
  }
    input.close();
  }
}

Output:
Enter Divided:12
Enter divisor:4
Quotient=3
Remainder = 5
