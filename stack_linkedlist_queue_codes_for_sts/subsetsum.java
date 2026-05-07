import java.util.*;
public class Main {
    static void findAllSubsets(int[] set, int sum, int n, boolean[] chosen, int total) {
        // Found a valid subset — print it and continue searching
        if (sum == 0) {
            System.out.print("Subset found: ");
            for (int i = 0; i < total; i++)  // use total (original length) for printing
                if (chosen[i]) System.out.print(set[i] + " ");
            System.out.println();
            return;
        }

        if (n == 0) return;

        // Include current element
        if (set[n-1] <= sum) {
            chosen[n-1] = true;
            findAllSubsets(set, sum - set[n-1], n - 1, chosen, total);
        }

        // Exclude current element (always explore this too)
        chosen[n-1] = false;
        findAllSubsets(set, sum, n - 1, chosen, total);
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3, 4, 5, 6};
        int sum = 9;
        int n = set.length;
        boolean[] chosen = new boolean[n];

        findAllSubsets(set, sum, n, chosen, n);  // pass n as total
    }
}





import java.util.*;

public class Main {
  static boolean subsetcheck(int[]set, int sum, int n){
    if(sum == 0) return true;
    if(n == 0) return false;
    if(set[n-1] <= sum){
      return subsetcheck(set, sum-set[n-1], n-1);
    } else{
      return subsetcheck(set, sum, n-1);
    }
  }
    public static void main(String[] args) {
      int[]arr = {1,2,3,4,5};
      if(subsetcheck(arr, 5, 5)){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }
}
