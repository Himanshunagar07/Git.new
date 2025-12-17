//In this code user input node value of tree and output say its properties like full Binary tree, complete Binary tree, balanced Binary tree, perfect Binary tree.
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {

    Node root;

    // ---------- Create Tree using User Input ----------
    void createTree() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter root node value: ");
        int data = sc.nextInt();

        if (data == -1) {
            root = null;
            return;
        }

        root = new Node(data);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();

            System.out.print("Enter left child of " + current.data + " : ");
            int leftData = sc.nextInt();
            if (leftData != -1) {
                current.left = new Node(leftData);
                q.add(current.left);
            }

            System.out.print("Enter right child of " + current.data + " : ");
            int rightData = sc.nextInt();
            if (rightData != -1) {
                current.right = new Node(rightData);
                q.add(current.right);
            }
        }
    }

    // ---------- Full (Proper) Binary Tree ----------
    boolean isFullTree(Node node) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        if (node.left != null && node.right != null)
            return isFullTree(node.left) && isFullTree(node.right);

        return false;
    }

    // ---------- Complete Binary Tree ----------
    boolean isCompleteTree(Node root) {
        if (root == null)
            return true;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left != null) {
                if (flag) return false;
                q.add(temp.left);
            } else {
                flag = true;
            }

            if (temp.right != null) {
                if (flag) return false;
                q.add(temp.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

    // ---------- Height ----------
    int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // ---------- Perfect Binary Tree ----------
    boolean isPerfectTree(Node node, int depth, int level) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return depth == level + 1;

        if (node.left == null || node.right == null)
            return false;

        return isPerfectTree(node.left, depth, level + 1) &&
               isPerfectTree(node.right, depth, level + 1);
    }

    // ---------- Balanced Binary Tree ----------
    boolean isBalanced(Node node) {
        if (node == null)
            return true;

        int lh = height(node.left);
        int rh = height(node.right);

        return Math.abs(lh - rh) <= 1 &&
               isBalanced(node.left) &&
               isBalanced(node.right);
    }
}

public class main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.createTree();

        System.out.println("\n--- Tree Properties ---");
        System.out.println("Full Binary Tree: " +
                tree.isFullTree(tree.root));

        System.out.println("Complete Binary Tree: " +
                tree.isCompleteTree(tree.root));

        int depth = tree.height(tree.root);
        System.out.println("Perfect Binary Tree: " +
                tree.isPerfectTree(tree.root, depth, 0));

        System.out.println("Balanced Binary Tree: " +
                tree.isBalanced(tree.root));
    }
}
Output:
Enter root node value: 8
Enter left child of 8 : 3
Enter right child of 8 : 10
Enter left child of 3 : 2
Enter right child of 3 : 4
Enter left child of 10 : 9
Enter right child of 10 : 11
Enter left child of 2 : -1
Enter right child of 2 : -1
Enter left child of 4 : -1
Enter right child of 4 : -1
Enter left child of 9 : -1
Enter right child of 9 : -1
Enter left child of 11 : -1
Enter right child of 11 : -1

--- Tree Properties ---
Full Binary Tree: true
Complete Binary Tree: true
Perfect Binary Tree: true
Balanced Binary Tree: true
