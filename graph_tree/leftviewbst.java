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
    if(root == null){
      return newNode;
    }
    
    Queue<TreeNode>q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
      TreeNode curr = q.poll();
      if(curr.left == null){
        curr.left = newNode;
        break;
      }
      else{
        q.add(curr.left);
      }
      
      if(curr.right == null){
        curr.right = newNode;
        break;
      }
      else{
        q.add(curr.right);
      }
    }
    return root;
  }
  
  static void leftview(TreeNode root){
    if(root == null) return;
    
    Queue<TreeNode>q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
      int size = q.size();
      for(int i = 0 ; i < size ; i++){
        TreeNode curr = q.poll();
        if(i == 0){
          System.out.print(curr.data + " ");
        }
        if(curr.left != null) q.add(curr.left);
        if(curr.right != null) q.add(curr.right);
      }
    }
  }
  
  public static void main(String[] args){
    TreeNode node = null;
    int[] arr = {50, 30, 70, 20, 40, 60, 80};
    for(int x : arr){
      node = insert(node, x);
    }
    leftview(node);
  }
  
}
