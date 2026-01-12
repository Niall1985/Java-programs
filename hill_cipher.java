import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String text = sc.next();
    String key = sc.next();
    String alphakey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int [][]matrix = new int[text.length()][text.length()];
    int index = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
          if (index < key.length()) {
              matrix[i][j] = alphakey.indexOf(key.charAt(index));
              index++;
          }
      }
    }
    System.out.println("Key Matrix");
    for(int i = 0 ; i < text.length() ; i++){
      for(int j = 0 ; j < text.length() ; j++){
        System.out.printf("%d ", matrix[i][j]);
      }
      System.out.printf("\n");
    }
    System.out.printf("\n");
    
    int[][] textmatrix = new int[text.length()][1];
    for (int i = 0; i < text.length(); i++) {
        textmatrix[i][0] = alphakey.indexOf(text.charAt(i));
    }
    System.out.println("Text Matrix");
    for (int i = 0; i < text.length(); i++) {
        System.out.printf("%d\n", textmatrix[i][0]);
    }
    System.out.printf("\n");
    
    int result[][] = new int[text.length()][1];
    for(int i = 0 ; i < text.length() ; i++){
      result[i][0] = 0;
      for(int j = 0 ; j < text.length() ; j++){
        result[i][0] += (matrix[i][j] * textmatrix[j][0]);
      }
      result[i][0] %= 26;
    }
    
    
    
    System.out.println("Cipher Matrix");
    for(int i = 0 ; i < text.length() ; i++){
      System.out.printf("%d\n", (result[i][0]));
    }
    
    char original[] = new char[text.length()];
    System.out.println("\nCipher Text");
    for(int i = 0 ; i < text.length() ; i++){
      original[i] = alphakey.charAt(result[i][0]);
    }
    System.out.print("Encrypted Text: " + new String(original));
  }
}
