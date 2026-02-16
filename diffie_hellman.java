import java.util.Scanner;

public class MultiPartyDH {

    public static long modPow(long base, long exponent, long mod) {
        long result = 1;
        base = base % mod;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            exponent = exponent / 2;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter prime number (p): ");
        long p = sc.nextLong();

        System.out.print("Enter generator (g): ");
        long g = sc.nextLong();

        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();

        long[] privateKeys = new long[n];
        long[] publicKeys = new long[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter secret key for Participant " + (i + 1) + ": ");
            privateKeys[i] = sc.nextLong();
        }

        System.out.println("\nPublic Keys:");
        for (int i = 0; i < n; i++) {
            publicKeys[i] = modPow(g, privateKeys[i], p);
            System.out.println("Participant " + (i + 1) + ": " + publicKeys[i]);
        }

        long exponentProduct = 1;
        for (int i = 0; i < n; i++) {
            exponentProduct *= privateKeys[i];
        }

        long sharedKey = modPow(g, exponentProduct, p);

        System.out.println("\nFinal Shared Key for all participants: " + sharedKey);

        sc.close();
    }
}
