import java.util.*;

public class Main{
  static String encrpyt(String plaintext, String key, String alphakey){
    char[] cipher = new char[plaintext.length()];
    for(int i = 0 ; i < plaintext.length() ; i++){
      int indexP = alphakey.indexOf(plaintext.charAt(i));
      int indexK = alphakey.indexOf(key.charAt(i));
      int res = indexP ^ indexK;
      if(res > 26){
        res -= 26;
      }
      cipher[i] = alphakey.charAt(res);
    }
    // System.out.println("Encrypted: " + new String(cipher));
    String ciphertext = new String(cipher);
    return ciphertext;
  }
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String plaintext = sc.next();
    String key = sc.next();
    String alphakey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String ciphertext = encrpyt(plaintext, key, alphakey);
  }
}
