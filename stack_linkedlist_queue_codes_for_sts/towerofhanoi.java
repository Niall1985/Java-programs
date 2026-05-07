import java.util.*;

public class Main {
    static int moves = 0;
    
    static void toh(int n, char src, char aux, char dest){
      if(n == 1){
        System.out.println("Move " + n + " from " + src + " To " + dest);
        moves++;
        return;
        }
        toh(n-1, src, dest, aux);
        System.out.println("Move " + n + " from " + src + " To " + dest);
        moves++;
        toh(n-1, aux, src, dest);
        return;
    }
    public static void main(String[] args) {
      toh(3, 'A', 'B', 'C');
      System.out.println("Moves: " + moves);
    }
}
