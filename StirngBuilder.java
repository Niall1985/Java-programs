// You are using Java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        StringBuilder sbl = new StringBuilder(str);
        sbl.reverse();
        String reversed = sbl.toString();
        System.out.printf("%s", reversed);
    }
}
