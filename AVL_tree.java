//In this code user input nodes value and code create AVL tree.
import java.util.*;

class AVLTree {

    class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    Node root;

    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int key) {

        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // LL
        if (balance > 1 && key < node.left.data)
            return rightRotate(node);

        // RR
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        // LR
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 🔹 Print tree clearly (left on left, right on right)
    void printTree() {
        if (root == null) return;

        int height = height(root);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        int maxWidth = (int) Math.pow(2, height);

        while (!q.isEmpty() && level < height) {
            int size = q.size();
            int spaces = maxWidth / (int) Math.pow(2, level + 1);

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                for (int s = 0; s < spaces; s++)
                    System.out.print("   ");

                if (curr != null) {
                    System.out.print(curr.data);
                    q.add(curr.left);
                    q.add(curr.right);
                } else {
                    System.out.print(" ");
                    q.add(null);
                    q.add(null);
                }

                for (int s = 0; s < spaces; s++)
                    System.out.print("   ");
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree tree = new AVLTree();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            tree.root = tree.insert(tree.root, sc.nextInt());
        }

        System.out.println("\nAVL Tree Structure:");
        tree.printTree();
    }
}
Output:
Enter number of nodes: 6
Enter node values:
10 23 45 75 98 22 

AVL Tree Structure:
            23            
      10            75      
          22      45      98   
