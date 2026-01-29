//largest number
import java.util.*;
public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] arr = new String[n];
    for(int i = 0 ; i < n ; i++){
      arr[i] = sc.next();
    }
    Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
    StringBuilder sb = new StringBuilder();
    for(String s : arr){
      sb.append(s);
    }
    String result = sb.toString();
    if(result.charAt(0) == '0'){
      result = "0";
    }
    System.out.println(result);
  }
}

//freqwise
import java.util.*;
public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Integer[] arr = new Integer[n];
    for(int i = 0 ; i < n ; i++){
      arr[i] = sc.nextInt();
    }
    Map<Integer, Integer>freq = new HashMap<>();
    for(int x : arr){
      freq.put(x, freq.getOrDefault(x,0) + 1);
    }
    Arrays.sort(arr, (a,b)->{
      int f1 = freq.get(a), f2 = freq.get(b);
      if(f1 != f2) return f1 - f2;
      return a - b;
    });
    
    for(int x : arr){
      System.out.print(x + " ");
    }
  }
}
