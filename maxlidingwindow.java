import java.util.*;
public class Main{
  public static void main(String[] args){
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int n = nums.length;
    int[] res = new int[n-k+1];
    
    for(int i = 0 ; i <= n-k ; i++){
      int max = nums[i];
      for(int j = i ; j < i + k ; j++){
        if(nums[j] > max){
          max = nums[j];
        }
      }
      res[i] = max;
    }
    
    for(int i : res){
      System.out.print(i + " ");
    }
  }
}
