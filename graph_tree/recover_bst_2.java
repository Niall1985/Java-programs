import java.util.*;

class TreeNode{
  int val;
  TreeNode left, right;
  
  TreeNode(int v){
    val = v;
  }
}

class RecoverBst{
  TreeNode first = null;
  TreeNode second = null;
  TreeNode prev = null;
  
  public void recoverTree(TreeNode root){
    inorder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }
  
  public void inorder(TreeNode node){
    if(node == null) return;
    
    inorder(node.left);
    if(prev != null && prev.val > node.val){
      if(first == null){
        first = prev;
      }
      second = node;
    }
    prev = node;
    
    inorder(node.right);
  }
  
  public void printinorder(TreeNode root){
    if(root == null) return;
    
    printinorder(root.left);
    System.out.print(root.val + " ");
    printinorder(root.right);
  }
}

public class Main{
  public static void main(String []args){
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left= new TreeNode(2);
    
    RecoverBst obj = new RecoverBst();
    System.out.println("BST Before recovery: ");
    obj.printinorder(root);
    System.out.println("\nBST after recovery: ");
    obj.recoverTree(root);
    obj.printinorder(root);
  }
}
