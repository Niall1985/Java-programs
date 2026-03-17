class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
    }
}

public class RecoverBST {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the two incorrect nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // Left
        inorder(node.left);

        // Process current node
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;   // first violation
            }
            second = node;      // always update second
        }

        prev = node;

        // Right
        inorder(node.right);
    }

    // Utility function
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        RecoverBST obj = new RecoverBST();

        System.out.println("Before Recovery:");
        printInorder(root);

        obj.recoverTree(root);

        System.out.println("\nAfter Recovery:");
        printInorder(root);
    }
}
