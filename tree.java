//take element from user make tree and convert it into inorder,postorder and preorder.
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;                   
import java.util.Arrays;    

// --- 1. TreeNode Class (Same as before) ---
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class UserDefinedBinaryTree {

    // --- Utility Function to Build the Tree from User Input (Level Order) ---
    /**
     * Builds a Binary Tree from an array of integers representing level-order input.
     * Uses '-1' (or null) to represent a missing node.
     * * @param values The array of node values.
     * @return The root of the constructed tree.
     */
    public static TreeNode buildTree(List<Integer> values) {
        if (values == null || values.isEmpty() || values.get(0) == -1) {
            return null;
        }

        // Root is the first value
        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.size()) {
            TreeNode current = queue.poll();

            // Handle Left Child
            Integer leftVal = values.get(i++);
            if (leftVal != -1) {
                current.left = new TreeNode(leftVal);
                queue.add(current.left);
            }

            // Handle Right Child
            if (i < values.size()) {
                Integer rightVal = values.get(i++);
                if (rightVal != -1) {
                    current.right = new TreeNode(rightVal);
                    queue.add(current.right);
                }
            }
        }
        return root;
    }
    
    // --- 2. Traversal Functions (Recursive, same as before) ---

    // Inorder: Left -> Root -> Right
    public void inorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }
    
    // Preorder: Root -> Left -> Right
    public void preorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }
    
    // Postorder: Left -> Right -> Root
    public void postorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);
        }
    }

    // --- Main method to handle User Input and Traversal ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("### Binary Tree Traversal ###");
        System.out.println("Enter the node values for the tree (Level Order traversal format).");
        System.out.println("Separate values with spaces. Use '-1' to represent a null/missing node.");
        System.out.println("Example: 1 2 3 4 5 -1 -1");
        System.out.print("Your input: ");
        
        String inputLine = scanner.nextLine();
        scanner.close();

        // Convert input string to List<Integer>
        List<Integer> values = new ArrayList<>();
        try {
            String[] parts = inputLine.split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    values.add(Integer.parseInt(part));
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("\nInvalid input format. Please enter only integers and spaces.");
            return;
        }

        // Build the Tree
        TreeNode root = buildTree(values);
        
        if (root == null) {
            System.out.println("\nTree is empty. Cannot perform traversal.");
            return;
        }

        UserDefinedBinaryTree tree = new UserDefinedBinaryTree();
        
        // --- Perform and Print Traversals ---
        System.out.println("\n--- Traversal Results ---");

        List<Integer> inorderResult = new ArrayList<>();
        tree.inorder(root, inorderResult);
        System.out.println("Inorder (Left -> Root -> Right):  " + inorderResult);

        List<Integer> preorderResult = new ArrayList<>();
        tree.preorder(root, preorderResult);
        System.out.println("Preorder (Root -> Left -> Right): " + preorderResult);

        List<Integer> postorderResult = new ArrayList<>();
        tree.postorder(root, postorderResult);
        System.out.println("Postorder (Left -> Right -> Root): " + postorderResult);
    }
}
