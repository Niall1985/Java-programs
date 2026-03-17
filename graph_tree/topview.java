import java.util.*;

class TreeNode{
  int data;
  TreeNode left, right;
  
  TreeNode(int data){
    this.data = data;
  }
}

public class TopTraversal{
  static TreeNode insert(TreeNode node, int data){
    if(node == null) return new TreeNode(data);
    if(data < node.data) node.left = insert(node.left, data);
    else node.right = insert(node.right, data);
    return node;
  }
  
  static void topTraversal(TreeNode node){
    if(node == null) return;
    
    Queue<TreeNode>q = new LinkedList<>();
    Queue<Integer>hdq = new LinkedList<>();
    
    TreeMap<Integer, Integer>map = new TreeMap<>();
    
    q.add(node);
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
    topTraversal(node);
  }
}
