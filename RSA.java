import java.util.*;

public class Main {
  public static int GCD(int a, int b){
    while(b != 0){
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int P = sc.nextInt();
      int Q = sc.nextInt();
      int N = P*Q;
      int plain = sc.nextInt();
      int totient = (P-1) * (Q-1);
      int e = 0;
      
      for(int i = 2 ; i <= totient ; i++){
        int gcdval = GCD(i, totient);
        if(gcdval == 1){
          e = i;
          break;
        }
      }
      System.out.println("(e, n): (" + e + ", " + N + ")");
      
      int d = 0;
      for(int i = 2 ; i < totient ; i++){
        if(((e * i) / totient) == 1){
          d = i;
          break;
        }
      }
      System.out.println("(d, n): (" + d + ", " + N + ")");
      
      int cipher = (int)Math.pow(plain, e);
      cipher = cipher % totient;
      System.out.println("Cipher: " + cipher);
      
      int plaintext = (int)Math.pow(cipher, d);
      plaintext = plaintext % N;
      System.out.println("Plaintext: " + plaintext);
    }
}
