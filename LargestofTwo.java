import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a 1st  number: ");
        int num = sc.nextInt();
        System.out.print("Enter a 2nd number: ");
        int num1 = sc.nextInt();
        

        if (num > num1){
            System.out.println(num +" is largest Value.");
        } else {
            System.out.println(num1 + " is largest Value.");
        }
    }
}


Output:
Enter a 1st  number: 11
Enter a 2nd number: 12
12 is largest Value.
