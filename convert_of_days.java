import java.util.Scanner;

public class main{
    public static void main(String[]args){
        Scanner sc= new
        Scanner(System.in);
        System.out.println("Enter total number of Days :");
        int days = sc.nextInt();
        
        int year = days/365;
        int remainingDays = days%365;
        int months = remainingDays/30;
        int finalDays = remainingDays%30;
        
        System.out.println("years: "+ year);
        System.out.println("Months: "+ months);
        System.out.println("Days: "+ finalDays);
        
    }
}

Output:
Enter total number of Days :
1200
years: 3
Months: 3
Days: 15
