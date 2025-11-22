//Finding the year is leap  or not.
import java.util.Scanner;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the year:");
    int i = sc.nextInt();

  if(( i % 4 == 0 && i % 100 != 0 )||( i % 400 == 0 )){
    System.out.println( i + " year is leap year.");
  }else{
    System.out.println( i + " year is not leap year.");
    }
  }
}

Output:

Enter the year:
2024
2024 year is a leap year.
