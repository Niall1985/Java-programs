import java.util.*;
public class Main{
  static String encrypt(String text, int key){
    char [][]rail = new char[key][text.length()];
    char []textarr = text.toCharArray();
    for(int i = 0 ; i < key ; i++){
      Arrays.fill(rail[i], '.');
    }
    int row = 0;
    boolean movedown = false;
    for(int i = 0 ; i < text.length() ; i++){
      rail[row][i] = textarr[i];
      if(row == 0 || row == key - 1){
        movedown = !movedown;
      }
      row += movedown ? 1 : -1;
    }
    System.out.println("Encryption Matrix:"); 
    for (int i = 0; i < key; i++) { 
      for (int j = 0; j < text.length(); j++) { 
        System.out.print(rail[i][j] + " "); 
      }
      System.out.println(); 
    } 
    
    StringBuilder cipherstring = new StringBuilder();
    for(int i = 0 ; i < key ; i++){
      for(int j = 0 ; j < text.length() ; j++){
        if(rail[i][j] != '.'){
          cipherstring.append(rail[i][j]);
        }
      }
    }
    String ciphertext = cipherstring.toString();
    return ciphertext;
  }
  
  static String decrypt(String ciphertext, int key){
    char[][]rail = new char[key][ciphertext.length()];
    for(int i = 0 ; i < key ; i++){
      Arrays.fill(rail[i], '.');
    }
    int row = 0;
    boolean movedown = false;
    for(int i = 0 ; i < ciphertext.length() ; i++){
      rail[row][i] = '*';
      if(row == 0 || row == key - 1){
        movedown = !movedown;
      }
      row += movedown ? 1 : -1;
    }
    
    int index = 0;
    for(int i = 0 ; i < key ; i++){
      for(int j = 0 ; j < ciphertext.length() ; j++){
        if(rail[i][j] == '*' && index < ciphertext.length()){
          rail[i][j] = ciphertext.charAt(index++);
        }
      }
    }
    System.out.println("\nDecryption Matrix:"); 
    for (int i = 0; i < key; i++) { 
        for (int j = 0; j < ciphertext.length(); j++) { 
            System.out.print(rail[i][j] + " "); 
        } 
        System.out.println(); 
    }
    
    StringBuilder decryptedtext = new StringBuilder();
    int row1 = 0;
    boolean movedown1 = false;
    for(int i = 0 ; i < ciphertext.length() ; i++){
      if(rail[row1][i] != '.'){
        decryptedtext.append(rail[row1][i]);
      }
      if(row1 == 0 || row1 == key - 1){
        movedown1 = !movedown1;
      }
      row1 += movedown1 ? 1 : -1;
    }
    
    String decryptedstring = decryptedtext.toString();
    return decryptedstring;
  }
  public static void main(String []args){
    String ciphertext = encrypt("HELLOWORLD", 3);
    System.out.println("Cipher: " + ciphertext);
    String decryptedtext = decrypt("HOLELWRDLO", 3);
    System.out.println("Decrypted Message: " + decryptedtext);
  }
}
