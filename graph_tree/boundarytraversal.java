import java.util.*;

class TreeNode{
  int data;
  TreeNode left, right;
  
  TreeNode(int data){
    this.data = data;
  }
}

public class Main{
  static TreeNode insert(TreeNode root, int data){
    TreeNode newNode = new TreeNode(data);
    if(root == null) return newNode;
    
    Queue<TreeNode>q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
      TreeNode curr = q.poll();
      if(curr.left == null){
        curr.left = newNode;
        break;
      } else{
        q.add(curr.left);
      }
      
      if(curr.right == null){
        curr.right = newNode;
        break;
      } else{
        q.add(curr.right);
      }
    }
    return root;
  }
  
  static void boundary(TreeNode root){
    if(root == null) return;
    System.out.print(root.data + " ");
    left(root.left);
    leaves(root.left);
    leaves(root.right);
    right(root.right);
  }
  static void left(TreeNode root){
    if(root == null || root.left == null &&  root.right == null) return;
    System.out.print(root.data + " ");
    if(root.left != null) left(root.left);
    else left(root.right);
  }
  static void right(TreeNode root){
    if(root == null || root.right == null &&  root.left == null) return;
    if(root.right != null) right(root.right);
    else right(root.left);
    System.out.print(root.data + " ");
  }
  
  static void leaves(TreeNode root){
    if(root ==null) return;
    if(root.left == null && root.right == null){
      System.out.print(root.data + " ");
      return;
    }
    leaves(root.left);
    leaves(root.right);
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
