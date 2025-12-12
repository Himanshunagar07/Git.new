//This program allows the user to input an array size and elements, then search for a specified element within the array.
import java.util.*;

public class SearchElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, key;

        System.out.print("Enter size: ");
        n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        key = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("Element found!");
        else
            System.out.println("Element not found!");
    }
}
Output:
Enter size: 5
Enter elements:
34
78
4
5
0
Enter element to search: 78
Element found!
