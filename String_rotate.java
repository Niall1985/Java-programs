import java.util.*;

public class SimpleStringRotator {

    public static void main(String[] args) {
        String input = "Hello, world!";
        System.out.println(rotateString(input));
    }

    public static String rotateString(String input) {
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' + 3) % 26 + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + 3) % 26 + 'A');
            }
            
            result += ch;  // Append character to result
        }

        return result;
    }
}
