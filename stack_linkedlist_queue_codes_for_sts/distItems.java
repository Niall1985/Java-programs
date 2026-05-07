import java.util.*;

public class Main {
    static boolean isDistributable(int[]arr, int n, int k){
      for(int i = 0 ; i < n ; i++){
        int count = 0;
        for(int j = 0 ; j < n ; j++){
          if(arr[i] == arr[j]) count++;
          if(count > Math.pow(2, k)) return false;
        }
      }
      return true;
    }
    public static void main(String[] args) {
      int[]arr = {1, 1, 2, 3, 1};
      int k = 2;
      int n = 5;
      if(isDistributable(arr, n, k)){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }
}
