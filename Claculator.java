//Claculator using all operator.
import java.util.Scanner;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter the 1st Value : ");
    int num1 = sc.nextInt();

    System.out.println("Enter the 2nd Value :");
    int num2 = sc.nextInt();

    System.out.println("Choose the Operator to perform( + , - , * , / ):");
    char ch = sc.next().charAt(0);

  double result;
    switch (ch){
      case '+':
        result = num1+num2;
        System.out.println("Result = "+result);
        break;
      case '-':
        result = num1 - num2;
        System.out.println("Result = "+result);
        break;
      case '*':
        result = num1*num2;
        System.out.println("Result = " + result);
        break;
      case '/':
        result = num1/num2;
        System.out.println("Result = "+ result);
        bresk;
      default:
        System.out.println("Invalid choise try again");
    }
  }
}
          
