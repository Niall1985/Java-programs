import java.util.*; 
 
public class Main { 
 
    static String encrypt(String text, int key) { 
        int len = text.length(); 
        char[][] rail = new char[key][len]; 
 
        for (int i = 0; i < key; i++) { 
            Arrays.fill(rail[i], '.'); 
        } 
 
        int row = 0; 
        boolean movingDown = false; 
 
        for (int i = 0; i < len; i++) { 
            rail[row][i] = text.charAt(i); 
 
            if (row == 0 || row == key - 1) { 
                movingDown = !movingDown; 
            } 
            row += movingDown ? 1 : -1; 
        } 
 
        System.out.println("Encryption Matrix:"); 
        for (int i = 0; i < key; i++) { 
            for (int j = 0; j < len; j++) { 
                System.out.print(rail[i][j] + " "); 
            }
            
            System.out.println(); 
        } 
 
        StringBuilder cipher = new StringBuilder(); 
        for (int i = 0; i < key; i++) { 
            for (int j = 0; j < len; j++) { 
                if (rail[i][j] != '.') { 
                    cipher.append(rail[i][j]); 
                } 
            } 
        } 
        return cipher.toString(); 
    } 
 
    static String decrypt(String cipher, int key) { 
        int len = cipher.length(); 
        char[][] rail = new char[key][len]; 
        for (int i = 0; i < key; i++) { 
            Arrays.fill(rail[i], '.'); 
        } 
        boolean movingDown = false; 
        int row = 0; 
        for (int i = 0; i < len; i++) { 
            rail[row][i] = '*'; 
 
            if (row == 0 || row == key - 1) { 
                movingDown = !movingDown; 
            } 
            row += movingDown ? 1 : -1; 
        } 
        int index = 0; 
        for (int i = 0; i < key; i++) { 
            for (int j = 0; j < len; j++) { 
                if (rail[i][j] == '*' && index < len) { 
                    rail[i][j] = cipher.charAt(index++); 
                } 
            } 
        } 
        
        System.out.println("Decryption Matrix:"); 
        for (int i = 0; i < key; i++) { 
            for (int j = 0; j < len; j++) { 
                System.out.print(rail[i][j] + " "); 
            } 
            System.out.println(); 
        } 
        StringBuilder plain = new StringBuilder(); 
        movingDown = false; 
        row = 0; 
 
        for (int i = 0; i < len; i++) { 
            plain.append(rail[row][i]); 
 
            if (row == 0 || row == key - 1) { 
                movingDown = !movingDown; 
            } 
            row += movingDown ? 1 : -1; 
        } 
        return plain.toString(); 
    } 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        String text = sc.next(); 
        
        int key = sc.nextInt(); 
        String encrypted = encrypt(text, key); 
        System.out.println("Encrypted Text:" + encrypted); 
        System.out.print("\n"); 
        String decrypted = decrypt(encrypted, key); 
        System.out.println("Decrypted Text:" + decrypted); 
    } 
} 
