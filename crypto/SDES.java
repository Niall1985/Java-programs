import java.util.*;

public class Main {

    static int[] P10 = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
    static int[] P8  = {6, 3, 7, 4, 8, 5, 10, 9};
    static int[] IP  = {2, 6, 3, 1, 4, 8, 5, 7};
    static int[] IP_INV = {4, 1, 3, 5, 7, 2, 8, 6};
    static int[] EP  = {4, 1, 2, 3, 2, 3, 4, 1};
    static int[] P4  = {2, 4, 3, 1};

    static int[][] S0 = {
        {1, 0, 3, 2},
        {3, 2, 1, 0},
        {0, 2, 1, 3},
        {3, 1, 3, 2}
    };

    static int[][] S1 = {
        {0, 1, 2, 3},
        {2, 0, 1, 3},
        {3, 0, 1, 0},
        {2, 1, 0, 3}
    };


    static int[] permute(int[] input, int[] table) {
        int[] output = new int[table.length];
        for (int i = 0; i < table.length; i++)
            output[i] = input[table[i] - 1];
        return output;
    }

    
    static int[] leftShift(int[] bits, int n) {
        int[] shifted = new int[bits.length];
        for (int i = 0; i < bits.length; i++)
            shifted[i] = bits[(i + n) % bits.length];
        return shifted;
    }

  
    static int[] xor(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++)
            result[i] = a[i] ^ b[i];
        return result;
    }

    static int[][] generateKeys(int[] key) {
        int[] p10 = permute(key, P10);

        int[] left = Arrays.copyOfRange(p10, 0, 5);
        int[] right = Arrays.copyOfRange(p10, 5, 10);

        left = leftShift(left, 1);
        right = leftShift(right, 1);

        int[] k1 = permute(concat(left, right), P8);

        left = leftShift(left, 2);
        right = leftShift(right, 2);

        int[] k2 = permute(concat(left, right), P8);

        return new int[][]{k1, k2};
    }

    static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    static int[] sBox(int[] input, int[][] box) {
        int row = input[0] * 2 + input[3];
        int col = input[1] * 2 + input[2];
        int val = box[row][col];
        return new int[]{
            (val >> 1) & 1,
            val & 1
        };
    }

    static int[] fk(int[] bits, int[] key) {
        int[] left = Arrays.copyOfRange(bits, 0, 4);
        int[] right = Arrays.copyOfRange(bits, 4, 8);

        int[] ep = permute(right, EP);
        int[] xor = xor(ep, key);

        int[] left4 = Arrays.copyOfRange(xor, 0, 4);
        int[] right4 = Arrays.copyOfRange(xor, 4, 8);

        int[] s0 = sBox(left4, S0);
        int[] s1 = sBox(right4, S1);

        int[] p4 = permute(concat(s0, s1), P4);
        int[] resultLeft = xor(left, p4);

        return concat(resultLeft, right);
    }

    static int[] swap(int[] bits) {
        return concat(
            Arrays.copyOfRange(bits, 4, 8),
            Arrays.copyOfRange(bits, 0, 4)
        );
    }

    static int[] encrypt(int[] plaintext, int[] key) {
    int[][] keys = generateKeys(key);

    int[] K1 = keys[0];
    int[] K2 = keys[1];
    System.out.print("\n");
    printBits("Round 1 Key (K1)", K1);
    int[] ip = permute(plaintext, IP);
    int[] fk1 = fk(ip, K1);
    int[] sw = swap(fk1);
    printBits("Round 2 Key (K2)", K2);
    int[] fk2 = fk(sw, K2);
    return permute(fk2, IP_INV);
}

    
    static int[] decrypt(int[] ciphertext, int[] key) {
      int[][] keys = generateKeys(key);
  
      int[] k1 = keys[1];
      int[] k2 = keys[0];
  
      int[] ip = permute(ciphertext, IP);
      int[] fk1 = fk(ip, k1);
      int[] sw = swap(fk1);
      int[] fk2 = fk(sw, k2);
      return permute(fk2, IP_INV);
    }
    
    static void printBits(String label, int[] bits) {
      System.out.print(label + ": ");
      for (int b : bits)
          System.out.print(b);
      System.out.println();
  }


    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String keyStr = sc.next();
    String ptStr = sc.next();

    int[] key = keyStr.chars().map(c -> c - '0').toArray();
    int[] pt = ptStr.chars().map(c -> c - '0').toArray();

    System.out.println("Plaintext: " + ptStr);
    System.out.println("Key: " + keyStr);
    
    int[] cipher = encrypt(pt, key);
    System.out.print("\n");
    System.out.print("Cipher Text: ");
    for (int b : cipher)
        System.out.print(b);

 
    int[] decrypted = decrypt(cipher, key);
    System.out.print("\nDecrypted Text: ");
    for (int b : decrypted)
        System.out.print(b);
}

}
