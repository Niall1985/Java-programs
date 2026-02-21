import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Convert to uppercase immediately to avoid ASCII index errors (e.g., 'a' - 'A' = 32)
        String plaintext = sc.next().toUpperCase();
        String key = sc.next().toUpperCase();
        
        char matrix[][] = new char[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                matrix[i][j] = (char) ('A' + (i + j) % 26);
            }
        }

        int plaintextlen = plaintext.length();
        char plaintextarr[] = plaintext.toCharArray();
        char keyarr[] = key.toCharArray();
        char newkeyarr[] = new char[plaintextlen];

        for (int i = 0; i < plaintextlen; i++) {
            newkeyarr[i] = keyarr[i % keyarr.length];
        }

        // Encryption
        char cipher[] = new char[plaintextlen];
        for (int i = 0; i < plaintextlen; i++) {
            int row = newkeyarr[i] - 'A';
            int col = plaintextarr[i] - 'A';
            cipher[i] = matrix[row][col];
        }

        System.out.println("Encryption: " + String.valueOf(cipher));

        // Decryption
        char plain[] = new char[plaintextlen];
        for (int i = 0; i < plaintextlen; i++) {
            int row = newkeyarr[i] - 'A';
            char target = cipher[i];
            
            // Reversing the matrix lookup: Find which column 'target' is in for this 'row'
            for (int col = 0; col < 26; col++) {
                if (matrix[row][col] == target) {
                    plain[i] = (char) ('A' + col);
                    break;
                }
            }
        }

        System.out.println("Decryption: " + String.valueOf(plain));
    }
}
