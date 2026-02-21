import java.util.*;

public class Main{
  static char[][]generatedMatrix(String key){
    key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
    boolean[]used = new boolean[26];
    char[][]matrix = new char[5][5];
    int row = 0, col = 0;
    for(char c : key.toCharArray()){
      if(!used[c-'A']){
        matrix[row][col++] = c;
        used[c-'A'] = true;
        if(col == 5){
          col = 0;
          row++;
        }
      }
    }
    for(char c = 'A' ; c <= 'Z' ; c++){
      if(c == 'J') continue;
      if(!used[c-'A']){
        matrix[row][col++] = c;
        if(col == 5){
          col = 0;
          row++;
        }
      }
    }
    return matrix;
  }
  
  static String prepareText(String text){
    text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0 ; i < text.length() ; i++){
      sb.append(text.charAt(i));
      if(i+1 < text.length() && text.charAt(i) == text.charAt(i+1)){
        sb.append('X');
      }
    }
    if(sb.length() % 2 != 0) sb.append('X');
    
    return sb.toString();
  }
  
  static int[] findPos(char[][]matrix, char c){
    for(int i = 0 ; i < 5 ; i++){
      for(int j = 0 ; j < 5 ; j++){
        if(matrix[i][j] == c){
          return new int[]{i, j};
        }
      }
    }
    return null;
  }
  
  static String encrypt(String text, char[][]matrix){
    StringBuilder result = new StringBuilder();
    for(int i = 0 ; i < text.length() ; i += 2){
      char a = text.charAt(i);
      char b = text.charAt(i+1);
      
      int[] posA = findPos(matrix, a);
      int[] posB = findPos(matrix, b);
      
      if(posA[0] == posB[0]){
        result.append(matrix[posA[0]][(posA[1] + 1) % 5]);
        result.append(matrix[posB[0]][(posB[1] + 1) % 5]);
      }
      
      else if(posA[1] == posB[1]){
        result.append(matrix[(posA[0] + 1) % 5][posA[1]]);
        result.append(matrix[(posB[0] + 1) % 5][posB[1]]);
      }
      else{
        result.append(matrix[posA[0]][posB[1]]);
        result.append(matrix[posB[0]][posA[1]]);
      }
    }
    return result.toString();
  }
  
  static String decrypt(String text, char[][]matrix){
    StringBuilder result = new StringBuilder();
    for(int i = 0 ; i < text.length() ; i += 2){
      char a = text.charAt(i);
      char b = text.charAt(i+1);
      
      int[] posA = findPos(matrix, a);
      int[] posB = findPos(matrix, b);
      
      if(posA[0] == posB[0]){
        result.append(matrix[posA[0]][(posA[1] + 4) % 5]);
        result.append(matrix[posB[0]][(posB[1] + 4) % 5]);
      }
      
      else if(posA[1] == posB[1]){
        result.append(matrix[(posA[0] + 4) % 5][posA[1]]);
        result.append(matrix[(posB[0] + 4) % 5][posB[1]]);
      }
      else{
        result.append(matrix[posA[0]][posB[1]]);
        result.append(matrix[posB[0]][posA[1]]);
      }
    }
    return result.toString();
  }
  
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String key = sc.nextLine();
      String plaintext = sc.nextLine();
      char[][]matrix = generatedMatrix(key);
      
      String prepared = prepareText(plaintext);
      String encrypted = encrypt(prepared, matrix);
      String decrypted = decrypt(encrypted, matrix);
      
      System.out.println("Encrypted: " + encrypted);
      System.out.println("Decrypted: " + decrypted);
  }
}
