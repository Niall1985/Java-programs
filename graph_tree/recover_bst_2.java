import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class Main {

    static ArrayList<Integer> arr = new ArrayList<>();

    static TreeNode insert(TreeNode root, int data) {

        TreeNode newNode = new TreeNode(data);

        if (root == null)
            return newNode;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode curr = q.poll();

            if (curr.left == null) {
                curr.left = newNode;
                break;
            } else {
                q.add(curr.left);
            }

            if (curr.right == null) {
                curr.right = newNode;
                break;
            } else {
                q.add(curr.right);
            }
        }

        return root;
    }

    static void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);

        arr.add(root.data);

        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeNode root = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String s = sc.next();

            if (!s.equals("null")) {

                int x = Integer.parseInt(s);

                root = insert(root, x);
            }
        }

        inorder(root);

        Collections.sort(arr);

        System.out.println(arr);
    }
}
