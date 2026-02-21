import java.util.*;

public class Main {

    // Fast modular exponentiation
    public static long power(long a, long b, long P) {
        long result = 1;
        a = a % P;

        while (b > 0) {
            if (b % 2 == 1)
                result = (result * a) % P;

            a = (a * a) % P;
            b = b / 2;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int users = sc.nextInt();
        long P = sc.nextLong();
        long G = sc.nextLong();

        long[] privateKey = new long[users];
        long[] value = new long[users];

        for (int i = 0; i < users; i++) {
            privateKey[i] = sc.nextLong();
        }

        for (int i = 0; i < users; i++) {
            value[i] = G;
        }
        
        for (int round = 0; round < users; round++) {

            long[] newValue = new long[users];

            for (int i = 0; i < users; i++) {

                long computed = power(value[i], privateKey[i], P);
                System.out.println("Computed keys: " + computed);
                int nextUser = (i + 1) % users;
                newValue[nextUser] = computed;
            }

            value = newValue;
        }

        System.out.println("\nFinal Shared Keys:");
        for (int i = 0; i < users; i++) {
            System.out.println("User " + (i + 1) + ": " + value[i]);
        }

        sc.close();
    }
}
