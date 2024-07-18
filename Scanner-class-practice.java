import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
      Scanner data = new Scanner(System.in);
      // System.out.println("Enter Name:");
      String user_name = data.nextLine();
      // System.out.println("Enter Age:");
      int user_age = data.nextInt();
      // System.out.println("Enter your salary:");
      double user_salary = data.nextDouble();
      System.out.println("User Details:\n"+ user_name + "\n"+ user_age + "\n" + user_salary);
    }
}
