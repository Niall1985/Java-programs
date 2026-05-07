import java.util.*;

public class Main{
  public static void main(String[] args){
    int []arr = {8, 17, 6, 25, 15, 45, 41, 54};
    int n = arr.length;
    int []lis = new int[n+1];
    lis[0] = 1;
    int max = 1;
    for(int i = 1 ; i < n ; i++){
      if(arr[i] > arr[i-1]){
        lis[i] = max + 1;
        if(lis[i] > max) max = lis[i];
      }
      else{
        lis[i] = max-1;
      }
    }
    for(int x : lis){
      System.out.print(x + " ");
    }
    System.out.print("\nMax subseq: " + lis[n-1]);
  }
}
