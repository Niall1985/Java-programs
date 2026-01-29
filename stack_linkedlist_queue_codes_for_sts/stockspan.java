import java.util.*;
public class Main{
  
  static int[] stockSpan(int[] prices){
    int n = prices.length;
    int[] span = new int[n];
    for(int i = 0 ; i < n ; i++){
      span[i] = 1;
      for(int j = i-1 ; j >= 0 && prices[i] >= prices[j] ; j--){
        span[i]++;
      }
    }
    return span;
  }
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] result = stockSpan(prices);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
