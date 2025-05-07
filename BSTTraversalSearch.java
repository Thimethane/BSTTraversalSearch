import java.util.Scanner;

public class BSTTraversalSearch {
    
    static class Node {
        int data;
        Node left, right;
        
        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    Node root;

    // Insert node into the BST
    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // In-order traversal
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Pre-order traversal
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Post-order traversal
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Search and count iterations
    public int search(Node root, int key) {
        int iterations = 0;
        while (root != null) {
            iterations++;
            if (key == root.data) {
                System.out.println("Value " + key + " found in " + iterations + " iterations.");
                return iterations;
            } else if (key < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        System.out.println("Value " + key + " not found after " + iterations + " iterations.");
        return iterations;
    }

    // Main method to run in Jeliot
    public static void main(String[] args) {
        BSTTraversalSearch tree = new BSTTraversalSearch();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integers to insert into the BST. Type -1 to finish input:");
        while (true) {
            System.out.print("Enter integer: ");
            int value = scanner.nextInt();
            if (value == -1) {
                break;
            }
            tree.root = tree.insert(tree.root, value);
        }

        // Traversals
        System.out.print("\nIn-order Traversal: ");
        tree.inorder(tree.root);

        System.out.print("\nPre-order Traversal: ");
        tree.preorder(tree.root);

        System.out.print("\nPost-order Traversal: ");
        tree.postorder(tree.root);

        // Search
        System.out.print("\n\nEnter a value to search for: ");
        int searchKey = scanner.nextInt();
        tree.search(tree.root, searchKey);
    }
}
