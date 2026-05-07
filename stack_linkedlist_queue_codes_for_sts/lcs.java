public class Main{
  static void lcs(String X, String Y){
    int m = X.length();
    int n = Y.length();
    int [][]L = new int[m+1][n+1];
    for(int i = 1 ; i <= m ; i++){
      for(int j = 1 ; j <= n ; j++){
        if(X.charAt(i-1) == Y.charAt(j-1)){
          L[i][j] = 1 + L[i-1][j-1];
        }
        else{
          L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
        }
      }
    }
    System.out.print("Size: " + L[m][n]);
    
    int i = m, j=n;
    StringBuilder sb = new StringBuilder();
    while(i>0 && j > 0){
      if(X.charAt(i-1) == Y.charAt(j-1)){
        sb.append(X.charAt(i-1));
        i--;
        j--;
      }
      else if(L[i-1][j] > L[i][j-1]){
        i--;
      }
      else{
        j--;
      }
    }
    System.out.print(sb.reverse().toString());
  }
  public static void main(String[] args){
    String X = "ABCDGH";
    String Y = "AEDFHR";
    lcs(X, Y);
  }
}
