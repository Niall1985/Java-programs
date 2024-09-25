// You are using Java
import java.util.Scanner;
public class Main{
    public static void generatePermutations(String str, String res){
        if(str.length() == 0){
            System.out.println(res);
            return;
        }
        
        for(int i = 0; i<str.length(); i++){
            char ChosenCharacter = str.charAt(i);
            String remainingString = str.substring(0,i) + str.substring(i+1);
            generatePermutations(remainingString, res + ChosenCharacter);
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String string = s.next();
        System.out.printf("Permutations of the string:\n");
        generatePermutations(string,"");
    }
}
