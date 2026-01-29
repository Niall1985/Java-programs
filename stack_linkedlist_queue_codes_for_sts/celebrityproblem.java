import java.util.*;

public class Main{
  static int celebrity(int[][]M, int n){
  int candidate = 0;
  for(int i = 1 ; i < n ; i++){
    if(M[candidate][i] == 1){
      candidate = i;
    }
  }
  
  for(int i = 0 ; i < n ; i++){
    if(i != candidate){
      if(M[candidate][i] == 1 || M[i][candidate] == 0){
        return -1;
      }
    }
  }
  return candidate;
}

  public static void main(String[] args){
    int[][] M = {
            {0, 1, 1},
            {0, 0, 1},
            {0, 0, 0}
        };

        int result = celebrity(M, 3);
        System.out.println(result);
  }
}
