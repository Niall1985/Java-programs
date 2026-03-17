import java.util.*;

class TreeNode{
  int data;
  TreeNode left, right;
  
  TreeNode(int data){
    this.data = data;
  }
}

public class BoundaryTraversal{
  static TreeNode insert(TreeNode node, int data){
    if(node == null) return new TreeNode(data);
    if(data < node.data) node.left = insert(node.left, data);
    else node.right = insert(node.right, data);
    return node;
  }
  
  static void boundary(TreeNode node){
    if(node == null)return;
    System.out.print(node.data + " ");
    left(node.left);
    leaves(node.left);
    leaves(node.right);
    right(node.right);
  }
  
  static void left(TreeNode node){
    if(node == null || (node.left == null && node.right == null)) return;
    System.out.print(node.data + " ");
    if(node.left != null) left(node.left);
    else left(node.right);
  }
  static void right(TreeNode node){
    if(node == null || (node.left == null && node.right == null)) return;
    if(node.right != null) right(node.right);
    else right(node.left);
    System.out.print(node.data + " ");
  }
  static void leaves(TreeNode node){
    if(node == null) return;
    if(node.left == null && node.right == null){
      System.out.print(node.data + " ");
      return;
    }
    leaves(node.left);
    leaves(node.right);
  }
  
  public static void main(String[] args){
    TreeNode node = null;
    int[] arr = {50, 30, 70, 20, 40, 60, 80};
    for(int x : arr){
      node = insert(node, x);
    }
    boundary(node);
  }
}
