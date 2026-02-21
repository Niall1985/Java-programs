import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      String plaintext = sc.next();
      int shift = sc.nextInt();
      int ascii_range = 128;
      shift = shift % ascii_range;
      
      char []encrypted = new char[plaintext.length()];
      for(int i = 0 ; i < plaintext.length() ; i++){
        encrypted[i] = (char)((plaintext.charAt(i) + shift) % ascii_range);
      }
      System.out.println("Encrypted: " + new String(encrypted));
      
      char []decrypted = new char[plaintext.length()];
      for(int i = 0 ; i < encrypted.length ; i++){
        decrypted[i] = (char)((encrypted[i] - shift + ascii_range) % ascii_range);
      }
      System.out.println("Decrypted: " + new String(decrypted));
    }
  }
