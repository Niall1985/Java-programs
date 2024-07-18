import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
      Scanner data = new Scanner(System.in);
      System.out.println("Enter weight in kgs:");
      float user_weight = data.nextFloat();
      // System.out.println("Weight:"+ user_weight);
      System.out.println("Enter height in meters:");
      float user_height = data.nextFloat();
      // System.out.println("Height:"+ user_height);
      float user_height_for_bmi= user_height*user_height;
      float bmi = user_weight/user_height_for_bmi;
      System.out.println("BMI:"+ bmi);
      
      if (bmi<16){
        System.out.println("Severely Underweight");
      }
      else if (bmi>=16 &&bmi<18){
        System.out.println("Underweight");
      }
      else if (bmi>=18 &&bmi<24){
        System.out.println("Normal");
      }
      else if (bmi>=24 &&bmi<30){
        System.out.println("Overweight");
      }
      else if (bmi>=30){
        System.out.println("Overweight");
      }
    }
}
