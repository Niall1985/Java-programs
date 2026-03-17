static TreeNode insert(TreeNode root, int data) {
    TreeNode newNode = new TreeNode(data);

    if (root == null)
        return newNode;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        TreeNode curr = q.poll();

        // insert at first empty position
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
