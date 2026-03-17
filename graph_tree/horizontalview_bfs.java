import java.util.*;

class TreeNode{
  int data;
  TreeNode left, right;
  
  TreeNode(int data){
    this.data = data;
  }
}

public class HorizontalView{
  static TreeNode insert(TreeNode node, int data){
    if(node == null) return new TreeNode(data);
    if(data < node.data) node.left = insert(node.left, data);
    else node.right = insert(node.right, data);
    return node;  
  }
  
  public static void horizontalView(TreeNode node){
    if(node == null) return;
    Queue<TreeNode>q = new LinkedList<>();
    q.add(node);
    while(!q.isEmpty()){
      int size = q.size();
      for(int i = 0 ; i < size ; i++){
        TreeNode curr = q.poll();
        System.out.print(curr.data + " ");
        
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
    horizontalView(node);
  }
}
