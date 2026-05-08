import java.util.*;
public class Main{
  static boolean findsubs(int[]set, int sum, int n, boolean[]chosen, int target){
    if(sum == 0){
      for(int i = 0 ; i < target ; i++){
        if(chosen[i]) System.out.print(set[i] + " ");
      }
      System.out.println();
      return true;
    }
    
    if(n == 0) return false;
    
    boolean found = false;
    
    if(set[n-1] <= sum){
      chosen[n-1] = true;
      found = findsubs(set, sum-set[n-1], n-1, chosen, target);
    }
    chosen[n-1] = false;
    found = findsubs(set, sum, n-1, chosen, target) || found;
    return found;
  }
  public static void main(String[] args){
    int[] set = {1, 2, 3, 4, 5, 6};
    int sum = 9;
    boolean[] chosen = new boolean[set.length];
    
    boolean found = findsubs(set, sum, set.length, chosen, set.length);
    if(found){
      System.out.print("\nYES");
    }
    else{
      System.out.print("\nNO");
    }
  }
}


3 6 
1 2 6 
4 5 
1 3 5 
2 3 4 

YES






import java.util.*;

public class Main {

    static boolean findsubs(int[] set, int sum, int n) {

        // Subset found
        if (sum == 0)
            return true;

        // No elements left
        if (n == 0)
            return false;

        // Include or Exclude
        if (set[n - 1] <= sum) {

            return findsubs(set, sum - set[n - 1], n - 1)
                || findsubs(set, sum, n - 1);
        }

        // Skip current element
        return findsubs(set, sum, n - 1);
    }

    public static void main(String[] args) {

        int[] set = {1, 2, 3, 4, 5, 6};

        int sum = 9;

        boolean found = findsubs(set, sum, set.length);

        if (found)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
