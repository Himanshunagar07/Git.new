import java.util.Scanner;

public class main{
    public static void main(String[]args){
        Scanner sc = new
        Scanner(System.in);
        System.out.println("Enter a character:");
        char ch = sc.next().charAt(0);
        
        int ascii = (int)ch;
        
        
        System.out.println("ASCII value of" + ch +" is: " + ascii);
    }
}

Output:
Enter a character:
B
ASCII value ofBis:66
