import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner weight = new Scanner(System.in);
      System.out.println("Enter weight in kgs:");
      float user_weight = weight.nextFloat();
      // System.out.println("Weight:"+ user_weight);
      Scanner height = new Scanner(System.in);
      System.out.println("Enter height in meters:");
      float user_height = height.nextFloat();
      // System.out.println("Height:"+ user_height);
      float user_height_for_bmi= user_height*user_height;
      float bmi = user_weight/user_height_for_bmi;
      System.out.println("BMI:"+ bmi);
    }
}
