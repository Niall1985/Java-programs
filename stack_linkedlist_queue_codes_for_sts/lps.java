import java.util.*;

public class Main {
  static int lps(String s, int i, int j){
    if(i == j)
      return 1;
      
    if(i > j)
      return 0;
    
    if(s.charAt(i) == s.charAt(j))
      return 2 + lps(s, i+1, j-1);
    
    else
      return Math.max(lps(s, i+1, j), lps(s, i, j-1));
      
  }
    public static void main(String[] args) {
      String s = "bbabcbcab";
      System.out.print("Length: " + lps(s, 0, s.length()-1));
    }
}
