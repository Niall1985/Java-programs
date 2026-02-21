import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int key = sc.nextInt();
        
        int len = text.length();
        char[][] rail = new char[key][len];
        
        for (int i = 0; i < key; i++) Arrays.fill(rail[i], '\0');

        int row = 0;
        boolean movingDown = false;

        for (int i = 0; i < len; i++) {
            rail[row][i] = text.charAt(i);

            if (row == 0 || row == key - 1) {
                movingDown = !movingDown;
            }

            row += movingDown ? 1 : -1;
        }

        for (int i = 0; i < key; i++) {
            for (int j = 0; j < len; j++) {
                if (rail[i][j] != '\0') {
                    System.out.print(rail[i][j]);
                } else {
                    System.out.print("."); 
                }
            }
            System.out.println();
        }
    }
}
