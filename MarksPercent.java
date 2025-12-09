//Input marks of 5 subject and calculate percentage.
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int m1,m2,m3,m4,m5;

  System.out.print("Enter marks of subject 1:");
    m1 = sc.nextInt();
  System.out.print("Enter marks of subject 2:");
    m2 = sc.nextInt();
  System.out.print("Enter marks of subject 3:");
    m3 = sc.nextInt();
  System.out.print("Enter marks of subject 4:");
    m4 = sc.nextInt();
  System.out.print("Enter marks of subject 5:");
    m5 = sc.nextInt();

  int total = m1+m2+m3+m4+m5;
    double percentage= (total/5.0);

  System.out.println("Total marks:"+total);
    System.out.println("Percentage = " + percentage + "%");
  }
}
Output:
Enter marks of subject 1:70
Enter marks of subject 2:78
Enter marks of subject 3:98
Enter marks of subject 4:5
Enter marks of subject 5:76
Total marks:327
Percentage = 65.4%
