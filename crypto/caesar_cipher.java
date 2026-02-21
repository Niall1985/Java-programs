import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      String plaintext = sc.next();
      int pos = sc.nextInt();
      
      char []encrypted = plaintext.toCharArray();
      
      for (int i = 0; i < encrypted.length; i++) {
        char c = encrypted[i];
        if (c >= 'a' && c <= 'z') {
            encrypted[i] = (char) ('a' + (c - 'a' + pos) % 26);
        }
      }
      System.out.println("Encrypted: " + new String(encrypted));
      
      char []decrypted = new char[encrypted.length];
      for(int i = 0 ; i < encrypted.length ; i++){
        char c = encrypted[i];
        if(c >= 'a' && c <= 'z'){
          decrypted[i] = (char) ('a' + (c - 'a' - pos + 26) % 26);
        }
      }
      System.out.println("Decrypted: " + new String(decrypted));
    }
  }
