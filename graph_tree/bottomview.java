import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class BottomView {

    static TreeNode insert(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);
        if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    static void bottomView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> hdQ = new LinkedList<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.add(root);
        hdQ.add(0);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int hd = hdQ.poll();

            map.put(hd, curr.data);

            if (curr.left != null) {
                q.add(curr.left);
                hdQ.add(hd - 1);
            }

            if (curr.right != null) {
                q.add(curr.right);
                hdQ.add(hd + 1);
            }
        }

        for (int val : map.values())
            System.out.print(val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] arr = {50, 30, 70, 20, 40, 60, 80};

        for (int x : arr)
            root = insert(root, x);

        bottomView(root);
    }
}
