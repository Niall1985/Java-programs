// You are using Java
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<String> Fruits = new ArrayList<String>();
        Fruits.add("Apple");
        Fruits.add("Banana");
        System.out.println("Original Array: Apple Banana ");
        String input = s.next();
        Fruits.add(input);
        System.out.printf("Array after adding a new element: ");
        for(String fruit: Fruits){
            System.out.printf(fruit + " ");
        }
    }
}
