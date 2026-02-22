import java.util.*;
public class Main{
  public static void main(String[] args){
    String key = "ZEBRA";
    String text = "ATTACKATDAWN";
    char[]keyarr = key.toCharArray();
    char[]originalkeyarr = key.toCharArray();
    int[]order = new int[key.length()];
    Arrays.sort(keyarr);
    // for(char c : keyarr){
    //   System.out.print(c + " ");
    // }
    for(int i = 0 ; i < keyarr.length ; i++){
      for(int j = 0 ; j < keyarr.length ; j++){
        if(keyarr[i] == originalkeyarr[j]){
          order[i] = j;
        }
      }
    }
    // System.out.println(keymap);
    int col = key.length();
    int row = (int)Math.ceil((double)text.length() / col);
    row = row+1;
    System.out.println(row);
    char [][]matrix = new char[row][col];
    for(int i = 0 ; i < col ; i++){
      matrix[0][i] = originalkeyarr[i];
    }
    int index = 0;
    for(int i = 1 ; i < row ; i++){
      for(int j = 0 ; j < col ; j++){
        if(index < text.length()){
            matrix[i][j] = text.charAt(index++);
        } else {
            matrix[i][j] = 'X';
        }
      }
    }
    
    for(int i = 0 ; i < row ; i++){
      for(int j = 0 ; j < col ; j++){
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    
    StringBuilder cipher = new StringBuilder();
    for(int k = 0 ; k < order.length ; k++){
    int colIndex = order[k];  // column to read
    
    for(int i = 1 ; i < row ; i++){  // skip key row
        cipher.append(matrix[i][colIndex]);
        }
    }
    
    System.out.println("Ciphertext: " + cipher.toString());
    String cipherText = cipher.toString();

    char[][] decryptMatrix = new char[row][col];
    
    // Put key row again (optional, just for clarity)
    for(int i = 0 ; i < col ; i++){
        decryptMatrix[0][i] = originalkeyarr[i];
    }
    
    int cipherIndex = 0;
    
    // Fill column by column using order[]
    for(int k = 0 ; k < order.length ; k++){
        int colIndex = order[k];
        
        for(int i = 1 ; i < row ; i++){
            decryptMatrix[i][colIndex] = cipherText.charAt(cipherIndex++);
        }
    }
    
    // Print matrix (optional)
    System.out.println("\nDecryption Matrix:");
    for(int i = 0 ; i < row ; i++){
        for(int j = 0 ; j < col ; j++){
            System.out.print(decryptMatrix[i][j] + " ");
        }
        System.out.println();
    }
    
    // Read row-wise to get original text
    StringBuilder decrypted = new StringBuilder();
    
    for(int i = 1 ; i < row ; i++){
        for(int j = 0 ; j < col ; j++){
            decrypted.append(decryptMatrix[i][j]);
        }
    }
    
    System.out.println("Decrypted Text: " + decrypted.toString());
  }
}
