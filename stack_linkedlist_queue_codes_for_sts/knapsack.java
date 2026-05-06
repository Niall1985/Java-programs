import java.util.*;

public class Main {
  static int knapsack(int[] weights, int []values, int capacity, int n){
    if(n==0 || capacity == 0) return 0;
    if(weights[n-1] > capacity){
      return knapsack(weights, values, capacity, n-1);
    }
    int take = values[n-1] + knapsack(weights, values, capacity-weights[n-1], n-1);
    int skip = knapsack(weights, values, capacity, n-1);
    
    return Math.max(take, skip);
  }
  
  public static void main(String[] args){
    int[] weights = {2, 3, 4};
    int[] values = {3, 4, 5};
    int capacity = 5;
    int n = weights.length;
    int max = knapsack(weights, values, capacity, n);
    System.out.println(max);
  }
}
