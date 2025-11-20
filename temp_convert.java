import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nTemperature Conversion Menu");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            double temp, result;

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    temp = sc.nextDouble();
                    result = (temp * 9 / 5) + 32;
                    System.out.println("Fahrenheit: " + result);
                    break;

                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    temp = sc.nextDouble();
                    result = (temp - 32) * 5 / 9;
                    System.out.println("Celsius: " + result);
                    break;

                case 3:
                    System.out.println("Exiting program. bye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3); // Loop until user chooses Exit
    }
}
