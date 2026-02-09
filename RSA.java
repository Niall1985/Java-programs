import java.util.*;
import java.math.BigInteger;

public class Main {
    public static int GCD(int a, int b) {
        while (b != 0) {
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
        BigInteger N = BigInteger.valueOf(P).multiply(BigInteger.valueOf(Q));
        int plain = sc.nextInt();
        int totient = (P - 1) * (Q - 1);
        System.out.println("Totient: " + totient);
        int e = 0;

        for (int i = 2; i <= totient; i++) {
            int gcdval = GCD(i, totient);
            if (gcdval == 1) {
                e = i;
                break;
            }
        }
        System.out.println("(e, n): (" + e + ", " + N + ")");

        int d = 0;
        for (int i = 2; i < totient; i++) {
            if (((e * i) % totient) == 1) {
                d = i;
                break;
            }
        }
        System.out.println("(d, n): (" + d + ", " + N + ")");

        BigInteger bigPlain = BigInteger.valueOf(plain);
        BigInteger bigE = BigInteger.valueOf(e);
        BigInteger cipher = bigPlain.modPow(bigE, N);
        System.out.println("Cipher: " + cipher);

        BigInteger bigD = BigInteger.valueOf(d);
        BigInteger decrypted = cipher.modPow(bigD, N);
        int plaintext = decrypted.intValue();
        System.out.println("Plaintext: " + plaintext);
    }
}
