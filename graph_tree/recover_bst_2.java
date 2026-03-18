import java.util.*;

class TreeNode{
  int data;
  TreeNode left, right;
  
  TreeNode(int data){
    this.data = data;
  }
}

public class RecoverBST{

  TreeNode first = null;
  TreeNode second = null;
  TreeNode prev = null;

  static TreeNode insert(TreeNode root, int data){
    TreeNode newNode = new TreeNode(data);

    if(root == null) return newNode;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()){
      TreeNode curr = q.poll();

      if(curr.left == null){
        curr.left = newNode;
        break;
      } else q.add(curr.left);

      if(curr.right == null){
        curr.right = newNode;
        break;
      } else q.add(curr.right);
    }

    return root;
  }

  void recoverTree(TreeNode root){
    inorder(root);

    int temp = first.data;
    first.data = second.data;
    second.data = temp;
  }

  void inorder(TreeNode root){
    if(root == null) return;

    inorder(root.left);

    if(prev != null && prev.data > root.data){
      if(first == null){
        first = prev;
      }
      second = root;
    }

    prev = root;

    inorder(root.right);
  }

  public void printinorder(TreeNode root){
    if(root == null) return;

    printinorder(root.left);
    System.out.print(root.data + " ");
    printinorder(root.right);
  }

  public static void main(String[] args){

    TreeNode root = null;

    root = insert(root,3);
    root = insert(root,1);
    root = insert(root,4);
    root = insert(root,2);

    RecoverBST obj = new RecoverBST();

    System.out.println("Before Recovery:");
    obj.printinorder(root);

    obj.recoverTree(root);

    System.out.println("\nAfter Recovery:");
    obj.printinorder(root);
  }
}
