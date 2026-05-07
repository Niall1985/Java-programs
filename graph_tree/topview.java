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
  
  static void topview(TreeNode root){
    if(root == null) return;
    Queue<TreeNode>q = new LinkedList<>();
    Queue<Integer>hdq = new LinkedList<>();
    TreeMap<Integer, Integer>map = new TreeMap<>();
    
    q.add(root);
    hdq.add(0);
    
    while(!q.isEmpty()){
      TreeNode curr = q.poll();
      int hd = hdq.poll();
      if(!map.containsKey(hd)){
        map.put(hd, curr.data);
      }
      
      if(curr.left != null){
        q.add(curr.left);
        hdq.add(hd-1);
      }
      if(curr.right != null){
        q.add(curr.right);
        hdq.add(hd+1);
      }
    }
    
    for(int val : map.values()){
      System.out.print(val + " ");
    }
  }
  public static void main(String[] args){
    TreeNode node = null;
    int[] arr = {50, 30, 70, 20, 40, 60, 80};
    for(int x : arr){
      node = insert(node, x);
    }
    topview(node);
  }
}
